public class main {
    public static void main(String[] args) {
        Person p1 = new Person("Jan", 1968);
        Person p2 = new Person("Maciek");
        Person p3 = new Person("Ania", 1980);
        Person p4 = new Person("Julia");
        Person p5 = new Person("Julita", 2010);
        System.out.println(p1.getName());
        System.out.println(p2.getBirth_year());
        System.out.println(p2.isFemale());
        System.out.println(p3.isFemale());
        System.out.println(Person.getOlder(p3, p5));
        Person tab [] = {p1, p2, p3, p4, p5};
        System.out.println(Person.getOldest(tab));
        Person men [] = {p1, p2};
        System.out.println(Person.getYoungestFemale(men));
        System.out.println(Person.getYoungestFemale(tab));
    }
}
