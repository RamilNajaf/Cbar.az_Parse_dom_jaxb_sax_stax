package Sax;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import Domain.Cbar;
import Domain.Currency;

public class SaxParserMain {

	public static void main(String[] args) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			SaxContendHandler handler = new SaxContendHandler();
			parser.parse(Cbar.URL, handler);
			Currency.setMap(handler.getCurList().stream().collect(Collectors.groupingBy(e -> e.getType())));
			Currency.show();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
