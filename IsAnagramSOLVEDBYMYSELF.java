package coreJavaInterviewQuestionsBhanu;

public class IsAnagramSOLVEDBYMYSELF {

	static String s1 = "abc";
	static String s2 = "bca";
	
	public static void main(String[] args) {
		IsAnagramSOLVEDBYMYSELF obj = new IsAnagramSOLVEDBYMYSELF();
		obj.isAnagram(s1, s2);

	}
	
	public void isAnagram(String string1, String string2){
		boolean anagram = false;		
		for(int i = 0; i < string1.length(); i++){			
			char temp = string1.charAt(i);
			for(int j = 0; j < string2.length(); j++){				
				char temp2 = string2.charAt(j);
				if(temp == temp2){
					anagram = true;
					break;
				}
				else{
					anagram = false;
				}
			}
			
		}		
		if(anagram){
			System.out.println("Yes it is a anagram!");
		}
		else{
			System.out.println("It is not an anagram!");
		}
	}

}
