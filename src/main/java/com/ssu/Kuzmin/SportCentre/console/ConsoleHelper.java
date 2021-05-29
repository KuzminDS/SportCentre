package com.ssu.Kuzmin.SportCentre.console;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class ConsoleHelper {

    public static String getOptionFromMenu(String title, String[] optionsList) {
        showMenuList(title, optionsList);

        Scanner in = new Scanner(System.in);
        int option = in.nextInt() - 1;

        while (option < 0 || option >= optionsList.length) {
            System.out.println("Wrong value, try again: ");
            option = in.nextInt() - 1;
        }

        in.close();
        return optionsList[option];
    }

    public static boolean getConfirmationMessageResult() {
        System.out.println("Do you really want to do this? If yes, press ‘y’, if no, press ‘n’");

        Scanner in = new Scanner(System.in);
        char option = in.next().charAt(0);

        do {
            if (option == 'y')
                return true;
            else if (option == 'n')
                return false;
            else {
                System.out.println("Wrong value, try again: ");
                option = in.next().charAt(0);
            }
        } while(true);
    }

    private static void showMenuList(String title, String[] optionsList) {
        System.out.println(title);
        System.out.println("Choose an option (enter a number): ");
        for (int i = 1; i <= optionsList.length; i++) {
            System.out.println(String.format("%s:%s", i, optionsList[i - 1]));
        }
    }

    public static int enterPositiveIntValue(String title) {
        System.out.println(title);

        Scanner in = new Scanner(System.in);
        do {
            int value = in.nextInt();

            if (value > 0) {
                in.close();
                return value;
            }
            System.out.println("Incorrect value (it must be positive), enter again: ");
        } while (true);
    }

    public static String enterString(String title) {
        System.out.println(title);

        Scanner in = new Scanner(System.in);
        do {
            String value = in.next();

            if (!value.isEmpty()) {
                in.close();
                return value;
            }
            System.out.println("String must not be empty. Enter again: ");
        } while (true);
    }

    public static Date enterDate(String title) {
        System.out.println(title);
        System.out.println("Enter date in format: dd/MM/yyyy");
        Scanner in = new Scanner(System.in);
        do {
            try {
                String sd = in.nextLine();
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sd);
                in.close();
                return date;
            } catch (ParseException pe) {
                System.out.println("Date is incorrect. Enter again:");
            }
        } while (true);
    }

    public static Date enterTime(String title) {
        System.out.println(title);
        System.out.println("Enter time in format: hh:mm:ss");
        Scanner in = new Scanner(System.in);
        do {
            try {
                String st = in.nextLine();
                Date time = new SimpleDateFormat("hh:mm:ss").parse(st);
                in.close();
                return time;
            } catch (ParseException pe) {
                System.out.println("Time is incorrect. Enter again:");
            }
        } while (true);
    }

}
