package Jaxb.Domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.FIELD)
public class Valute {

	@XmlAttribute(name = "Code")
	private String Code;

	@XmlElement(name = "Name")
	private String Name;

	@XmlElement(name = "Nominal")
	private String Nominal;

	@XmlElement(name = "Value")
	private String Value;

	@Override
	public String toString() {
		return " [Code=" + Code + ", Name=" + Name + ", Nominal=" + Nominal + ", Value=" + Value + "]";
	}

}
