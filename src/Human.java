import java.time.LocalDate;
import java.util.List;

public class Human {
    private boolean fillFIO;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate bday;
    private int phone;
    private char gender;

    public Human() {
        fillFIO=false;
    }

    public Integer FillData(String data){
        String[] arr=data.split(" ");

        for (int i=0;i<arr.length;i++) {
            if (arr[i].equals("f")||arr[i].equals("m")){
                gender=arr[i].charAt(0);
            }

            if (arr[i].matches("^(0?[1-9]|[12]\\d|30|31).(0?[1-9]|1[0-2]).\\d{4}")){
                //parseInt не вызовет NumberFormatException, т.к. строка прошла проверку регулярным выражением
                int year = Integer.parseInt(arr[i].split("\\.")[2]);
                int month = Integer.parseInt(arr[i].split("\\.")[1]);
                int day = Integer.parseInt(arr[i].split("\\.")[0]);

                bday=LocalDate.of(year,month,day);
                if (LocalDate.now().compareTo(bday)<0){
                    clearField();
                    throw new FutureDateException();
                }

            }

            try {
                phone = Integer.parseInt(arr[i]);
                if (phone < 1) {
                    clearField();
                    throw new InvalidNumber();
                }
            }catch (NumberFormatException e){
               // System.out.println("ПРОВЕРКА "+ arr[i]);
            }

            try{
                if (!fillFIO && arr[i].matches("[а-яА-Яa-zA-z]{2,}")){
                    patronymic=arr[i+2];
                    name=arr[i+1];
                    surname=arr[i];
                    fillFIO=true;
                }
            }catch (ArrayIndexOutOfBoundsException e){
                patronymic=null;
                name=null;
                surname=null;
            }

        }

        /*Если количество не совпадает с требуемым, вернуть код ошибки,*/
        if (surname==null||name==null||patronymic==null||bday==null||phone==0||gender==0){
            System.out.println(this);
            return -1;
        }else {
            if (arr.length>6){
                return -2;
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Human:" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", bday=" + bday +
                ", phone=" + phone +
                ", gender=" + gender;
    }

    private void clearField(){
        surname=null;
        name=null;
        patronymic=null;
        bday=null;
        phone=0;
        gender=0;
        fillFIO=false;

    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBday() {
        return bday;
    }

    public int getPhone() {
        return phone;
    }

    public char getGender() {
        return gender;
    }
}
