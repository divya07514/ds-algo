package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CohortSelection {

	public static List<String> solution(List<String> ill, List<String> drugs, List<String> cohorts) {

		List<String> result = new ArrayList();

		Map<String, List<String>> illmap = new HashMap();

		for (String s : ill) {

			String[] temp = s.split(", ");
			String patient = temp[0];
			String bimari = temp[1];

			if (!illmap.containsKey(bimari)) {
				List<String> list = new ArrayList();
				list.add(patient);
				illmap.put(bimari, list);
			} else {
				illmap.get(bimari).add(patient);
			}

		}

		Map<String, List<String>> dmap = new HashMap();

		for (String s : drugs) {

			String[] temp = s.split(", ");
			String patient = temp[0];
			String d = temp[1];

			if (!dmap.containsKey(d)) {
				List<String> list = new ArrayList();
				list.add(patient);
				dmap.put(d, list);
			} else {
				dmap.get(d).add(patient);
			}

		}

		for (String str : cohorts) {

			String[] temp = str.split(", ");
			List<List<String>> list = new ArrayList();

			for (String s : temp) {

				List<String> val = new ArrayList();
				if (illmap.containsKey(s)) {
					val.addAll(illmap.get(s));
				}
				if (dmap.containsKey(s)) {
					val.addAll(dmap.get(s));
				}
				list.add(val);
			}
			String fin = findCommonValues(list);
			if (fin != "[]") {
				result.add(fin);
			}

		}

		return result;

	}

	public static String findCommonValues(List<List<String>> lists) {

		List<String> commonValues = new ArrayList<>(lists.get(0));

		for (List<String> list : lists) {
			commonValues.retainAll(list);
		}
		Set<String> set = new HashSet();
		for (String str : commonValues) {
			set.add(str);
		}
		commonValues.clear();
		for (String str : set) {
			commonValues.add(str);
		}
		Collections.sort(commonValues);
		String result = String.join(", ", commonValues);
		result = "[" + result + "]";

		return result;
	}

	public static void main(String[] args) {
		List<String> ill = new ArrayList();
		ill.add("p1, melanoma");
		ill.add("p2, glio");
		ill.add("p3, melanoma");

		List<String> drugs = new ArrayList();
		drugs.add("p1, d1");
		drugs.add("p2, d1");
		drugs.add("p3, d2");
		drugs.add("p3, d1");

		List<String> cohort = new ArrayList();
		cohort.add("melanoma, d1");
		cohort.add("d1, glio");
		cohort.add("melanoma, d1, d2");

		System.out.println(solution(ill, drugs, cohort));

	}

}
