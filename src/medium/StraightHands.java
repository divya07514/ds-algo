package medium;

import java.util.PriorityQueue;

public class StraightHands {

    public static boolean isNStraightHand(int[] hand, int W) {
        
        if(hand.length % W != 0) return false;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int elem: hand) minHeap.add(elem);

        while(!minHeap.isEmpty()){
            int head = minHeap.poll();
            for(int i=1; i<W; i++)
                if(!minHeap.remove(head+i)) return false;
        }
        return true;
    }

	public static void main(String[] args) {
		int[] hand = {1,1,2,2,3,3};
		int gs =2;
		System.out.println(isNStraightHand(hand, gs));
	}

}
