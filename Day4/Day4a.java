import java.util.*;
import java.util.stream.IntStream;
import java.util.ArrayList;

// Guess the password - how many passwords within the range 147981-691423 fit the conditions below?
// - It is a six-digit number.
// - The value is within the range given in your puzzle input.
// - Two adjacent digits are the same (like 22 in 122345).
// - Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).

public class Day4a {

    public static void main(String[] args) {
        List<Integer> possiblePasswords = new ArrayList<>();

        for (int i = 147981; i <= 691423; i++) {
            PasswordCandidate x = new PasswordCandidate(i);

            if (x.couldBePassword()) {
                possiblePasswords.add(i);
            }
        }
        System.out.println(Arrays.toString(possiblePasswords.toArray()));
        // Answer
        System.out.println("Number of possible passwords: " + possiblePasswords.size());
    }
}
