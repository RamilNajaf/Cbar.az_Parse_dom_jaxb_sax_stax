package Jaxb.Domain;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ValType {
	@XmlAttribute(name = "Type")
	private String Type;

	@XmlElement(name = "Valute")
	private List<Valute> valute;

	public String getType() {
		return Type;
	}

	public void setTyoe(String code) {
		Type = code;
	}

	public List<Valute> getValute() {
		return valute;
	}

	public void setValute(List<Valute> valute) {
		this.valute = valute;
	}

	@Override
	public String toString() {
		return "ValType [Type=" + Type + ", valute=" + valute + "]";
	}

}
