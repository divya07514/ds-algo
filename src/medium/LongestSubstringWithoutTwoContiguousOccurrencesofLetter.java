package medium;

public class LongestSubstringWithoutTwoContiguousOccurrencesofLetter {
	
	private static String longest(String s) {
		if(s.length()==0) {
			return "";
		}	
		
		int start =0;
		int end = 0;
		int left =0;
		int count = 1;
		
		for(int right=1;right<s.length();right++) {
			
			if(s.charAt(right)==s.charAt(right-1)) {
				count++;
			}else {
				count = 1;
			}
			
			if(count<=2) {
				int diff = right-left+1;
				if(diff > end) {
					end = diff;
					start = left;
				}
			}else {
				left = right -1;
				count = 2;
			}
		}
		
		
		return s.substring(start,end);
	}

	public static void main(String[] args) {
		String one = "aabbaaaaabb";
		String two = "aabbaabbaabbaaa";
		System.out.println(longest(one));
		System.out.println(longest(two));

	}

}
