package easy;

import java.util.HashMap;
import java.util.Map;

public class CheckIfOneStringSwapCanMakeStringsEqual {
	
	public static boolean areAlmostEqual(String one, String two) {
        if(one.equals(two)){
            return true;
        }
		int count = 0;
		Map<Character, Character> map = new HashMap<>();
        
		for(int i = 0; i < one.length(); i++) {
            char chone = one.charAt(i);
            char chtwo = two.charAt(i);
			if (chone == chtwo) {
				continue;
			} else {
				if (map.isEmpty()) {
					map.put(chtwo, chone);
				} else {
                    if(!map.containsKey(chone) || map.get(chone) != chtwo){
                        return false;
                    }
				}
				count++;
			}
		}
		return count == 2;
	
}

	public static void main(String[] args) {
		String s1 = "bank";
		String s2 = "kanb";
		System.out.println(areAlmostEqual(s1, s2));

	}

}
