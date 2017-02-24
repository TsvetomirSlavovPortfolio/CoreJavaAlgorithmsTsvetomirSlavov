
public class CommonElementInArraySOLVEDBYMYSLEF {

	public static void main(String[] args) {
		int[] arr1 = {4,7,3,9,2,56,98,45,34,78,99,43};
		int[] arr2 = {3,12,2,9,40,30,4,98,99,5345,234,54,23,87,35,76,23,68,352,97,3,45,53,8,64,3523,87,53,93,27};
		
		compareTwoArrays(arr1, arr2);
	}
	
	public static void compareTwoArrays(int[] arrayOne, int[] arrayTwo){
		for(int number : arrayOne){
			for(int matchingNumber : arrayTwo){
				if(number == matchingNumber){
					System.out.println(matchingNumber);
				}
			}
		}
	}
	

}
