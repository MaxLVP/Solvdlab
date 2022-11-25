package com.solvd.library.library;

import com.solvd.library.others.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Giveaway {

    public Papers giveaway() {
        System.out.println("Что вы хотите получить? (газета, комикс, журнал, методичка)");
        Scanner scanner = new Scanner(System.in);
        String type = "";
        if (scanner.hasNextLine()) {
            type = scanner.nextLine();
        } else {
            System.out.println("Вы не ввели что хотите получить");
        }
        Papers paper;
        switch (type) {
            case "газета" -> paper = giveNewspaper();
            case "методичка" -> paper = giveManual();
            case "комикс" -> paper = giveComics();
            case "журнал" -> paper = giveMagazine();
            default -> {
                paper = null;
                System.out.println("Введено неправильно наименование");
            }
        }
        return paper;
    }

    public ArrayList<String> getInfo() {
        System.out.println("Введите название и жанр");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> info = new ArrayList<>();
        String current = scanner.nextLine();
        while (!current.equals("")) {
            info.add(current);
            current = scanner.nextLine();
        }
        scanner.close();
        return info;
    }

    public Newspaper giveNewspaper() {
        ArrayList<String> info = getInfo();
        return new Newspaper(info.get(0), info.get(1));
    }

    public Comics giveComics() {
        ArrayList<String> info = getInfo();
        return new Comics(info.get(0), info.get(1));
    }

    public Magazine giveMagazine() {
        ArrayList<String> info = getInfo();
        return new Magazine(info.get(0), info.get(1));
    }

    public Manuals giveManual() {
        ArrayList<String> info = getInfo();
        return new Manuals(info.get(0), info.get(1));
    }
}
