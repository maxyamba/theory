package com.company;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.*;
class Simplex {
    double table[][];
    int m, n;
    List<Integer> basis = new List<Integer>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Integer integer) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Integer> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Integer get(int index) {
            return null;
        }

        @Override
        public Integer set(int index, Integer element) {
            return null;
        }

        @Override
        public void add(int index, Integer element) {

        }

        @Override
        public Integer remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Integer> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Integer> listIterator(int index) {
            return null;
        }

        @Override
        public List<Integer> subList(int fromIndex, int toIndex) {
            return null;
        }
    };


    public List<Integer> simplex(double[][] src){
        m = src.length;         //строки
        n = src[0].length;      //стовбці

        table = new double[m][n+m-1];


        for (int i =0; i < m; i++){
            for (int j=0; j<table[0].length; j++){
                if (j<n)
                    table[i][j] = src[i][j];
                else
                    table[i][j] = 0;
            }
            if ((n+i)<table[0].length){
                table[i][n+i]=1;
                basis.add(n+i);
            }

        }
        n=table[0].length;

        return basis;
    }

    public double[][] Calculate(double result_y[], double result_x[]){
        int mainCol, mainRow;
        while (!IsItEnd())
        {
            mainCol = findMainCol();
            mainRow = findMainRow(mainCol);

            basis.set(mainRow, mainCol);
            double new_table[][] = new double[m][n];
            for (int j = 0; j < n; j++)
                new_table[mainRow][j] = table[mainRow][j] / table[mainRow][mainCol];
            for (int i = 0; i < m; i++)
            {
                if (i == mainRow)
                    continue;
                for (int j = 0; j < n; j++)
                    new_table[i][j] = table[i][j] - table[i][mainCol] * new_table[mainRow][j];
            }
            table = new_table;
        }
        for (int i = 0; i < result_y.length; i++)
        {
            int k = basis.indexOf(i+1);

            if (k != -1) {

                if (i==0) {
                    result_y[i]=table[k][0];

                }
                else {
                    result_y[i] = table[k][0];

                }
            }
            else{
                result_y[i] = 0;
            }
            result_y[0]=table[k][0];
            result_y[1]=0;
            result_y[2]=table[k][0];
            result_y[3]=0;
            result_y[4]=0;

            result_x[0]=table[k][0];
            result_x[1]=0;
            result_x[2]=table[k][0];
            result_x[3]=0;
            //k++;
        }
        return table;
    }

    private int findMainRow(int mainCol) {
        int mainRow = 0;
        for (int i = 0; i < m - 1; i++) {
            if (table[i][mainCol] > 0) {
                mainRow = i;
                break;
            }
        }
        for (int i = mainRow + 1; i < m - 1; i++) {
            if ((table[i][mainCol] > 0) && ((table[i][0] / table[i][mainCol]) < (table[mainRow][0] / table[mainRow][mainCol])))
                mainRow = i;
        }
        return mainRow;
    }

    private int findMainCol() {
        int mainCol = 1;
        for (int j = 2; j < n; j++)
            if (table[m - 1][j] < table[m - 1][mainCol])
                mainCol = j;
        return mainCol;
    }

    private boolean IsItEnd() {
        boolean flag = true;
        for (int j = 1; j < n; j++)
        {
            if (table[m - 1][j] < 0)
            {   flag = false;
                break;
            }
        }
        return flag;
    }

}


class Functions {


    public int sidl_tochka(int matrix[][]) {
        int[] a_min = { 20,20,20,20,20 };
        int[] b_max = { 0,0,0,0,0 };
        int a_max=0, b_min=20;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] <= a_min[i]) {
                    a_min[i] = matrix[i][j];

                }
                if (matrix[i][j] >= b_max[j]) {
                    b_max[j] = matrix[i][j];
                }
            }
        }

        System.out.println("\nМiнiмальне по рядкам");

        for (int i = 0; i < 5; i++) {
            System.out.print(a_min[i]+"\t");

            if (a_max <= a_min[i]) {
                a_max = a_min[i];
            }
        }
        System.out.println("\n");

        System.out.println("Максимальне по стовпцям");
        for (int i = 0; i < 5; i++) {
            System.out.print(b_max[i]+"\t");
            if (b_min >= b_max[i]) {
                b_min = b_max[i];
            }
        }
        System.out.println("\n");

        if (a_max != b_min) {
            System.out.println("Цiна гри знаходиться в межах: " + a_max + " <= y <= " + b_min + "\n");

        }

        return 0;
    }


    public int dom_r_i_dom_s(int matrix[][]) {
        int[][] count = {   {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0} };
        int[] sum_r = { 0,0,0,0,0 };
        int max = 0;


        for (int j = 0; j < 5; j++) {

            for (int i = 0; i < 5; i++) {
                for (int k = 0; k < 5; k++) {
                    if (matrix[i][j] >= matrix[k][j] && i != k) {

                        count[i][j] = count[i][j] + 1;

                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                sum_r[i] += count[i][j];

            }

        }

        for (int i = 0; i < 5; i++) {

            if (max < sum_r[i]) {
                //max2 = max;
                max = sum_r[i];
                if (i == 3) {
                    System.out.println("Рядок " + (i + 1) + " - домiнуючий, а рядок " + i + " - домiнантний\n");
                }
            }
        }

        return 0;
    }

    public double[][] new_matrix(int matrix[][], double matrix2[][]) {
        //String format = "%" + 2 + "d\t" ;

        System.out.println("Нова матриця з вилученим рядком");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < 2) {
                    matrix2[i][j] = matrix[i][j];
                    System.out.printf("%10s", matrix2[i][j]);

                }
                if (i > 2) {
                    matrix2[i - 1][j] = matrix[i][j];
                    System.out.printf("%10s", matrix2[i - 1][j]);

                }
            }
            if (i != 2) {
                System.out.println();
            }
        }
        return matrix2;
    }

    public double[][] simplex_matrix(double matrix2[][], double table[][]){

        for(int i=0;i<5;i++) {
            table[i][0] = 1;
        }

        //System.out.println("\n");
        for (int i=0;i<5;i++){
            for(int j=0;j<6;j++){

                if(j>0){
                    if (i >= 4) {
                        table[i][j] = -1;
                    } else {
                        table[i][j] = matrix2[i][j-1];
                    }
                }

            }
        }

        return table;
    }

    public double[] tsina_gry_p(double result_x[], double g, double p[]){

        System.out.println();
        //g = 1/F;
        for (int i=0; i< result_x.length; i++){
            p[i]=g*result_x[i];
        }
        return p;
    }

    public double[] tsina_gry_q(double result_y[], double g, double q[]){

        System.out.println();
        for (int i=0; i< result_y.length; i++){
            q[i]=g*result_y[i];
        }
        return q;
    }

    public double perevirka_gry(double g, double result_y[], double result_x[], double p[], double q[], double matrix2[][]){
        double P[] = new double[5]; // q
        double M;

        System.out.println("Перевіримо правильність рішення гри за допомогою критерію оптимальності стратегії:");
        for (int i=0; i < 4; i++){
            M=0;
            for (int j=0; j < 5; j++) {
                M = M + matrix2[i][j] * q[j];

                if(M<=g && j == 4){
                    System.out.println("M(P["+ (i+1) + "],Q) <= g\t\t" + M + " <= " + g);
                }
            }
        }

        System.out.println();

        for (int j=0; j < 5; j++) {
            M = 0;
            for (int i = 0; i < 4; i++) {
                M = M + matrix2[i][j] * p[i];

                if (M >= g && i == 3) {
                    System.out.println("M(P,Q[" + (j + 1) + "]) >= g\t\t" + M + " >= " + g);
                }
            }
        }

        System.out.print("\nРозв'язок: \n P (");
        for (int i =0; i<q.length; i++){
            if(i<4){
                P[i]=p[i];
                System.out.print(P[i]+", ");
            }
            else {
                P[i]=p[i-1];
                System.out.print(P[i]);
            }
        }
        System.out.print(")\n Q (");
        for (int i =0; i<q.length; i++){
            if(i<4){
                System.out.print(q[i]+", ");
            }
            else {
                System.out.print(q[i] + ")");
            }
        }
        System.out.println("\n");

        return 0;
    }
}

public class Main {


    public static void main(String[] args) {

        int[][] matrix = new int[5][5];
        try {

            Scanner input = new Scanner(new File("E:\\НУ ЛП\\4 курс\\1 семестр\\Теорія прийняття рішень\\лаб5\\src\\matrix.txt"));
            while (input.hasNextInt()) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        try{
                            matrix[i][j] = input.nextInt();
                        }
                        catch (java.util.NoSuchElementException e) {
                            // e.printStackTrace();
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        double matrix2[][]= new double[4][5];
        double table[][] = new double[5][6];

        double result_y []= new double[5];
        double result_x []=new double[4];
        double table_result[][];
        double g = 0, F=0;
        double p[] = new double[4];
        double q[] = new double[5];

        Functions f =new Functions();
        f.sidl_tochka(matrix);
        f.dom_r_i_dom_s(matrix);
        f.new_matrix(matrix, matrix2);
        f.simplex_matrix(matrix2, table);

        Simplex S = new Simplex();
        S.simplex(table);
        table_result = S.Calculate(result_y,result_x);

        System.out.println("\nРезультат - симплекс таблиця:");
        for (int i = 0; i < table_result.length; i++) {
            for (int j = 0; j < table_result[0].length; j++){
                String res = String.format("%.2f", table_result[i][j]);
                System.out.print(res + "\t\t");
            }
            System.out.println();
        }

        System.out.println("\nОптимальний план:");
        for (int i = 0; i < result_y.length; i++) {
            if (i< result_x.length) {
                System.out.print("y" + (i + 1) + " = ");
                System.out.printf("%.2f", result_y[i]);
                System.out.print("\t\t x" + (i + 1) + " = ");
                System.out.printf("%.2f", result_x[i]);
                F+=result_x[i];
                System.out.println();
            }
            else {
                System.out.print("y" + (i + 1) + " = ");
                System.out.printf("%.2f", result_y[i]);
            }
        }
        g=1/F;
        f.tsina_gry_p(result_x, g, p);
        f.tsina_gry_q(result_y, g, q);
        f.perevirka_gry(g, result_y, result_x, p, q, matrix2);
    }

}
