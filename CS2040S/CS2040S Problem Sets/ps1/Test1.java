import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test1 {

    ILFShiftRegister getRegister(int size, int tap) {
        return new ShiftRegister(size, tap);
    }

    @Test
    public void testShift1() {
        ILFShiftRegister r = getRegister(9, 7);
        int[] seed = { 0, 1, 0, 1, 1, 1, 1, 0, 1 };
        r.setSeed(seed);
        for (int j = 0; j < 9; j++) {
            System.out.print(seed[j]);
        }
        //int[] expected = { 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        for (int i = 0; i < 3; i++) {
            System.out.println("shift");
            for (int j = 0; j < 9; j++) {
                System.out.print(seed[j]);
            }
            System.out.println(" ");
            System.out.println(r.shift());
        }

    }

}
