public class Counter implements AutoCloseable{
    private Integer count;

    public void add(){
        if (count!=null){
            throw new RuntimeException("CLOSE!!!");
        }
        count++;
    }
    public Counter(){
        count=0;
    }

    @Override
    public void close() throws Exception {
        count=null;

        System.out.println("Counter close");
    }

    public int getCount() {
        if (count!=null){
            throw new RuntimeException("CLOSE!!!");
        }
        return count;
    }
}
