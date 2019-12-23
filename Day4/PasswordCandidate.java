import java.util.*;

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

    public Map<Integer, Integer> countDuplicates() {
        // Hashmap to count frequency of each digit in digits
        Map<Integer,Integer> hm = new HashMap();
        for(Integer x:digits) {
            if(!hm.containsKey(x)){
                hm.put(x, 1);
            }
            else {
                hm.put(x, hm.get(x)+1);
            }
        }
        System.out.println(hm);
        return hm;
    }

    public boolean couldBePassword() {
        for (int i = 1; i <= 5; i++) {
            if (digits[i] < digits[i - 1]) {
                //System.out.println("Sequence descends: " + toString());
                return false;
            }
        }
        Map<Integer, Integer> hm = countDuplicates();
        for (Map.Entry mapElement : hm.entrySet()) {
            // if frequency is 2
            if (mapElement.getValue().equals(2)) {
                // no need to check if digits are adjacent as we have already checked digits are ascending
                System.out.println("Fits conditions: " + toString());
                return true;
            }
        }
        //System.out.println("Does not contain a pair: " + toString());
        return false;
    }

    @Override
    public String toString() {
        return "PasswordCandidate{" +
                "digits=" + Arrays.toString(digits) +
                '}';
    }
}
