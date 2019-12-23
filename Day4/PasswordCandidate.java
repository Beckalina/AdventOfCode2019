import java.util.Arrays;

public class PasswordCandidate {
    int[] digits = new int[6];

    public PasswordCandidate(int number) {
        digits = splitDigits(number);
    }

    public int[] splitDigits(int number) {
        int arrIndex = 5;
        while (number > 0) {
            digits[arrIndex] = number % 10;
            number = number / 10;
            arrIndex -= 1;
        }
        return digits;
    }

    public boolean couldBePassword() {
        for (int i = 1; i <= 5; i++) {
            if (digits[i] < digits[i - 1]) {
                System.out.println("Sequence descends: " + toString());
                return false;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (digits[i] == digits[i+1]) {
                System.out.println("Fits conditions: " + toString());
                return true;
            }
        }
        System.out.println("Does not contain a pair: " + toString());
        return false;
    }

    @Override
    public String toString() {
        return "PasswordCandidate{" +
                "digits=" + Arrays.toString(digits) +
                '}';
    }
}
