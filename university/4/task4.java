import java.util.*; 
  
class arroy 
{ 
	 public static void main(String[] args) {
		  int[] numArray1 = {2,3,4,3,6,7,6,8,2,9};
		  int[] numArray2 = {2,3,6,8,5,1};
		  for(int i = 0; i < numArray1.length; i++){
		   for(int j = 0; j < numArray2.length; j++){
		    if(numArray1[i] == numArray2[j]){
		     System.out.println(numArray1[i]);
		     break;
		     
		    }
		   }
		  }
		  
		 }
		}
