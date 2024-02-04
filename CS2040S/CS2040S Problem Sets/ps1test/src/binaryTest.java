import java.util.*;
public class binaryTest {
    public int toBinary(int decInput) {
        return decInput == 0
                ? 0
                : decInput == 1
                ? 1
                : decInput % 2 == 0
                ? 10 * toBinary(decInput / 2)
                : 1 + toBinary(decInput - 1);
    }

}
