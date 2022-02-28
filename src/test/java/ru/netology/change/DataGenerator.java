package ru.netology.change;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    static Faker faker = new Faker(new Locale("ru"));

    public static String dataCity() {
        return (faker.address().city());
    }

    public static String dataDate() {
        LocalDate date = LocalDate.now();

        date = date.plusDays(new Random().nextInt(19 - 3) + 3);
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String dataName() {
        return (faker.name().lastName() + " " + faker.name().firstName());
    }

    public static String dataPhone() {;
        return (faker.phoneNumber().phoneNumber());
    }
}
