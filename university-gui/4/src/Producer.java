public class Producer extends Thread {

    private static final String[] products = {"Shoes", "Trousers", "TV", "Smartphone", "Apple", "Speaker", "Laptop", "Pillow"};

    private final Market market;
    private final int id;

    public Producer(int id, Market market) {
        this.market = market;
        this.id = id;
    }

    @Override
    public void run()
    {
        while (true) {
            String newProduct = products[(int)(Math.random()*products.length)];
            market.addProduct(newProduct);
            System.out.println("Producer ["+ id +"] produced "+newProduct);

            try {
                Thread.sleep((long) (Math.random() * 5000 + 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
