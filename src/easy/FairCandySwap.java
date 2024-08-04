package easy;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0;
        int sb = 0;
        for(int i: A){
            sa = sa + i;
        }
        for(int i: B){
            sb = sb + i;
        }
        int diff = (sb-sa)/2;
        Set<Integer> set = new HashSet();
        for(int i : B){
            set.add(i);
        }
        for(int i : A){
            if(set.contains(i + diff)){
                return new int[]{i,i+diff};
            }
        }
        return new int[2];
    }
}
