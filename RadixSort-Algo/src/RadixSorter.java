import java.util.ArrayList;
import java.util.List;

public class RadixSorter {

    public String sort(String input) {
        List<Character> digits = new ArrayList<>();
        List<Character> uppercase = new ArrayList<>();
        List<Character> lowercase = new ArrayList<>();

        categorizeCharacters(input, digits, uppercase, lowercase);

        char[] digitArray = convertListToArray(digits);
        char[] uppercaseArray = convertListToArray(uppercase);
        char[] lowercaseArray = convertListToArray(lowercase);

        sortArray(digitArray, 10);
        sortArray(uppercaseArray, 26);
        sortArray(lowercaseArray, 26);

        return combineSortedArrays(lowercaseArray, uppercaseArray, digitArray);
    }

    private void categorizeCharacters(String input, List<Character> digits, List<Character> uppercase, List<Character> lowercase) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
            } else if (Character.isUpperCase(c)) {
                uppercase.add(c);
            } else if (Character.isLowerCase(c)) {
                lowercase.add(c);
            }
        }
    }

    private char[] convertListToArray(List<Character> list) {
        char[] array = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private void sortArray(char[] array, int radix) {
        if (array.length <= 1) {
            return; // No need to sort if the array is empty or has one element
        }

        char[] output = new char[array.length];
        int[] count = new int[radix];

        for (int pos = 1; pos >= 0; pos--) {
            resetCountArray(count, radix);
            countOccurrences(array, count, pos, radix);
            accumulateCount(count, radix);
            buildSortedOutput(array, output, count, pos, radix);
            System.arraycopy(output, 0, array, 0, array.length);
        }
    }

    private void resetCountArray(int[] count, int radix) {
        for (int i = 0; i < radix; i++) {
            count[i] = 0;
        }
    }

    private void countOccurrences(char[] array, int[] count, int pos, int radix) {
        for (char c : array) {
            count[getIndex(c, pos, radix)]++;
        }
    }

    private void accumulateCount(int[] count, int radix) {
        for (int i = 1; i < radix; i++) {
            count[i] += count[i - 1];
        }
    }

    private void buildSortedOutput(char[] array, char[] output, int[] count, int pos, int radix) {
        for (int i = array.length - 1; i >= 0; i--) {
            int idx = getIndex(array[i], pos, radix);
            output[count[idx] - 1] = array[i];
            count[idx]--;
        }
    }

    private int getIndex(char c, int pos, int radix) {
        if (Character.isDigit(c)) {
            return c - '0';
        } else if (Character.isUpperCase(c)) {
            return c - 'A';
        } else if (Character.isLowerCase(c)) {
            return c - 'a';
        }
        throw new IllegalArgumentException("Invalid character: " + c);
    }

    private String combineSortedArrays(char[] lowercaseArray, char[] uppercaseArray, char[] digitArray) {
        StringBuilder sortedString = new StringBuilder(lowercaseArray.length + uppercaseArray.length + digitArray.length);
        sortedString.append(lowercaseArray);
        sortedString.append(uppercaseArray);
        sortedString.append(digitArray);
        return sortedString.toString();
    }
}
