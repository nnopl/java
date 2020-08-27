public class Person {
    String name;
    int birth_year;

    public Person(String name, int birth_year) {
        this.name = name;
        this.birth_year = birth_year;
    }

    public Person(String name) {
        this(name, 1990);
    }

    public String getName() {
        return name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public boolean isFemale(){
        if(name.endsWith("a"))
            return true;
        return false;
    }

    static public Person getOlder(Person p1, Person p2){
        if(p1.getBirth_year() > p2.getBirth_year())
            return p2;
        else
            return p1;
    }

    static public Person getOldest(Person [] tab){
        Person oldest = tab[0];
        for (int i = 0; i < tab.length; i++) {
            if(tab[i].getBirth_year() < oldest.getBirth_year())
                oldest = tab[i];
        }
        return oldest;
    }

    static public Person getYoungestFemale(Person [] tab){
        boolean isAnyFemale = false;
        Person youngest = tab[0];
        for (int i = 0; i < tab.length ; i++) {
            if(tab[i].isFemale()){
                isAnyFemale = true;
                youngest = tab[i];
            }
        }
        if(!isAnyFemale)
            return null;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i].isFemale()){
                if(tab[i].getBirth_year() > youngest.getBirth_year())
                    youngest = tab[i];
            }
        }
        return youngest;
    }

    public String toString(){
        return "Name:\t" + name + "\t" + " Birth Year:\t" + birth_year + "\t" +  " Gender:\t" + isFemale();
    }
}
