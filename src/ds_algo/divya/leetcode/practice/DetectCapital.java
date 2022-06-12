package ds_algo.divya.leetcode.practice;

public class DetectCapital {
	public static boolean detectCapitalUse(String word) {
        boolean allSmall =true;
        boolean allCaps = true;
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                continue;
            }else{
                allCaps = false;
                break;
            }
        }
        if(allCaps){
            return true;
        }
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(Character.isLowerCase(ch)){
                continue;
            }else{
                allSmall = false;
                break;
            }
        }
        if(allSmall){
            return true;
        }
        boolean firstCap = true;
        for(int i=1;i<word.length();i++){
            char ch = word.charAt(i);
            char first = word.charAt(0);
            if(Character.isUpperCase(first) && Character.isLowerCase(ch)){
                continue;
            }else{
                firstCap = false;
                break;
            }
        }
        if(firstCap){
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
		String word = "Leetcode";
		System.out.println(detectCapitalUse(word));

	}

}
