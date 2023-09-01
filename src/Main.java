import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       //task1();
       // task2();
       // task3();
      /*  try {
            nullArray();
        }catch (EmptyArrayException e){
            System.out.println("asdasd!!ASD!");
        }*/

/*
        try {
            tryFile();
        }catch (CantFindFileException e){
            System.out.println(e.getMessage());
        }*/
        String arr[][]={{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};

        try {
            System.out.println(task4(arr));

        }catch (MyArrayDataException | MyArraySizeException e){
            System.out.println(e.getMessage());
        }

    }

    public static void doSomething() throws Exception {
        throw new Exception("Something exeption");
    }

    public static void task1(){
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

     public static void task2(){
        try (Counter c = new Counter()) {
            c.add();
            System.out.println(c.getCount());
            c.close();
            c.add();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void task3(){
        try {
            zeroDevider();
        } catch (DevZero e){
            System.out.println(e.getMessage());
        }
    }
    public static void zeroDevider() {
        throw new DevZero("~ada!!");
    }

    public static void nullArray(){
        Integer[] arr = {0,null,4};
        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i]++;
                System.out.println(arr[i]);
            }
        }catch (NullPointerException e){
            throw new EmptyArrayException();
        }
    }

    public static  void tryFile() throws CantFindFileException{
        try (FileReader fr = new FileReader("asd")) {
            fr.read();
        } catch (FileNotFoundException e) {
            throw new CantFindFileException("asdas~afaS!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/*
Напишите метод,на вход которогоподаётся двумерный строковый массив
размером 4х4. При подаче массива другого размера необходимо бросить
исключение MyArraySizeException.
2. Далее метод должен пройтисьпо всем элементам массива,преобразовать в
int и просуммировать. Если в каком-то элементе массива преобразование
не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException с детализацией, в
какой именно ячейкележат неверныеданные.
3. В методе main() вызвать полученный метод, обработать возможные
исключения MyArraySizeException и MyArrayDataException и вывести
результатрасчета (сумму элементов,при условиичто подали на вход
корректныймассив).
 */
    public static int task4(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        for (int i = 0; i < 4; i++) {
            if (arr.length!=4 || arr[i].length!=4){
                throw new MyArraySizeException("not 4x4!!!! this array "+arr.length + "x"+arr[i].length);
            }
        }


        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int x = Integer.parseInt(arr[i][j]);
                    sum+=x;
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Invalid data in ["+i+";"+j+"]");
                }
            }
        }

        return sum;
    }
}