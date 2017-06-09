package easy;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyboardRow {
    public static String[] findWords(String[] words) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('Q', 1);
        hashMap.put('W', 1);
        hashMap.put('E', 1);
        hashMap.put('R', 1);
        hashMap.put('T', 1);
        hashMap.put('Y', 1);
        hashMap.put('U', 1);
        hashMap.put('I', 1);
        hashMap.put('O', 1);
        hashMap.put('P', 1);
        hashMap.put('A', 2);
        hashMap.put('S', 2);
        hashMap.put('D', 2);
        hashMap.put('F', 2);
        hashMap.put('G', 2);
        hashMap.put('H', 2);
        hashMap.put('J', 2);
        hashMap.put('K', 2);
        hashMap.put('L', 2);
        hashMap.put('Z', 3);
        hashMap.put('X', 3);
        hashMap.put('C', 3);
        hashMap.put('V', 3);
        hashMap.put('B', 3);
        hashMap.put('N', 3);
        hashMap.put('M', 3);
        ArrayList<String> list = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            int i = hashMap.get(Character.toUpperCase(chars[0]));
            boolean error = false;
            for (char ch : chars) {
                if (hashMap.get(Character.toUpperCase(ch)) != i) {
                    error = true;
                    break;
                }
            }
            if (!error)
                list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
       String[] result = findWords(new String[] {"Hello", "Alaska", "Dad", "Peace"});
    }
}
