package com.sugeB;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    Lingkaran lingkaran;
    PersegiPanjang persegiPanjang;
    Balok balok;
    Kerucut kerucut;

    Scanner scanner = new Scanner(System.in);

    HashMap<String, HashMap<String, Float>> data = new HashMap<>();

    private static boolean inputDone = false;

    final String[][] DATA_NAME = {
            {
                    "panjang",
                    "lebar",
                    "tinggi"
            },
            {
                    "jari",
                    "tinggi"
            }
    };

    final String[] HASH_NAME = {
            "balok",
            "kerucut",
    };

    final String[][] INPUT_TITLE = {
            {
                    "PANJANG = ",
                    "LEBAR = ",
                    "TINGGI = "
            },
            {
                    "JARI-JARI = ",
                    "TINGGI = "
            }
    };

    public static void main(String[] args) {
        Main main = new Main();
        for (String s : main.HASH_NAME) {
            main.data.put(s, new HashMap<>());
        }
        main.addData();
    }

    private void addData() {
        int menu;
        String input;
        do {
            do {
                System.out.println("INPUT");
                System.out.println("1. BALOK");
                System.out.println("2. KERUCUT");
                System.out.println("3. EXIT");
                System.out.print("PILIH : ");
                input = scanner.nextLine();
                try {
                    menu = Integer.parseInt(input);
                    if (menu < 4 && menu > 0) {
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Data Yang Diinput Tidak Valid!!!");
                }
            } while (true);
            menu -= 1;
            if (menu == 2) {
                System.exit(1);
            }
            String dataInput;
            for (int i = 0; i < DATA_NAME[menu].length; i++) {
                System.out.print(INPUT_TITLE[menu][i]);
                dataInput = scanner.nextLine();
                try {
                    Float.parseFloat(dataInput);
                    data.get(HASH_NAME[menu]).put(DATA_NAME[menu][i], Float.parseFloat(dataInput));
                } catch (Exception e) {
                    System.out.println("Data Yang Diinput Tidak Valid!!!");
                    i--;
                }
            }
            if (!inputDone) {
                lingkaran = new Lingkaran(data.get("kerucut"));
                persegiPanjang = new PersegiPanjang(data.get("balok"));
                balok = new Balok(data.get("balok"));
                kerucut = new Kerucut(data.get("kerucut"));
                inputDone = true;
            } else {
                lingkaran.setData(data.get("kerucut"));
                persegiPanjang.setData(data.get("balok"));
            }
            System.out.println("______OUTPUT______");
            if (menu == 1) {
                lingkaran.setData(data.get("balok"));
                kerucut.outputData();
            } else {
                persegiPanjang.setData(data.get("kerucut"));
                balok.outputData();
            }
        }while (true);
    }
}
