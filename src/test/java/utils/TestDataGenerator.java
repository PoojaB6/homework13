package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class TestDataGenerator {
    public static String GenerateRandomCustomerName(){
        return RandomStringUtils.randomAlphabetic(5);
    }
    public static String GenerateRandomCustomerPhone(){
        return RandomStringUtils.randomAlphabetic(8);
    }
    public static String GenerateRandomCustomerComment(){
        return RandomStringUtils.randomAlphabetic(8);
    }
}
