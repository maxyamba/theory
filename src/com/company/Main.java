package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.lang.String;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            String transport[] = { "Автобус", "Поїзд" ,"Електричка" , "БлаБлаКар" , "Автостоп" };
            double[][] a = new double[5][5];

            double[] aaa = new double[5];
            System.out.println("\t\t\t\tЦіна\t\tТривалість\t\t\tБезпека\t\t\tПересадка\t\tЙмовірність відправлення");

            Scanner inputWei = new Scanner(new File("E:\\НУ ЛП\\4 курс\\1 семестр\\Теорія прийняття рішень\\лаб4\\src\\wei.txt")).useLocale(Locale.US);

            while(inputWei.hasNextDouble())
            {
                for (int i = 0; i < 5; i++) {
                    aaa[i] = inputWei.nextDouble();
                    System.out.format("%19s",aaa[i]);
                }
            }

            System.out.println();
            Scanner inputRanks = new Scanner(new File("E:\\НУ ЛП\\4 курс\\1 семестр\\Теорія прийняття рішень\\лаб4\\src\\ranks.txt"));

            while (inputRanks.hasNextInt()) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {

                        try {
                            a[i][j] = inputRanks.nextInt();

                        } catch (java.util.NoSuchElementException e) {
                            // e.printStackTrace();
                        }
                    }
                }

                System.out.println("------------------------------------------------------------------------------------------------------");
                for (int i = 0; i < 5; i++) {

                    System.out.format("%10s", transport[i]);
                    for (int j = 0; j < 5; j++) {

                        System.out.printf("%8s\t\t\t", a[i][j]);
                    }

                    System.out.println();

                }

            }

            System.out.println();
            System.out.println("Перемноження");

            double mult [][] = new double[5][5];
            for (int i = 0; i < 5; i++){

                System.out.format("%10s", transport[i]);
                for (int j = 0; j < 5; j++){
                    mult[i][j] = aaa[j] * a [i][j];

                    System.out.printf("\t %.2f\t\t\t", mult[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            double max[] = {0, 0, 0, 0, 0};
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (max[j] < mult[i][j]) {
                        max[j] = mult[i][j];
                    }
                }
            }

            System.out.println("Максимальне");
            for (int i = 0; i < 5; i++) {
                System.out.printf("\t\t\t%.2f\t",max[i]);
            }
            System.out.println();
            System.out.println("********************************************************************************************************");
            for (int i = 0; i < 5; i++) {
                System.out.format("\t\t\t%8s", transport[i]);
            }


            System.out.println();
            System.out.println();
            System.out.println("Сума параметрів");
            double sum[] = { 0,0,0,0,0 };
            double maxResult=0;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    sum[i] = sum[i] + mult[i][j];
                }
                System.out.printf("\t\t\t%.2f\t",sum[i]);

            }
            System.out.println();
            System.out.println("******************************************************************************************************");
            for (int i = 0; i < 5; i++) {
                System.out.printf("\t\t\t%8s",transport[i]);
            }
            System.out.println();

            for (int i = 0; i < 5; i++) {
                if (maxResult < sum[i]) {
                    maxResult = sum[i];
                }
            }
            System.out.printf("Найбільша сума параметрів = %.2f",maxResult);

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}

