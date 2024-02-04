// A Java program to find a peak
// element using divide and conquer
import java.lang.*;
class PeakElement {
    static int findPeakUtil(int[] arr, int low, int high, int n) {
        int mid = low + (high - low) / 2;
        if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return mid;
        else if (mid > 0 && arr[mid - 1] > arr[mid])
            return findPeakUtil(arr, low, (mid - 1), n);
        else
            return findPeakUtil(arr, (mid + 1), high, n);
    }
    static int findPeak(int[] arr, int n)
    {
        return findPeakUtil(arr, 0, n - 1, n);
    }
    public static void main(String[] args)
    {
        int[] arr = {2, 4, 4, 5, 2, 1, 5, 7, 23, 5, 18, 0, 3};
        int n = arr.length;
        System.out.println(
                "Index of a peak point is " + findPeak(arr, n) + " which is " + arr[findPeak(arr, n)]);
    }
}
