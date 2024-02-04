public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 5, 6, 7, 8, 9, 11, 17, 23, 28};
        int key = 11;

        int result = binarySearch(arr, key);

        if (result != -1) {
            System.out.println("Element " + key + " found at index " + result);
        } else {
            System.out.println("Element " + key + " not found in the array");
        }
    }

    public static int binarySearch(int[] arr, int key) {
        int begin = 0;
        int end = arr.length - 1;

        while (begin <= end) {
            int mid = begin + (end - begin) / 2;

            if (arr[mid] == key) {
                return mid; // Key found, return the index
            } else if (key < arr[mid]) {
                end = mid - 1; // Adjust the search range
            } else {
                begin = mid + 1; // Adjust the search range
            }
        }

        return -1; // Key not found
    }
}
