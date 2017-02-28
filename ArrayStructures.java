package algorithms;


public class ArrayStructures {
	
	private int[] theArray = new int[50]; // creates an array with 50 indexes
	
	private int arraySize = 10; // Elements in theArray
	
	// Fills the Array with random values
	public void generateRandomArray(){
		
		System.out.println("\nGenerating new random array.");
		
		for(int i = 0; i < arraySize; i++){
			
			// Random number 10 through 19
			theArray[i] = (int)(Math.random()*10)+10;
			
		}
	}
	
	// Prints the Array on the screen in a grid
	public void printArray(){
		
		System.out.println("---------");
		for(int i = 0; i < arraySize; i++){
			
			System.out.print("| " + i + " |");
			System.out.println(" " + theArray[i] + " |");
			
			System.out.println("----------");
			
		}
		
	}
	
	// Gets value at provided index
	public int getValueAtIndex(int index){
		
		if(index < arraySize) return theArray[index];
		
		return 0;
		
	}
	
	// Returns true or false if a value is in the Array
	public boolean doesArrayContainThisValue(int searchValue){
		
		boolean valueInArray = false;
		
		for(int i = 0; i < arraySize; i++){
			
			if(theArray[i] == searchValue){
				
				valueInArray = true;				
			}			
		}
		
		return valueInArray;
	}
	
	// Delete Array row for the index and move elements up
	// so we just replace without deleting achieving a delete and moving all the values down by one
	public void deleteIndex(int index){
		
		if(index < arraySize){
			
			for(int i = index; i < (arraySize -1); i++){
				
				theArray[i] = theArray[i+1];
				
			}
			
			arraySize--;
			
		}
		
	}
	
	public void insertValue(int value){
		if(arraySize < 50){
			
			theArray[arraySize] = value;
			
			arraySize++;
			
		}
	}
	
	// Linear Search : Every index must be looked at
	public String linearSearchForValue(int value){
		
		boolean valueInArray = false;
		
		String indexsWithValue = "";		
		
		System.out.println("\nLinear searching for value: " + value);
		
		for(int i = 0; i < arraySize; i++){
			
			if(theArray[i] == value){
				
				valueInArray = true;
				
				System.out.print(i + " ");
				
				indexsWithValue+= i + " ";
				
			}
			
			printHorzArray(i, -1);
			
		}		
		
		if(!valueInArray){
			
			indexsWithValue = "None";
			
		}
		
		System.out.print("The Value was Found in the Following: " + indexsWithValue);
		
		System.out.println();
		
		return indexsWithValue;
				
	}
	
	//Bubble sort sorts everything from smallest to largest 
	// The idea is that when we start from the beginning and only swap 2 adjacent indexes,
	//at the time we reach the end of the array we are sure that the last index now is the
	//greatest in the array because even if it has been the first it would have moved on each
	//swap towards the end. So we can exclude the last index on the next iteration of the
	//outer loop which is decreasing, while the inner loop is increasing - which is the idea
	// of the bubble sort - two loops in opposite directions
	public void bubbleSort(){
		
		System.out.println();
		System.out.println("Bubble sorting:");
		
		// i starts at the end of the Array
		// As it is decremented all indexes greater
		// then it are sorted
		for(int i = arraySize -1; i > 1; i--){
			
			// The inner loop starts at the beginning of 
			// the array and compares each value next to each 
			// other. If the value is greater then they are 
			// swapped
			for(int j = 0; j < i; j++){
				
				// To change sort to Descending change to <
				if(theArray[j] > theArray[j+1]){
					
					swapValues(j, j+1);
					
					printHorzArray(i, j);
					
				}
				
				printHorzArray(i, j);
				
			}
			
		}
		
	}
	
	public void swapValues(int indexOne, int indexTwo){
		
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
		
	}
	
	// The Binary Search is quicker than the linear search
	// because all the values are sorted. Because everything
	// is sorted once you get to a number larger than what
	// you are looking for you can stop the search. Also
	// you be able to start searching from the middle 
	// which speeds the search. It also works best when 
	// there are no duplicates
	public void binarySearchForValue(int value){
		
		int lowIndex = 0;
		int highIndex = arraySize -1;
		boolean matchFound = false;
		
		System.out.println();
		System.out.println("Binary searching for value: " + value);
		
		while(lowIndex <= highIndex){
			
			int middleIndex = (highIndex + lowIndex) / 2;
			
			//decrease the search area by half this is the goal here
			if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
			
			else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;			
			
			else{
				
				System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);
				matchFound =true;
				lowIndex = highIndex + 1;				
				
			}
			
			printHorzArray(middleIndex, -1);
			
		}
		
		if(!matchFound){
			
			System.out.println("\nNo Match was found for " + value);
			
		}	
	}
	
	// Selection sort search for the smallest number in the array
	// saves it in the minimum spot and then repeats searching
	// through the entire array each time
	public void selectionSort(){
		
		System.out.println("\nSelection sorting:");
		
		for(int x = 0; x < arraySize; x++){
			
			int minimum = x;
			
			// on each iteration we store the lowest value of all the left indexes at the location
			// of x moving up in the array by 1 and storing the lowest possible of what is left in x
			for(int y = x; y < arraySize; y ++){
				
				if(theArray[minimum] > theArray[y]){
					
					minimum = y;
					
				}
				
			}
			
			swapValues(x, minimum);
			
			printHorzArray(x, -1);
			
			
		}
		
	}
	
	public void insertionSort(){
		
		System.out.println("\nInsertion sorting:");
		
		for(int i = 1; i < arraySize; i++){
			
			int j = i;
			
			int toInsert = theArray[i];
			
			while((j > 0) && (theArray[j-1]) > toInsert){
				
				theArray[j] = theArray[j-1];
				j--;
				
				printHorzArray(i, j);
				
			}
			
			theArray[j] = toInsert;
			
			printHorzArray(i, j);
			
			System.out.println("\nArray[i] = " + theArray[i] + 
					" Array[j] = " + theArray[j] + " toInsert = " + toInsert);
			
		}
		
		
	}
	
	public static void main(String[] args){
		
		ArrayStructures newArray = new ArrayStructures();
		ArrayStructures newArray2 = new ArrayStructures();
		ArrayStructures newArray3 = new ArrayStructures();
		
		newArray.generateRandomArray();
		newArray2.generateRandomArray();
		newArray3.generateRandomArray();
		
		newArray.printArray();
		
		System.out.println(newArray.getValueAtIndex(3));
		
		System.out.println(newArray.doesArrayContainThisValue(15));
		
		newArray.deleteIndex(4);
		
		newArray.printArray();
		
		newArray.insertValue(55);
		
		newArray.printArray();
		
		newArray.linearSearchForValue(17);
		
		newArray.bubbleSort();
		
		newArray.binarySearchForValue(11);
		
		newArray2.selectionSort();
		
		newArray3.insertionSort();
		
		
	}
	
	
	
	
	
public void printHorzArray(int i, int j){
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++){
			
			System.out.print("| " + n + "  ");
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++){
			
			System.out.print("| " + theArray[n] + " ");
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		// END OF FIRST PART
		
		
		// ADDED FOR BUBBLE SORT
		
		if(j != -1){
		
			// ADD THE +2 TO FIX SPACING
			
			for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
			
			System.out.print(j);
			
		}
		
		
		// THEN ADD THIS CODE
		
		if(i != -1){
			
			// ADD THE -1 TO FIX SPACING
			// I changed it to -2 so it can be centered against the box that it represents
			for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
			
			System.out.print(i);
			
		}
		
		System.out.println();
		
	}





}
