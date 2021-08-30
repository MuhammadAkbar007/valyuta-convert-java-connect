package services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceImpl implements Service {

    public static double dollarPilot;
    public static double euroPilot;
    public static double yuanPilot;

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    {
        try {
            URL url = new URL("https://cbu.uz/oz/arkhiv-kursov-valyut/json/");

            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            Type type = new TypeToken<ArrayList<Currency>>() {
            }.getType();

            ArrayList<Currency> currencies = gson.fromJson(reader, type);

            currencies.forEach(currency -> {

                if (currency.getCcy().equals("USD")) {
                    String dollar = currency.getRate();
                    dollarPilot = Double.parseDouble(dollar);
                }

                if (currency.getCcy().equals("EUR")) {
                    String euro = currency.getRate();
                    euroPilot = Double.parseDouble(euro);
                }

                if (currency.getCcy().equals("CNY")) {
                    String yuan = currency.getRate();
                    yuanPilot = Double.parseDouble(yuan);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void somToDollar() {

        double amount = amountGive();
        if (amount == 0) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Noto'g'ri summa miqdor kiritildi !");
            System.out.println();
        } else {
            System.out.println(amount + " so'm = " + (amount / dollarPilot) + " dollar ga teng !");
            System.out.println();
        }
    }

    public void somToEuro() {

        double amount = amountGive();
        if (amount == 0) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Noto'g'ri summa miqdor kiritildi !");
            System.out.println();
        } else {
            System.out.println(amount + " so'm = " + (amount / euroPilot) + " euro ga teng !");
            System.out.println();
        }
    }

    public void somToYuan() {

        double amount = amountGive();
        if (amount == 0) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Noto'g'ri summa miqdor kiritildi !");
            System.out.println();
        } else {
            System.out.println(amount + " so'm = " + (amount / yuanPilot) + " yuan ga teng !");
            System.out.println();
        }
    }

    public void dollarToSom() {

        double amount = amountGive();
        if (amount == 0) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Noto'g'ri summa miqdor kiritildi !");
            System.out.println();
        } else {
            System.out.println(amount + " dollar = " + (amount * dollarPilot) + " so'm ga teng !");
            System.out.println();
        }
    }

    public void euroToSom() {

        double amount = amountGive();
        if (amount == 0) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Noto'g'ri summa miqdor kiritildi !");
            System.out.println();
        } else {
            System.out.println(amount + " euro = " + (amount * euroPilot) + " so'm ga teng !");
            System.out.println();
        }
    }

    public void yuanToSom() {

        double amount = amountGive();
        if (amount == 0) {
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Noto'g'ri summa miqdor kiritildi !");
            System.out.println();
        } else {
            System.out.println(amount + " yuan = " + (amount * yuanPilot) + " so'm ga teng !");
            System.out.println();
        }
    }

    public static double amountGive() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Miqdorni kiriting: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            return amount;
        } else {
            return 0;
        }

    }
}
