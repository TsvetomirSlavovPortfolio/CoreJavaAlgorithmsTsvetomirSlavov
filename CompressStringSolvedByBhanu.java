package coreJavaInterviewQuestionsBhanu;

public class CompressStringSolvedByBhanu {
	
	static String s1 = "aaabbccd";
	static String s2 = "rrrrrrrrrrrrrrggggggggggggnooooooooooopppppppppppppppppppppppp";

	public static void main(String[] args) {
		
		CompressStringSolvedByBhanu obj = new CompressStringSolvedByBhanu();
		obj.compressString(s1);
		System.out.println();
		obj.compressString(s2);
		
	}
	
	public void compressString(String s1){
		int count = 0;
		char temp = s1.charAt(0);
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) == temp){
				count++;
			}
			else{
				System.out.print(temp+""+count);
				count = 1;
				temp = s1.charAt(i);
			}
		}
	}

}
