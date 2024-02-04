// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class BSearch {
    public static int k = 0;
    public static int[] arr = {2, 4, 4, 5, 6, 7, 8, 9, 11, 17, 23, 28};
    public static void main(String[] args) {
        System.out.println(search(arr, 11));
    }

    public static int search(int[] arr, int key) {
        int begin = 0;
        int end = 11;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (key <= arr[mid]) {
                end = mid;
                System.out.println("shift end");
            }
            else {
                begin = mid + 1;
                System.out.println("shift begin");
            }
            k++;
            System.out.println("k incremented to " + k);
        }
        return arr[begin];
    }
}