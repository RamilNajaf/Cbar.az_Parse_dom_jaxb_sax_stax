package Dom;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Domain.Cbar;
import Domain.Currency;

public class DomParseMain {

	public static void main(String[] args) {
		List<Currency> CurrencyList = new ArrayList<>();

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(Cbar.URL);

			Element rootElement = document.getDocumentElement();

			Currency.setGeneralName(rootElement.getAttribute("Name"));
			Currency.setDate(rootElement.getAttribute("Date"));
			Currency.setDescription(rootElement.getAttribute("Description"));

			NodeList valTypeList = rootElement.getElementsByTagName("ValType");

			for (int i = 0; i < valTypeList.getLength(); i++) {
				Node node = valTypeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					String type = element.getAttribute("Type");
					NodeList ValuteList = element.getElementsByTagName("Valute");

					for (int j = 0; j < ValuteList.getLength(); j++) {
						Node node2 = ValuteList.item(j);

						if (node.getNodeType() == Node.ELEMENT_NODE) {
							Element element2 = (Element) node2;
							Currency currency = new Currency();
							currency.setType(type);
							currency.setCode(element2.getAttribute("Code"));
							currency.setName(element2.getElementsByTagName("Name").item(0).getTextContent());
							currency.setNominal(element2.getElementsByTagName("Nominal").item(0).getTextContent());
							currency.setValue(
									new BigDecimal(element2.getElementsByTagName("Value").item(0).getTextContent()));
							CurrencyList.add(currency);

						}
					}
				}
			}

			Currency.setMap(CurrencyList.stream().collect(Collectors.groupingBy(Currency::getType)));
			Currency.show();

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}




