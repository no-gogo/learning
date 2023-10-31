import java.util.Random;

public class TestQuestion {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(8) + 3);
    }

    public static void selectionSort (int[] list) {
        int mindex;
        int nextSmallest;
        for (int unSortedStart=0; unSortedStart<list.length-1; unSortedStart++) {
            mindex = unSortedStart;
            for (int currIndex=unSortedStart+1; currIndex<list.length; currIndex++) {
                if (list[currIndex] < list[mindex]) {
                    mindex = currIndex;
                }
            }
    
            nextSmallest = list[mindex];
            list[mindex] = list[unSortedStart];
            list[unSortedStart] = nextSmallest;
        }
    }    

    public static void selectionSort (Comparable[] list) {
        int mindex;
        Comparable nextSmallest;
        for (int unSortedStart=0; unSortedStart<list.length-1; unSortedStart++) {
            mindex = unSortedStart;
            for (int currIndex=unSortedStart+1; currIndex<list.length; currIndex++) {
                if (list[currIndex].compareTo(list[mindex])<0) {
                    mindex = currIndex;
                }
            }
    
            nextSmallest = list[mindex];
            list[mindex] = list[unSortedStart];
            list[unSortedStart] = nextSmallest;
        }
    }    


}