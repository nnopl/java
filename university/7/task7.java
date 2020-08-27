
public class Task07 {
	public static String norm(String s) {
		return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
	}
	
	public static String init(String s) {
	    String[] arr = s.split(" ");
	    String result = "";
	    for (int i = 0; i < arr.length; i++) {
	      if (i < arr.length - 1) {
	        result += arr[i].substring(0, 1).toUpperCase() + ". ";
	        continue;
	      }
	      result += norm(arr[i]);
	    }
	    return result;
	  }
	
	public static String tr(String s, String from, String to) {
		for (int i = 0; i < s.length(); i++) {

	        int idexof = from.indexOf(s.charAt(i));
	        if (idexof != -1) {
	            s = s.replace(s.charAt(i), to.charAt(idexof));   
	        }

	    }
	    return s;
	}
	

public static void main (String [] args) {
    System.out.println(norm("caravaggio"));
    System.out.println(norm("VERMEER"));
    System.out.println(norm("VERMEER"));
    System.out.println(init("johann sebastian bach"));
    System.out.println(init("i. babeL"));
    System.out.println(init("jorge LUIS BORGES"));
    System.out.println(init("WOLFGANG a. mozart"));
    System.out.println(tr("November 2016", "abcdefghijklmnopqrstuvwyz", "ABCDEFGHIJKLMNOPQRSTUVWYZ"));
    System.out.println(tr("abcXYZ", "aZcX", "||Cx"));


}
}
