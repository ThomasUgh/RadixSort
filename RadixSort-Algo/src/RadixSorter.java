import java.util.ArrayList;
import java.util.List;

public class RadixSorter {
    public String sort(String input) {
        List<Character> digits = new ArrayList<>();
        List<Character> uppercase = new ArrayList<>();
        List<Character> lowercase = new ArrayList<>();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
            } else if (Character.isUpperCase(c)) {
                uppercase.add(c);
            } else if (Character.isLowerCase(c)) {
                lowercase.add(c);
            }
        }

        char[] digitArray = listToCharArray(digits);
        char[] uppercaseArray = listToCharArray(uppercase);
        char[] lowercaseArray = listToCharArray(lowercase);

        radixSort(digitArray, 10);
        radixSort(uppercaseArray, 26);
        radixSort(lowercaseArray, 26);

        return new String(lowercaseArray) + new String(uppercaseArray) + new String(digitArray);
    }

    private char[] listToCharArray(List<Character> list) {
        char[] array = new char[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private void radixSort(char[] array, int radix) {
        int n = array.length;
        char[] output = new char[n];
        int[] count = new int[radix];

        for (int pos = 1; pos >= 0; pos--) {
            for (int i = 0; i < radix; i++) {
                count[i] = 0;
            }

            for (int i = 0; i < n; i++) {
                count[getIndex(array[i], pos, radix)]++;
            }

            for (int i = 1; i < radix; i++) {
                count[i] += count[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int idx = getIndex(array[i], pos, radix);
                output[count[idx] - 1] = array[i];
                count[idx]--;
            }

            for (int i = 0; i < n; i++) {
                array[i] = output[i];
            }
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
        return 0;
    }
}
