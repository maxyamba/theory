package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int[][] a = new int[3][3];
        try {


            // Read input file
            Scanner input = new Scanner(new File("E:\\НУ ЛП\\4 курс\\1 семестр\\Теорія прийняття рішень\\лаб1\\src\\matrix.txt"));

            while (input.hasNextInt()) {

                // This should be here to get size of array before getting each array



                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        try{
                            a[i][j] = input.nextInt();

                        }
                        catch (java.util.NoSuchElementException e) {
                            // e.printStackTrace();
                        }
                    }
                }

                //print the input matrix
                System.out.println("The input matrix is : ");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.printf("%5d ", a[i][j]);
                    }
                    System.out.println();

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int maxMinValda = Integer.MIN_VALUE;
        int minValda = Integer.MAX_VALUE;
        int currentValda = 0;
        int strategyNumberValda = -1;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                currentValda = a[i][j];
                if (currentValda < minValda) {
                    minValda = currentValda;
                }
            }
            if(minValda > maxMinValda) {
                strategyNumberValda = i;
                maxMinValda = minValda;
            }
            minValda = Integer.MAX_VALUE;
        }
        System.out.println("Max Valda: " + maxMinValda);
        System.out.println("Strategy: "+(strategyNumberValda+1));


        float kofHurv = 0.6f;
        int minHurv = Integer.MAX_VALUE;
        int maxHurv = Integer.MIN_VALUE;
        int currentHurv;
        int strategyNumberHurv = -1;
        float resultHurv = Integer.MIN_VALUE;
        float currentResultHurv;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                currentHurv = a[i][j];
                if(currentHurv > maxHurv) {
                    maxHurv = currentHurv;
                }
                if (currentHurv < minHurv) {
                    minHurv = currentHurv;
                }
            }
            currentResultHurv = kofHurv*minHurv+(1-kofHurv)*maxHurv;
            if(currentResultHurv > resultHurv) {
                strategyNumberHurv = i;
                resultHurv = currentResultHurv;
            }
            maxHurv = Integer.MIN_VALUE;
            minHurv = Integer.MAX_VALUE;
        }
        System.out.println("Middle Hurvica: "+(int)resultHurv);
        System.out.println("Strategy: "+(strategyNumberHurv+1));


        float maxLapl = 0;
        int strategyNumberLapl = -1;

        for(int i = 0; i < 3; i++) {
            float sumResultLapl = 0;
            for (int j = 0; j < 3; j++) {

                sumResultLapl += a[i][j] / 3.;


            }
            if(sumResultLapl > maxLapl) {
                strategyNumberLapl = i;
                maxLapl = sumResultLapl;
            }

        }
        System.out.println("Laplace: "+maxLapl);
        System.out.println("Strategy: "+(strategyNumberLapl+1));




        double p1 = 0.55;
        double p2 = 0.3;
        double p3 = 0.15;


        double maxLaBa = 0;
        int strategyNumberLaBa = 0;
        double[][] doubles = new double[3][3];
        double[][] newArray = new double[3][3];
        System.out.println("Laplace–Bayes");
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                doubles[i][j] = a[i][j];
                if (j==0){
                    newArray[i][j] =  doubles[i][0]*p1;
                    //System.out.printf("%3f  ", doubles[i][0]*p1);
                } else if (j==1){
                    newArray[i][j] =  doubles[i][1]*p2;
                    //System.out.printf("%3f  ", doubles[i][1]*p2);
                } else {
                    newArray[i][j] =  doubles[i][2]*p3;
                    //System.out.printf("%3f  ", doubles[i][2]*p3);
                }
                System.out.printf("%3f  ", newArray[i][j]);

            }
            System.out.println();


        }
        for(int i = 0; i < 3; i++) {
            float sumFirstLaBa = 0;
            for (int j = 0; j < 3; j++) {

                sumFirstLaBa += newArray[i][j];


            }
            if(sumFirstLaBa > maxLaBa) {
                strategyNumberLaBa = i;
                maxLaBa = sumFirstLaBa;
            }

        }
        System.out.println("Laplace–Bayes: "+maxLaBa);
        System.out.println("Strategy: "+(strategyNumberLaBa+1));



    }


}
