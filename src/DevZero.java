public class DevZero extends ArithmeticException {
    private String message;
    public DevZero(String message){
        this.message=message;
        //super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
