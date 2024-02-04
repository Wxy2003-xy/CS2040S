public class sortingMethods {
    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public static void BubbleSort(int[] A) {
        //Loop invariant:
        /*  at the end of iteration j, the biggest
            j items are correctly sorted
            in the final j positions of the array;

            Best case: O(n)
            Average case: O(n^2)
            Worst case: O(n^2)

            stable
        * */
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j+1);
                }
            }
        }
        System.out.println("bbs: Sorted");
    }
    public static void SelectionSort(int[] A) {
        /* Loop invariant: */
        /*  At the end of iteration j, the smallest
            j items are correctly sorted in the first
            j positions in the array

            Best case: O(n^2)
            Average case: O(n^2)
            Worst case: O(n^2)

            NOT stable
        * */
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int minIdx = i;
            for (int j = i; j < len; j++) {
                if (A[j] < A[minIdx]) {
                    minIdx = j;
                }
            }
            swap(A, i, minIdx);
        }
        System.out.println("sls: Sorted");
    }
    public void InsertionSort(int[] A) {
        //Loop invariant:
        /*  At the end of iteration j, the first j
            are correctly sorted, within the first j
            items in the first j positions
            in the array

            Best case: O(n)   already sorted
            Average case: O(n^2)    random
            Worst case: O(n^2)  inversely sorted

            stable (if implemented carefully i.e. > instead of >=)
        * */
    }
    private static int[] merge(int[] A, int[] B, int len) {     // B is longer
        int[] merged = new int[len];
        int newPointer = 0;
        int pointerA = 0;
        int pointerB = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == A.length - 1) {
                merged[newPointer] = B[pointerB];
            }
            else if (A[i] < B[i]) {
                merged[newPointer] = A[pointerA];
                pointerA++;
                newPointer++;
            }
            else {
                merged[newPointer] = B[pointerB];
                pointerB++;
                newPointer++;
            }
        }
       return merged;
    }
    private static int[] partition(int[] A, boolean whichHalf) {
        int len = A.length / 2 - 1;
        if (whichHalf) {// first half
            int[] res = new int[len + 1];
            for (int i = 0; i < len; i++) {
                res[i] = A[i];
            }
            return res;
        }
        else {
            len = A.length - len;
            int[] res = new int[len];
            for (int i = A.length / 2 - 1; i < A.length - 1; i++) {
                res[i] = A[i];
            }
            return res;
        }
    }
    private static int[] MergeSorthelper(int[] A) {
        /*key subroutine: Merging
         *
         * */
        int len = A.length;
        if (len == 1) {
            return A;
        }
        else {
            ArrayMethods.printArray(partition(A, true));
            ArrayMethods.printArray(partition(A, false));
            return merge(MergeSorthelper(partition(A, true)),
                         MergeSorthelper(partition(A, false)), len);
        }

    }
    public static void MergeSort(int[] A) {
        ArrayMethods.copyArray(MergeSorthelper(A), A);
    }
    private int findMid(int min, int max) {
        return min + (max - min) / 2;
    }
}
