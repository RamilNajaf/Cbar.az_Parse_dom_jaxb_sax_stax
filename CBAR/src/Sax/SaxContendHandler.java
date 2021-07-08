package Sax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import Domain.Currency;

public class SaxContendHandler extends DefaultHandler {
	private List<Currency> CurList = new ArrayList<Currency>();
	private String tempType;
	private Currency currency;

	private boolean name = false;
	private boolean nominal = false;
	private boolean value = false;

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName == "ValCurs") {
			Currency.setDate(attributes.getValue("Date"));
			Currency.setGeneralName(attributes.getValue("Name"));
			Currency.setDescription(attributes.getValue("Description"));
		} else if (qName == "ValType") {
			tempType = attributes.getValue("Type");
		} else if (qName == "Valute") {
			currency = new Currency();
			currency.setType(tempType);
			currency.setCode(attributes.getValue("Code"));
		} else if (qName == "Nominal") {
			nominal = true;
		} else if (qName == "Value") {
			value = true;
		} else if (qName == "Name") {
			name = true;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch, start, length);
		if (nominal == true) {
			currency.setNominal(data);
		} else if (value == true) {
			currency.setValue(new BigDecimal(data));
		} else if (name == true) {
			currency.setName(data);
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName == "Valute") {
			CurList.add(currency);
		} else if (qName == "Nominal") {
			nominal = false;
		} else if (qName == "Value") {
			value = false;
		} else if (qName == "Name") {
			name = false;
		}
	}

	@Override
	public void endDocument() throws SAXException {

	}

	public List<Currency> getCurList() {
		return CurList;
	}

	public void setCurList(List<Currency> curList) {
		CurList = curList;
	}

}
