public class ArrayMethods {
    public static void printArray(int[] A) {
        System.out.println("Array: ");
        for (int j : A) {
            System.out.print(j);
        }
    }
    public static void copyArray(int[] src, int[] tar) {
        if (src.length != tar.length) {
            System.out.println("error");
        }
        else {
            for (int i = 0; i < src.length; i++) {
                tar[i] = src[i];
            }
        }
    }
}
