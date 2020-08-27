public class Consumer extends Thread {

    private final Market market;
    private final int id;

    public Consumer(int id, Market market) {
        this.market = market;
        this.id = id;
    }

    @Override
    public void run()
    {
        while (true) {
            String product = market.takeProduct();

            if(product != null)
                System.out.println("Consumer ["+ id +"] took "+product);
            else
                System.out.println("Consumer ["+ id +"] couldn't take any product (market is empty)");

            try {
                Thread.sleep((long) (Math.random() * 5000 + 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
