package ds_algo.divya.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class AddStrings {
	/**
	 * Self implemented solution
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String addStrings(String num1, String num2) {
        if(num1.isEmpty() && num2.isEmpty()){
            return "";
        }
        String result = "";
        int carry = 0;
        
        int idx1 = num1.length()-1;
        int idx2 = num2.length()-1;
        
        while(idx1 >=0 && idx2 >= 0){
            int one = Integer.parseInt(String.valueOf(num1.charAt(idx1)));
            int two = Integer.parseInt(String.valueOf(num2.charAt(idx2)));
            int temp = one + two + carry;
            if(temp > 9){
                int unit = temp%10;
                carry = 1;
                result = unit+result;
            }else{
                carry=0;
                result =temp+result;
            }
            idx1--;
            idx2--;
        }
        //System.out.println(result);
        while(idx1 >=0){
             int one = Integer.parseInt(String.valueOf(num1.charAt(idx1)));
             int temp = one + carry;
            if(temp > 9){
                int unit = temp%10;
                carry = 1;
                result = unit+result;
            }else{
                carry=0;
                 result = temp + result;
            }
            idx1--;
        }
        while(idx2 >=0){
             int one = Integer.parseInt(String.valueOf(num2.charAt(idx2)));
             int temp = one + carry;
            if(temp > 9){
                int unit = temp%10;
                carry = 1;
                result = unit+result;
            }else{
                carry=0;
                 result = temp + result;
            }
            idx2--;
        }
        if(carry==1){
            result = 1 + result;
        }
        return result;
    }
	
	/**
	 * LeetCode solution
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String addStrings_leetcode(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            p1--;
            p2--;    
        }
        if (carry != 0)
            res.append(carry);
        
        return res.reverse().toString();
    }
	public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        String start = "";
        generate(result,start,0,0,n);
        return result;
    }
    
    public static void generate(List<String> result,String start, int open, int closed,int n){
        if(start.length()==2*n){
            result.add(start);
            return;
        }
        if(open < n){
              generate(result,start+"(",open+1,closed,n);      
        }
        if(closed < open){
            generate(result,start+")",open,closed+1,n);
        }
        
    }

	public static void main(String[] args) {
		String num1 = "123999";
		String num2 = "123";
		System.out.println(addStrings(num1, num2));
		System.out.println(addStrings_leetcode(num1, num2));
		System.out.println(generateParenthesis(3));
	}

}
