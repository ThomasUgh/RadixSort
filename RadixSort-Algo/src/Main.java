import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        var input = "a1B2c3A4D5e6F7g8H9i0J";

        var sorter = new RadixSorter();
        var sortedOutput = sorter.sort(input);

        out.println("Original String: " + input);
        out.println("Sorted String: " + sortedOutput);
    }
}
