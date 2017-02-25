package coreJavaInterviewQuestionsBhanu;

public class PrintDistinctElementsInArray {

	public static void main(String[] args) {
		int[] array = {5,2,7,8,8,6,9,5};
		for(int i = 0; i < array.length; i++){
			boolean isDistinct = false;
			for(int j = 0; j < i; j++){
				if(array[i] == array[j]){
					isDistinct = true;
					break;
				}
			}
			if(!isDistinct){
				System.out.println(array[i]);
			}
		}
	}

}
