public class Task8 {

    public static void main(String[] args) {

        Product p1 = new Product("Chleb", 10);
        Product p2 = new Product("Bułka", 1);
        Product p3 = new Product("Masło", 5);
        Product p4 = new Product("Woda", 2);
        Product p5 = new Product("Mąka", 100);

        // TEST getName --> Product
        System.out.println(p1.getName());
        // TEST getPrice --> Product
        System.out.println(p1.getPrice());
        // TEST toString --> Product
        System.out.println(p1.toString());

        Box b1 = new Box("Box1", p1);
        Box b2 = new Box("Box2", p2);
        Box b3 = new Box("Box3", p3);
        Box b4 = new Box("Box4", p4);
        Box b5 = new Box("Box5", p5);

        // TEST getName --> Box
        System.out.println(b1.getName());
        // TEST getProduct --> Box
        System.out.println(b1.getProd());
        // TEST toString --> Box
        System.out.println(b1.toString());


        // TEST metody boxNames
        Box tab [] = {b1, b2, b3, b4, b5};
        int min = 5;
        int max = 200;
        String names [] = Box.boxNames(tab, min, max);
        for (int i = 0; i < names.length; i++) {
            if(names[i] != null)
                System.out.println(names[i]);
        }

        // TEST metody getProducts
        Product products [] = Box.getProducts(tab);
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i].toString());
        }

    }

}
