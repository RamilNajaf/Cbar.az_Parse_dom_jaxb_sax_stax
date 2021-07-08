package Jaxb.Domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ValCurs {

	@XmlAttribute(name = "Date")
	private String Date;
	@XmlAttribute(name = "Name")
	private String Name;
	@XmlAttribute(name = "Description")
	private String Description;

	@XmlElement(name = "ValType")
	List<ValType> ValTypeList = new ArrayList();

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<ValType> getValTypeList() {
		return ValTypeList;
	}

	public void setValTypeList(List<ValType> valTypeList) {
		ValTypeList = valTypeList;
	}

	@Override
	public String toString() {
		return "ValCurs [Date=" + Date + ", Name=" + Name + ", Description=" + Description + ", ValTypeList="
				+ ValTypeList + "]";
	}

}
