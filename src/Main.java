
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1: "+task1());
        task2();
        task3();
        task4(null);
    }

    public static float task1(){
        System.out.print("Введите дробное число (через точку):");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        float res;
        try {
            res = Float.parseFloat(str);
            sc.close();
        }
        catch (NumberFormatException e){
            System.out.println("Некорректный ввод!");
            res = task1();
        }
        return res;

    }

    public static void task2(){
        try {
            int d = 0;
            int[] intArray = {1,2,3,4,5,6,7,8,9};
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Catching exception: " + e);
        }
        catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }


    }

    public static void task3(){
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc =  { 1, 2 };
            abc[3] = 9;
        }
        catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
        catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

    }
    public static void printSum(Integer a, Integer b)  {
        System.out.println(a + b);
    }

    public static void task4(String str){
        if (str==null || str.isEmpty()){
            throw new RuntimeException("Пустые строки вводить нельзя!");
        }
        System.out.println("Все хорошо!");
    }
}