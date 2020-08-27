import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Market {
    private List<String> products = new LinkedList<>();

    public synchronized void addProduct(String product) {
        products.add(product);
    }

    public synchronized String takeProduct() {
        if(products.size() < 1)
            return null;

        return products.remove(0);
    }
}
