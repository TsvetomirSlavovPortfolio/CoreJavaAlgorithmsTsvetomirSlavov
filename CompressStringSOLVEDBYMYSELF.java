
public class CompressStringSOLVEDBYMYSELF {
	
	public static String s0 = "aaab";
	public static String s1 = "aaabbbbbbcccddddddddddddddddde";
	public static String s2 = "lllllllllllllffffffffffffoooooooooooooorrrrrrrrrrkmmmmmmmmmmmmmmfffffffffffyyyyyyyyyyyrrrrriii";
	public static String s3 = "rrrrrrrrrtttttttttppppdddeeerrrrroooooooooooooooo";
	
	public static void main(String[] args) {
		compressString(s0);
		compressString(s1);
		compressString(s2);
		compressString(s3);		
	}
	
	public static void compressString(String stringToCompress){
		int count = 0;
		String compressedString = "";
		for(int i = 0; i < stringToCompress.length(); i++){
			String oneLetterPerLoopFromStringToCompress = stringToCompress.substring(i, i + 1);
			boolean isTheLoopLetterPresentInTheNewString = compressedString.contains(oneLetterPerLoopFromStringToCompress);
			if(!isTheLoopLetterPresentInTheNewString){
				if(!compressedString.equals("")){
					compressedString = compressedString.concat(String.valueOf(count));
				}
				count = 0;
				compressedString = compressedString.concat(oneLetterPerLoopFromStringToCompress);
				count++;
				if(stringToCompress.length() == i + 1){
					compressedString = compressedString.concat(String.valueOf(count));
				}
			}
			else{				
				count++;
				if(stringToCompress.length() == i + 1){
					compressedString = compressedString.concat(String.valueOf(count));
				}
			}			
		}
		System.out.println(compressedString);
	}
	

}
