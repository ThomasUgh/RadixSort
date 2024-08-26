import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        var input = "a1B2c3A4D5e68F7g8H9ig5dgnh8443b3hhh4pg7dDPlOZxl9Sobf3g04egdg4h4ggd0J";

        var sorter = new RadixSorter();
        var sortedOutput = sorter.sort(input);

        out.println("Original String: " + input);
        out.println("Sorted String: " + sortedOutput);
    }
}
