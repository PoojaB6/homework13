package utils;

import com.github.javafaker.Faker;

    public class TestFakerGenerator {

    public static String fakerCustomerName() {
        return Faker.instance().letterify("Pooja");
    }

    public static String fakerCustomerPhone() {
        return Faker.instance().numerify("58585858");
    }
    public static String fakerComment() {
        return Faker.instance().letterify("Call me");
    }
}
