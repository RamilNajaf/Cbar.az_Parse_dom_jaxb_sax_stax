package Stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import Domain.Cbar;
import Domain.Currency;

public class StaxParserMain {

	private Currency currency;
	private String tempType;
	private boolean name = false;
	private boolean nominal = false;
	private boolean value = false;

	public static void main(String[] args) {

		List<Currency> CurList = new ArrayList<>();

		Currency currency = null;
		String tempType = null;
		boolean name = false;
		boolean nominal = false;
		boolean value = false;

		try {
			URL url = new URL(Cbar.URL);
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(url.openStream());

			while (reader.hasNext()) {
				if (reader.isStartElement()) {
					String LocalName = reader.getLocalName();
					if (LocalName.equals("ValCurs")) {
						Currency.setDate(reader.getAttributeValue(0));
						Currency.setGeneralName(reader.getAttributeValue(1));
						Currency.setDescription(reader.getAttributeValue(2));
					} else if (LocalName.equals("ValType")) {
						tempType = reader.getAttributeValue(0);
					} else if (LocalName.equals("Valute")) {
						currency = new Currency();
						currency.setType(tempType);
						currency.setCode(reader.getAttributeValue(0));
					} else if (LocalName.equals("Nominal")) {
						nominal = true;
					} else if (LocalName.equals("Value")) {
						value = true;
					} else if (LocalName.equals("Name")) {
						name = true;

					}
				} else if (reader.isCharacters()) {
					String text = reader.getText();
					if (nominal == true) {
						currency.setNominal(text);
					} else if (value == true) {
						currency.setValue(new BigDecimal(text));
					} else if (name == true) {
						currency.setName(text);
					}
				} else if (reader.isEndElement()) {
					String LocalName = reader.getLocalName();
					if (LocalName.equals("Valute")) {
						CurList.add(currency);
					} else if (LocalName.equals("Nominal")) {
						nominal = false;
					} else if (LocalName.equals("Value")) {
						value = false;
					} else if (LocalName.equals("Name")) {
						name = false;

					}
				}
				reader.next();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Currency.setMap(CurList.stream().collect(Collectors.groupingBy(Currency::getType)));
		Currency.show();

	}
}
