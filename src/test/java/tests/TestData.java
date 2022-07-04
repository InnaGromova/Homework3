package tests;


import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class TestData {
    static Faker faker = new Faker();

    public static String getRandomGender() {
      Random r = new Random();
      List<String> list = Arrays.asList("Male", "Female", "Other");
        return list.get(r.nextInt(list.size()));
    }

    public static String getRandomMonth() {
        Random r = new Random();
        List<String> list = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        return list.get(r.nextInt(list.size()));
    }

    public static int getRandomInt(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomHobby() {
        Random r = new Random();
        List<String> list = Arrays.asList("Sports", "Reading", "Music");
        return list.get(r.nextInt(list.size()));
    }
    public static String getRandomSubjects() {
        Random r = new Random();
        List<String> list = Arrays.asList("Maths", "Arts", "History", "Chemistry", "Physics", "English", "Economics");
        return list.get(r.nextInt(list.size()));
    }

    public static String getRandomState() {
        Random r = new Random();
        List<String> list = Arrays.asList("NCR", "Uttar Pradesh", "Haryana");
        return list.get(r.nextInt(list.size()));
    }

    public static String getRandomCity() {
        Random r = new Random();
        List<String> NCRState = Arrays.asList("Delhi", "Gurgaon", "Noida");
        List<String> UttarState = Arrays.asList("Agra", "Lucknow", "Merrut");
        List<String> HaryanaState = Arrays.asList("Karnal", "Panipat");

        switch (state) {
            case "NCR":
                city = NCRState.get(r.nextInt(NCRState.size()));
            break;
            case "Uttar Pradesh":
                city = UttarState.get(r.nextInt(UttarState.size()));
            break;
            case "Haryana":
                city = HaryanaState.get(r.nextInt(HaryanaState.size()));
        }
        return city;
    }

   static String firstName = faker.name().firstName();
   static String lastName = faker.address().lastName();
   static String usermail = faker.internet().emailAddress();
   static String usernumber = faker.phoneNumber().subscriberNumber(10);
   static String address = faker.address().streetAddress();
    static String choosegender = getRandomGender();
    static String birthDay = String.valueOf(getRandomInt(1, 28));
    static String birthMonth = getRandomMonth();
    static String birthYear = String.valueOf(getRandomInt(1990, 2020));
    static String hobby = getRandomHobby();
    static String subjects = getRandomSubjects();
    static String state = getRandomState();
    static String city = getRandomCity();
    static String picture = "src/test/resources/Summer.jpg";

}

