package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question17LetterCombinationsofaPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return new ArrayList<>();
        HashMap<Integer, String[]> hashMap = new HashMap<>();
        hashMap.put(0, new String[] {});
        hashMap.put(1, new String[] {});
        hashMap.put(2, new String[] {"a", "b", "c"});
        hashMap.put(3, new String[] {"d", "e", "f"});
        hashMap.put(4, new String[] {"g", "h", "i"});
        hashMap.put(5, new String[] {"j", "k", "l"});
        hashMap.put(6, new String[] {"m", "n", "o"});
        hashMap.put(7, new String[] {"p", "q", "r", "s"});
        hashMap.put(8, new String[] {"t", "u", "v"});
        hashMap.put(9, new String[] {"w", "x", "y", "z"});

        List<String> finaResult = new ArrayList<>();
        finaResult.add("");

        for (int i = digits.length() - 1; i >= 0; i -= 1) {
            List<String> tempResult = new ArrayList<>();
            int number = Character.getNumericValue(digits.charAt(i));
            for (String string : hashMap.get(number)) {
                for (String temp1 : finaResult) {
                    tempResult.add(string + temp1);
                }
            }
            finaResult = tempResult;
        }
        return finaResult;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
