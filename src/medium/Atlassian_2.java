package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
We are working on a security system for a badged-access room in our company's building.

Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:

1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)

2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)

Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.

records1 = [
  ["Paul",     "enter"],
  ["Pauline",  "exit"],
  ["Paul",     "enter"],
  ["Paul",     "exit"],
  ["Martha",   "exit"],
  ["Joe",      "enter"],
  ["Martha",   "enter"],
  ["Steve",    "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "enter"],
  ["Joe",      "enter"],
  ["Curtis",   "exit"],
  ["Curtis",   "enter"],
  ["Joe",      "exit"],
  ["Martha",   "enter"],
  ["Martha",   "exit"],
  ["Jennifer", "exit"],
  ["Joe",      "enter"],
  ["Joe",      "enter"],
  ["Martha",   "exit"],
  ["Joe",      "exit"],
  ["Joe",      "exit"] 
]

Expected output: ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]

Other test cases:

records2 = [
  ["Paul", "enter"],
  ["Paul", "exit"],
]

Expected output: [], []

records3 = [
  ["Paul", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
]

Expected output: ["Paul"], ["Paul"]

records4 = [
  ["Raj", "enter"],
  ["Paul", "enter"],
  ["Paul", "exit"],
  ["Paul", "exit"],
  ["Paul", "enter"],
  ["Raj", "enter"],
]

Expected output: ["Raj", "Paul"], ["Paul"]

All Test Cases:
mismatches(records1) => ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]
mismatches(records2) => [], []
mismatches(records3) => ["Paul"], ["Paul"]
mismatches(records4) => ["Raj", "Paul"], ["Paul"]

n: length of the badge records array


*/
public class Atlassian_2 {

	public static void main(String[] argv) {

		String[][] records1 = { { "Paul", "enter" }, { "Pauline", "exit" }, { "Paul", "enter" }, { "Paul", "exit" },
				{ "Martha", "exit" }, { "Joe", "enter" }, { "Martha", "enter" }, { "Steve", "enter" },
				{ "Martha", "exit" }, { "Jennifer", "enter" }, { "Joe", "enter" }, { "Curtis", "exit" },
				{ "Curtis", "enter" }, { "Joe", "exit" }, { "Martha", "enter" }, { "Martha", "exit" },
				{ "Jennifer", "exit" }, { "Joe", "enter" }, { "Joe", "enter" }, { "Martha", "exit" }, { "Joe", "exit" },
				{ "Joe", "exit" }, };

		String[][] records2 = { { "Paul", "enter" }, { "Paul", "exit" }, };

		String[][] records3 = { { "Paul", "enter" }, { "Paul", "enter" }, { "Paul", "exit" }, { "Paul", "exit" }, };

		String[][] records4 = { { "Raj", "enter" }, { "Paul", "enter" }, { "Paul", "exit" }, { "Paul", "exit" },
				{ "Paul", "enter" }, { "Raj", "enter" }, };

		System.out.println(get(records1));

		System.out.println(get(records2));

		System.out.println(get(records3));

		System.out.println(get(records4));

	}

	private static List<List<String>> get(String[][] records) {

		Map<String, List<String>> map = new HashMap();

		for (String[] s : records) {
			String n = s[0];
			String op = s[1];
			if (!map.containsKey(n)) {
				List<String> l = new ArrayList();
				l.add(op);
				map.put(n, l);
			} else {
				map.get(n).add(op);
			}
		}

		Set<String> one = new HashSet();
		Set<String> two = new HashSet();
		List<List<String>> result = new ArrayList();

		for (String s : map.keySet()) {
			String n = s;
			List<String> op = map.get(n);

			if (op.size() == 1) {
				if (op.get(0).equals("enter")) {
					one.add(n);
				} else if (op.get(0).equals("exit")) {
					two.add(n);
				}
				continue;
			}
			
			int left = 0;
			while(left<op.size()) {
				String curr = op.get(left);
				String next = "";
				if(left+1<op.size()) {
					next = op.get(left+1);
				}
				if(curr.equals("enter") && next.equals("exit")){
					left=left+2;
					continue;
				}else {
					if(curr.equals("enter")) {
						one.add(n);
					}else{
						two.add(n);
					}
				}
				left++;
			}


		}
		List<String> enter = new ArrayList(one);
		List<String> exit = new ArrayList(two);

		result.add(enter);
		result.add(exit);

		return result;

	}

}
