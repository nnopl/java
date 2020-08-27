public class Box {

    private String name;
    private Product prod;

    // Constructor
    public Box(String name, Product prod) {
        this.name = name;
        this.prod = prod;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Getter
    public Product getProd() {
        return prod;
    }

    @Override
    public String toString(){
        return "Name of box: " + name + " product in box -  " + prod.getName();
    }

    public static Product [] getProducts(Box tab []){

        Product returntab [] = new Product[tab.length];

        for (int i = 0; i < tab.length; i++) {
            returntab[i] = tab[i].prod;
        }

        return returntab;

    }

//    public static String [] boxNames(Box tab [], int min, int max){
//
//        boolean anything = false;
//
//        String retruntab [] = new String[tab.length];
//        int index = 0;
//
//        for (int i = 0; i < tab.length; i++) {
//            if(tab[i].prod.getPrice() >= min && tab[i].prod.getPrice() <= max){
//                anything = true;
//                retruntab[index] = tab[i].prod.getName();
//                index++;
//            }
//        }
//
//        if(anything == true)
//            return retruntab;
//        else
//            return null;
//
//    }

    public static String [] boxNames(Box tab [], int min, int max){

        String retruntab [] = new String[tab.length];
        int index = -1;

        for (int i = 0; i < tab.length; i++) {
            if(tab[i].prod.getPrice() >= min && tab[i].prod.getPrice() <= max){
                index++;
                retruntab[index] = tab[i].prod.getName();
            }
        }

        if (index == -1)
            return null;
        else
            return retruntab;

    }

}
