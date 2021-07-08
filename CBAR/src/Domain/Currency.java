package Domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Currency {
	private static Map<String, List<Currency>> map;

	private static String date;
	private static String GeneralName;
	private static String description;
	private String code;
	private String nominal;
	private String name;
	private BigDecimal value;

	public String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Currency(String code, String nominal, String name, BigDecimal value) {
		super();
		this.code = code;
		this.nominal = nominal;
		this.name = name;
		this.value = value;
	}

	public Currency() {

	}

	@Override
	public String toString() {

		return " code=" + code + ", nominal=" + nominal + ", name=" + name + ", value=" + value + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNominal() {
		return nominal;
	}

	public void setNominal(String nominal) {
		this.nominal = nominal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public static Map<String, List<Currency>> getMap() {
		return map;
	}

	public static void setMap(Map<String, List<Currency>> map) {
		Currency.map = map;
	}

	public static String getDate() {
		return date;
	}

	public static void setDate(String date) {
		Currency.date = date;
	}

	public static String getGeneralName() {
		return GeneralName;
	}

	public static void setGeneralName(String generalName) {
		GeneralName = generalName;
	}

	public static String getDescription() {
		return description;
	}

	public static void setDescription(String description) {
		Currency.description = description;
	}

	public static void show() {

		System.out.println(date);
		System.out.println(GeneralName);
		System.out.println(description);
		map.entrySet().stream().forEach(e -> {
			System.out.println(e.getKey());
			System.out.println("--------");
			e.getValue().forEach(e2 -> System.out.println(e2));
		});

	}

}
