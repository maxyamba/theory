package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            int[] aa = new int[6];
            // Read input file
            Scanner input = new Scanner(new File("E:\\НУ ЛП\\4 курс\\1 семестр\\Теорія прийняття рішень\\лаб3\\src\\matrix.txt"));

            while (input.hasNextInt()) {
                // This should be here to get size of array before getting each array

                for (int i = 0; i < 6; i++) {
                        try{
                            aa[i] = input.nextInt();
                        }
                        catch (java.util.NoSuchElementException e) {
                            // e.printStackTrace();
                        }
                }

                //print the input matrix
                //System.out.println("The input sorted matrix is : ");
                for (int i = 0; i < 6; i++) {

                        System.out.printf("%5d ", aa[i]);
                }

            }
            System.out.println();
            System.out.print("Кондорсе_______________");
            int ab=0;
            String ab1 = "";
            int ac=0;
            String ac1 = "";
            int bc=0;
            String bc1 = "";
            int a=0;
            int b=0;
            int c=0;
            int aMb = aa[0]+aa[1]+aa[4];
            int aMc = aa[0]+aa[1]+aa[2];
            int bMa = aa[2]+aa[3]+aa[5];
            int bMc = aa[0]+aa[2]+aa[3];
            int cMa = aa[3]+aa[4]+aa[5];
            int cMb = aa[1]+aa[4]+aa[5];
            System.out.println();
            if (aMb>bMa){
                ab = aMb;
                ab1 = "A > B  ";
                a = ab;
                System.out.printf("A > B %5d", ab);
            } else {
                ab = bMa;
                ab1 = "B > A  ";
                b = ab;
                System.out.printf("A < B %5d", ab);
            }
            System.out.println();
            if (aMc>cMa){
                ac = aMc;
                ac1 = "A > C  ";
                a = ac;
                System.out.printf("A > C %5d", ac);
            } else {
                ac = cMa;
                ac1 = "C > A  ";
                c = ac;
                System.out.printf("A < C %5d", ac);
            }
            System.out.println();
            if (bMc>cMb){
                bc = bMc;
                bc1 = "B > C  "  ;
                b = bc;
                System.out.printf("B > C %5d", bc);
                System.out.println();
                System.out.println(ab1 + bc1 + ac1);
            } else {
                bc = cMb;
                bc1 = "C > B  ";
                c = bc;
                System.out.printf("B < C %5d", bc);
                System.out.println();
                System.out.println(ab1 + bc1 + ac1);
            }
            if ((a>b) && (a>c) && (b>c)){
                System.out.println("A > B > C");
            } else if ((a>b) && (a>c) && (b<c)){
                System.out.println("A > C > B");
            }else if ((b>a) && (a>c) && (b>c)){
                System.out.println("B > A > C");
            }else if ((b>a) && (a<c) && (b>c)){
                System.out.println("B > C > A");
            }else if ((c>a) && (a<b) && (b<c)){
                System.out.println("C > B > A");
            }else if ((c>a) && (a>b) && (b<c)){
                System.out.println("C > A > B");
            }
            System.out.println();

            System.out.print("Борда_______________");
            int sumA = 0;
            int sumB = 0;
            int sumC = 0;
            int A [] = {2, 2, 1, 0, 1, 0};
            int B [] = {1, 0, 2, 2, 0, 1};
            int C [] = {0, 1, 0 ,1, 2, 2};
            for (int i = 0; i < 6; i++){
                sumA += A[i]*aa[i];
            }
            for (int i = 0; i < 6; i++){
                sumB += B[i]*aa[i];
            }
            for (int i = 0; i < 6; i++){
                sumC += C[i]*aa[i];
            }
            System.out.println();
            System.out.printf("A %2d",sumA);
            System.out.println();
            System.out.printf("B %2d",sumB);
            System.out.println();
            System.out.printf("C %2d",sumC);
            System.out.println();
            if ((sumA>sumB)&&(sumA>sumC)&&(sumB>sumC)){
                System.out.println("A > B > C    Найкращий А");
            } else if ((sumA>sumB)&&(sumA>sumC)&&(sumB<sumC)){
                System.out.println("A > C > B    Найкращий А");
            }else if ((sumB>sumA)&&(sumB>sumC)&&(sumA>sumC)){
                System.out.println("B > A > C    Найкращий В");
            }else if ((sumB>sumA)&&(sumB>sumC)&&(sumA<sumC)){
                System.out.println("B > C > A    Найкращий В");
            }else if ((sumC>sumA)&&(sumC>sumB)&&(sumA<sumB)){
                System.out.println("C > B > A    Найкращий С");
            }else if ((sumC>sumA)&&(sumC>sumB)&&(sumA>sumB)){
                System.out.println("C > A > B    Найкращий С");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
