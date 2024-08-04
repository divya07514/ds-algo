package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
You are with your friends in a castle, where there are multiple rooms named after flowers. Some of the rooms contain treasures - we call them the treasure rooms. 

Each room contains a single instruction that tells you which room to go to next.

 *** instructions_1 *** 

 lily ---------     daisy  sunflower
               |       |     |
               v       v     v
 jasmin ->  tulip      violet    -> rose --->
            ^    |      ^             ^     |
            |    |      |             |     |
            ------    iris            -------

This is given as a list of pairs of (source_room, destination_room)

instructions_1 = [ 
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "tulip"], 
    ["rose", "rose"],
    ["violet", "rose"], 
    ["sunflower", "violet"],
    ["daisy", "violet"],
    ["iris", "violet"]
]

Write a function that takes two parameters as input:
* a list containing the treasure rooms, and
* a list of instructions represented as pairs of (source_room, destination_room)

and returns a collection of all the rooms that satisfy the following two conditions:

* at least two *other* rooms have instructions pointing to this room
* this room's instruction immediately points to a treasure room 

treasure_rooms_1 = ["lily", "tulip", "violet", "rose"]

filter_rooms(treasure_rooms_1, instructions_1) => ["tulip", "violet"]
* tulip can be accessed from rooms lily and jasmin. Tulip's instruction points to a treasure room (tulip itself)
* violet can be accessed from daisy, sunflower and iris. Violet's instruction points to a treasure room (rose)

Additional inputs

treasure_rooms_2 = ["lily", "jasmin", "violet"]  

filter_rooms(treasure_rooms_2, instructions_1) => []
* none of the rooms reachable from tulip or violet are treasure rooms

 *** instructions_2 *** 

 lily --------             ------
               |          |      |
               v          v      |
 jasmin ->  tulip -- > violet ---^  

instructions_2 = [ 
    ["jasmin", "tulip"],
    ["lily", "tulip"],
    ["tulip", "violet"],
    ["violet", "violet"]       
]

treasure_rooms_3 = ["violet"]

filter_rooms(treasure_rooms_3, instructions_2) => [tulip]
* tulip can be accessed from rooms lily and jasmin. Tulip's instruction points to a treasure room (violet)

All the test cases: 
filter_rooms(treasure_rooms_1, instructions_1)    => ["tulip", "violet"]
filter_rooms(treasure_rooms_2, instructions_1)    => [] 
filter_rooms(treasure_rooms_3, instructions_2)    => [tulip]

Complexity Analysis variables:
T: number of treasure rooms
I: number of instructions given
*/

public class Atlassian_1 {

	public static List<String> filter(String[][] inst, String[] treasure) {

		Map<String, List<String>> one = new HashMap();

		for (String[] s : inst) {
			String src = s[0];
			String dest = s[1];
			if (src.equals(dest)) {
				continue;
			}
			if (!one.containsKey(dest)) {
				List<String> list = new ArrayList();
				list.add(src);
				one.put(dest, list);
			} else {
				one.get(dest).add(src);
			}
		}
		Map<String, String> two = new HashMap();

		for (String[] s : inst) {
			String left = s[0];
			String right = s[1];
			two.put(left, right);
		}
		Set<String> set = new HashSet();
		for (String s : treasure) {
			set.add(s);
		}

		List<String> result = new ArrayList();

		for (String s : one.keySet()) {
			List<String> list = one.get(s);
			if (list.size() >= 2) {
				String str = two.get(s);
				if (set.contains(str)) {
					result.add(s);
				}
			}
		}

		return result;

	}

	public static void main(String[] argv) {
		String[][] instructions_1 = { { "jasmin", "tulip" }, { "lily", "tulip" }, { "tulip", "tulip" },
				{ "rose", "rose" }, { "violet", "rose" }, { "sunflower", "violet" }, { "daisy", "violet" },
				{ "iris", "violet" } };

		String[][] instructions_2 = { { "jasmin", "tulip" }, { "lily", "tulip" }, { "tulip", "violet" },
				{ "violet", "violet" } };

		String[] treasure_rooms_1 = { "lily", "tulip", "violet", "rose" };
		String[] treasure_rooms_2 = { "lily", "jasmin", "violet" };
		String[] treasure_rooms_3 = { "violet" };

		List<String> r1 = filter(instructions_2, treasure_rooms_3);
		System.out.println(r1);

		List<String> r2 = filter(instructions_1, treasure_rooms_1);
		System.out.println(r2);

		List<String> r3 = filter(instructions_1, treasure_rooms_2);
		System.out.println(r3);

	}

}
