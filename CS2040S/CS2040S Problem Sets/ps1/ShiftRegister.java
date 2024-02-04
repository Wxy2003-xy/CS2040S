///////////////////////////////////
// This is the main shift register class.
// Notice that it implements the ILFShiftRegister interface.
// You will need to fill in the functionality.
///////////////////////////////////

/**
 * class ShiftRegister
 * @author
 * Description: implements the ILFShiftRegister interface.
 */
public class ShiftRegister implements ILFShiftRegister {
    ///////////////////////////////////
    // Create your class variables here
    ///////////////////////////////////
    // TODO:
    int size;
    int tap;
    int[] arr;

    ///////////////////////////////////
    // Create your constructor here:
    ///////////////////////////////////
    ShiftRegister(int size, int tap) {
        // TODO:
        this.size = size;
        this.tap = tap;
        this.arr = new int[size];
    }
    ///////////////////////////////////
    // Create your class methods here:
    ///////////////////////////////////
    /**
     * setSeed
     * @param seed
     * Description:
     */
    @Override
    public void setSeed(int[] seed) {
        // TODO:
        int len = seed.length;
        try {
            for (int i = 0; i < size; i++) {
                if (seed[i] != 0 && seed[i] != 1) {
                    throw new RuntimeException("Non binary seed");
                }
                arr[i] = seed[len - i - 1];
            }
        }
        catch (Exception e){
            System.out.println("Seed length exceeds register size");
        }
    }
    // debugging tool
    public void printState() {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    /**
     * shift
     * @return
     * Description:
     */
    @Override
    public int shift() {
        // TODO:
        int len = arr.length;
        int end = arr[0] ^ arr[len - tap - 1];
        for (int i = 0; i < len - 1; i++) {
            int tmp = arr[i + 1];
            arr[i] = tmp;
        }
        arr[len - 1] = end;
        return end;
    }
    private void reverse(int[] arr) {
        int len = arr.length;
        for (int i = 0; i< len/2; i++) {
            int tmp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = tmp;
        }
    }
    /**
     * generate
     * @param k
     * @return
     * Description:
     */
    @Override
    public int generate(int k) {
        // TODO:
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = shift();
        }
        reverse(result);
        //System.out.println(toDecimal(result));
        return toDecimal(result);
    }

    /**
     * Returns the integer representation for a binary int array.
     * @param array
     * @return
     */
    private int toDecimal(int[] array) {
        // TODO:
        int len = array.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] == 1) {
                res = res + powerBaseTwo(i);
            }
        }
        return res;
    }
    private int powerBaseTwo(int n) {
        return n == 0 ? 1 : 2 * powerBaseTwo(n - 1);
    }
}
