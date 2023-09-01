import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//Иванов Иван Иванович 05.05.2000 777777 m
//Иванов Виктор Афанасьевич 15.12.2015 787878 m
//Сидоров Петр Васильевич 22.01.1999 m 989898
public class Main {
    public static void main(String[] args) {
        boolean flag=true;
        Human human = new Human();
        while (flag){

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные в следующем порядке:\nФамилия Имя Отчество датарождения номертелефона пол");
        String data= sc.nextLine();


            /* Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
             вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных,
             чем требуется.*/
            try {
                int res = human.FillData(data);
                switch (res) {
                    case -1 -> System.out.println("Мало данных!");
                    case -2 -> System.out.println("Слишком много данных!");
                    case 0 -> {flag=false;
                        sc.close();}
                }
            }catch (FutureDateException | InvalidNumber e){
                System.out.println(e.getMessage());
            }

        }

        try(FileWriter writer = new FileWriter(human.getSurname()+".txt",true)){
            String str =String.format("<%s><%s><%s><%s><%d><%s>\n",human.getSurname(), human.getName(), human.getPatronymic(),
                    String.format("%d.%d.%d",human.getBday().getDayOfMonth(),human.getBday().getMonthValue(),human.getBday().getYear()),
                    human.getPhone(),human.getGender());
            writer.write(str);

            writer.flush();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("All Done!");
    }



}