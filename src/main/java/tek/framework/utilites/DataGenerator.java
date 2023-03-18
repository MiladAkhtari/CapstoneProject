package tek.framework.utilites;

import net.datafaker.Faker;

public class DataGenerator {
	public static void main(String[] args) {
		System.out.println(getData("name"));
		System.out.println(getData("email"));
		System.out.println(getData("random"));
		System.out.println(getData("cardNumber"));
	}

	public static String getData(String input) {
		
		Faker faker = new Faker();
		String result="";
		if (input.equals("name")) {
			result = faker.name().firstName().trim();
		}else if (input.equals("email")) {
			result = faker.expression("#{letterify '????.????@tekschool.us'}");
		}else
			result=faker.expression("#{letterify '????.????@tekschool.us'}");
		return result;
	}

}
