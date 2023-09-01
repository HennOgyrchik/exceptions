public class FutureDateException extends RuntimeException{
    public FutureDateException(){
        super("Дата не может быть больше текущей!");
    }
}
