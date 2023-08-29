import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /* int[] arr={1,2,3,4,5,6,7,8,9};

        codeInfo(func_1(arr,50,9));
        codeInfo(func_1(arr,3,52));
        codeInfo(func_1(null,7,9));
        codeInfo(func_1(arr,3,9));
        */

       /* int[][] arr2={{1,0,1},{1,1,1},{0,1,0}};
        System.out.println(func_2(arr2));
        */

       /* Integer[] arr={1,null,3,4,null,2};
        checkArray(arr);*/

       /* int[] a = {10, 14, -6};
        int[] b = {5, 7, -2};

        for (int x :
                divArrays(a, b)) {
            System.out.print(x+" ");
        }*/

        String fileName="file.txt";
        List<String[]> arr= readFile(fileName);
        channgeList(arr);
        updateFile(arr, fileName);
    }

    public static int func_1(int[] arr, int a, int find){
        if (arr == null){
            return -3;
        }
        if (arr.length<a) {
            return -1;
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]==find){
                return i;
            }
        }

        return -2;
    }

    public static void codeInfo(int code){
        switch (code) {
            case -1 ->
                System.out.println("Длинна массива меньше некоторого заданного минимума.");

            case -2 ->
                System.out.println("Искомый элемент не найден.");

            case -3 ->
                System.out.println("Массив null.");

            default -> System.out.println("Искомый элемент имеет индекс " + code);
        }
    }

    public static int func_2(int[][] arr){
        if (arr.length !=arr[0].length){
            throw new RuntimeException("Массив не является квадратным!");
        }
        int sum=0;
        for (int[] is: arr) {
            for (int is2: is) {
                if ((is2!=0)&&(is2!=1)){
                    throw new RuntimeException("Элемент массива не является 0 или 1!");
                }
                sum+=is2;
            }
        }

        return sum;
    }

    public static void checkArray(Integer[] arr){
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==null){
                res.append(i).append(" ");
            }
        }
        if (!res.isEmpty()){
            throw new RuntimeException("Элементы NULL: "+res);
        }
        System.out.println("Элементы NULL не найдены.");
    }

    public static int[] subArrays(int[] a, int[] b){
        // Введите свое решение ниже
        if (a.length!=b.length) {
            return new int[]{0};
        }
        int[] c= new int[a.length];
        for (int i = 0; i < c.length; i++) {
            c[i]=a[i]-b[i];
        }
        return c;
    }

    public static int[] divArrays(int[] a, int[] b){
        // Введите свое решение ниже

        if (a.length!=b.length) {
            return new int[]{0};
        }
        int[] c= new int[a.length];
        for (int i = 0; i < c.length; i++) {
            if (b[i]!=0){
                c[i]=a[i]/b[i];
            } else {
                throw new RuntimeException("На 0 делить нельзя :c");
            }

        }
        return c;
    }

    public static List<String[]> readFile(String fileName){
        List<String[]> result = new ArrayList<>();
        try {
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = file.readLine()) != null){
                result.add(checkSymbol(line.split("=")));
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        return result;
    }

    public static String[] checkSymbol(String[] arr){
        if (!isNumeric(arr[1]) && !arr[1].equals("?")){
            throw new RuntimeException("Некорректные данные: "+ arr[0]+"="+arr[1]);
        }
        return arr;
    }

    public static boolean isNumeric (String str){
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public static void channgeList(List<String[]> list){
        for (String[] line: list) {
            if (line[1].equals("?")){
                line[1]=String.valueOf(line[0].length());
            }
        }
    }

    public static void updateFile(List<String[]> data, String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String[] line : data) {
                writer.write(String.join("=", line[0], line[1]));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}