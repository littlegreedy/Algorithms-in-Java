package toolkit;

public class Counter {
    private final String name;
    private int count;

    public Counter(String id) {
        name=id;
    }
    public void increment()
    {count++;}

    public int tally()
    {return count;}


    @Override
    public String toString() {
        return
                count  + ' ' + name;
    }
}
