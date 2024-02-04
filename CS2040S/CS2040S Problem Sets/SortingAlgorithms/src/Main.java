/*
* 1.Bubble sort
* 2. selection sort
* 3. insertion sort
* 4. merge sort
*
*
*
* Properties:
* 1. time
* 2. space
*      additional space required
*       1. O(n)
*       2. O(1) in-place
* 3. stability
*       whether same key stay in the same order
*
*
* Problem definition:
*   array A ==> a sorted permutation of A
*
* design an interface
* */

public class Main {
    static int[] A = {3, 2, 5, 4, 1, 7, 6};
    public static void main(String[] args) {
        sortingMethods.MergeSort(A);
        //sortingMethods.swap(A, 0, 1);
        ArrayMethods.printArray(A);
    }
}