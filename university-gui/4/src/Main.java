import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
        The solution does not provide Unit tests because:
        * the order of threads execution is unknown (therefore we can't predict any output order)
        * it uses many random functions (to produce new item or thread sleep time)

        I hope this class (Main) is enough to present the solution.
     */

    public static void main(String[] args) {
        Market market = new Market();

        List<Producer> producers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            producers.add(new Producer(i, market));
        }

        List<Consumer> consumers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            consumers.add(new Consumer(i, market));
        }

        for(Producer producer: producers)
            producer.start();

        for(Consumer consumer: consumers)
            consumer.start();

    }
}
