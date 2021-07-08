package Jaxb.JaxbParser;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Jaxb.Domain.CbarURL;
import Jaxb.Domain.ValCurs;

public class JaxbParserMain {

	public static void main(String[] args) {

		try {
			URL url = new URL(CbarURL.URL);
			JAXBContext context = JAXBContext.newInstance(ValCurs.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ValCurs valCurs = (ValCurs) unmarshaller.unmarshal(url);

			System.out.println(valCurs.getDate() + " " + valCurs.getName() + "\n" + valCurs.getDescription());
			valCurs.getValTypeList().forEach(valType -> {
				System.out.println("---------");
				System.out.println(valType.getType());
				valType.getValute().forEach(System.out::println);
			});
		} catch (JAXBException | MalformedURLException e) {

			e.printStackTrace();
		}

	}
}
