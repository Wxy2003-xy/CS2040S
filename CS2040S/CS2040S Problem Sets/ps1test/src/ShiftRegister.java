public class ShiftRegister {
    private int size;
    private int tap;
    private int[] array;

    public ShiftRegister(int size, int tap) {
        this.size = size;
        this.tap = tap;
        this.array = new int[size];
    }

    public void setSeed(int[] seed) {
        if (seed.length != size) {
            throw new IllegalArgumentException("Seed length must match register size");
        }

        // Copy the seed array into the register's array
        System.arraycopy(seed, 0, array, 0, size);
    }

    public void shift() {
        int[] newArray = new int[size];
        for (int i = 0; i < size - 1; i++) {
            newArray[i] = array[i + 1];
        }
        newArray[size - 1] = array[0] ^ array[size - tap - 1];
        array = newArray;
    }

    public void printState() {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ShiftRegister register1 = new ShiftRegister(8, 3);
        int[] seedArray = {1, 0, 1, 0, 1, 1, 0, 0};
        register1.setSeed(seedArray);

        System.out.println("Initial state of register1:");
        register1.printState();

        // Shift the register and print its state
        register1.shift();
        System.out.println("State of register1 after shifting:");
        register1.printState();
    }
}
