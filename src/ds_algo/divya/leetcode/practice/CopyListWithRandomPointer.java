package ds_algo.divya.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	public NodeRandom copyRandomList(NodeRandom head) {
		Map<NodeRandom, NodeRandom> map = new HashMap<>();
		if (head == null) {
			return null;
		}
		NodeRandom oldNode = head;
		NodeRandom newNode = new NodeRandom(oldNode.val);

		while (oldNode != null) {
			newNode.random = getNode(oldNode.random, map);
			newNode.next = getNode(oldNode.next, map);
			oldNode = oldNode.next;
			newNode = newNode.next;
		}
		return map.get(head);

	}

	public NodeRandom getNode(NodeRandom node, Map<NodeRandom, NodeRandom> map) {
		if (node != null) {
			if (map.containsKey(node)) {
				return map.get(node);
			} else {
				map.put(node, new NodeRandom(node.val));
				return map.get(node);
			}
		}
		return null;
	}
}

class NodeRandom {
	int val;
	NodeRandom next;
	NodeRandom random;

	public NodeRandom(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
