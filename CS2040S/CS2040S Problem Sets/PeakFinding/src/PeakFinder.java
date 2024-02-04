public class PeakFinder {
    static int finder(int[] arr, int len, int start, int end) {
        int mid = start + (end - start) / 2;
        if (len == 1 || start == end) {
            return mid;
        }
        else if (mid == end && arr[mid - 1] <= arr[mid]) {
            return mid;
        }
        else if (mid == start && arr[mid + 1] <= arr[mid]) {
            return mid;
        }
        else if (arr[mid - 1] <= arr[mid] && arr[mid + 1] <= arr[mid]) {
            return mid;
        }
        else if (arr[mid - 1] > arr[mid]) {
            return finder(arr, len, start, mid - 1);
        }
        else if (arr[mid + 1] > arr[mid]) {
            return finder(arr, len, mid + 1, end);
        }
        else {
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 5, 2, 1, 5, 7, 23, 5, 18, 0, 3};
        System.out.println(arr[finder(arr, arr.length, 0, arr.length - 1)]);
    }
}
