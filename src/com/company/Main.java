package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try {


            // Read input file
            Scanner input = new Scanner(new File("E:\\НУ ЛП\\4 курс\\1 семестр\\Теорія прийняття рішень\\лаб2\\src\\matrix.txt"));
            ArrayList<String> list = new ArrayList<String>();
            while (input.hasNextFloat()) {

                while (input.hasNext()){
                    list.add(input.next());
                }

                System.out.print("Дані : " + list);
                double[] aa = new double[list.size()];

                for (int i = 0; i < list.size(); ++i) {
                    aa[i] = Double.parseDouble(list.get(i));
                }

                double ov, res1;

                ov = (aa[1] * aa[12] + aa[3] * aa[13]) * 4 - aa[0];
                res1 = ov;
                System.out.println();
                System.out.println("Очікування великого заводу "+res1);


                double om, res2;
                om = (aa[6] * aa[12] + aa[8] * aa[13]) * 4 - aa[5];
                res2 = om;
                System.out.println("Очікування маленького заводу "+res2);


                double vV, res3;
                vV = (aa[1] * aa[2] + aa[8] * aa[4]) * 5 - aa[0];
                res3 = vV;
                System.out.println("Великий завод результат: " + res3);



                double vM, res4;
                vM = (aa[6] * aa[2] + aa[3] * aa[4]) * 5 - aa[5];
                res4 = vM;
                System.out.println("Маленький завод результат: " + res4);



                double vO, res5, maxx=0, max = 0;
                if (res1 > res2){
                    maxx =res1;
                } else {
                    maxx =res2;
                }
                if (maxx > res3){
                    max =maxx;
                } else {
                    max =res3;
                }
                vO = max + (aa[10] * 0 * 1 + aa[11] * 0 * 1) - 0;
                res5 = vO;
                System.out.println("Очiкування i збiр iнформацiї: " + res5);

                double[] arr = {res1, res2, res3, res4, res5};
                double maxRes = 0;
                for (int i = 0; i < arr.length; i++){
                    if (arr[i]>maxRes){
                        maxRes = arr[i];
                    }
                }
                System.out.println("Найоптимальніший варіант: " + maxRes);


            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}

