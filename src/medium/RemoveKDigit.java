package medium;

import java.util.LinkedList;

public class RemoveKDigit {
	
    public static String removeKdigits(String num, int k) {
        if(num.length()<0){
            return "0";
        }
        LinkedList<Character> stack = new LinkedList();
        stack.push(num.charAt(0));
        
        for(int i=1;i<num.length();i++){
            char c =  num.charAt(i);
            if(c >= stack.peek()){
                stack.push(c);
            }else{
                while(!stack.isEmpty() && stack.peek() > c && k>0){
                    k--;
                    stack.pop();
                }
                stack.push(c);
            }
        }
        String result = "";
        while(!stack.isEmpty()){
            result = stack.pop() + result;
        }
        result = result.substring(0,result.length()-k);
        int index = 0;
        while(index<result.length() && result.charAt(index)=='0'){
            index++;
        }
        if(index==result.length()){
            return "0";
        }
        result= result.substring(index);

        return result;
    }

	public static void main(String[] args) {
		String num = "1432219";
		int k = 3;
		System.out.println(removeKdigits(num, k));
	}

}
