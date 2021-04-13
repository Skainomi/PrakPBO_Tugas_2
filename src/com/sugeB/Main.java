package com.sugeB;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    Lingkaran lingkaran;
    PersegiPanjang persegiPanjang;
    Balok balok;
    Kerucut kerucut;

    Scanner scanner = new Scanner(System.in);

    //hashmap untuk input data yang akan dilanjutkan ke class lain
    HashMap<String, HashMap<String, Float>> data = new HashMap<>();

    //jika input telah lebih dari 1 kali
    private static boolean inputDone = false;

    //variable berisi nama data untuk inisialisi hashmap
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

    //variable berisi nama hashmap untuk inisialisi hashmap
    final String[] HASH_NAME = {
            "balok",
            "kerucut",
    };

    //variable untuk input
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
        //inisialisasi hashmap
        for (String s : main.HASH_NAME) {
            main.data.put(s, new HashMap<>());
        }
        //menambahkan data
        main.addData();
    }

    private void addData() {
        int menu;
        String input;
        String dataInput;
        do {
            do {
                //bagian menu
                System.out.println("INPUT");
                System.out.println("1. BALOK");
                System.out.println("2. KERUCUT");
                System.out.println("3. EXIT");
                System.out.print("PILIH : ");
                input = scanner.nextLine();
                try {//pengecekan input
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
                //bila user memilih exit
                System.exit(1);
            }
            //input data kedalam hashmap
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
                //inisialisasi object(input data pertama)
                lingkaran = new Lingkaran(data.get("kerucut"));
                persegiPanjang = new PersegiPanjang(data.get("balok"));
                balok = new Balok(data.get("balok"));
                kerucut = new Kerucut(data.get("kerucut"));
                inputDone = true;
            } else {
                //Pengubahan data
                lingkaran.setData(data.get("kerucut"));
                persegiPanjang.setData(data.get("balok"));
            }
            //Output Data
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
