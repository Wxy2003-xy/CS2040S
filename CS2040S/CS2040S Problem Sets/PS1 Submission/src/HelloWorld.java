/*
*Specifications:
* your name (as you prefer to be called),
• your favourite algorithm or your favourite joke,
• a few sentences of additional information on your background and who you are (but nothing
    private that you would want kept secret from the rest of the class),
• the answer(s) to the previous parts,
**/
public class HelloWorld {
    static int MysteryFunction(int argA, int argB) {
        int c = 1;
        int d = argA;
        int e = argB;
        while (e > 0) {
            if (2 * (e / 2) != e) {
                c = c * d;
            }
            d = d * d;
            e = e / 2;
        }
        return c;
    }
    public static void main(String[] args) {
        System.out.println("Hi my name is Wang Xiyu, here is a joke:");
        System.out.println("I have a nice joke but cannot fit here");
        System.out.println("Don't have a favourite algorithm cos I don't know any");
        System.out.println("Some background: Noob beginner, favourite programming language is source Chapter 2");
        System.out.println("The ans for part a) is: " + MysteryFunction(5, 5) + ".");

    }
}