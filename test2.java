import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test2 {
    // FInd how many trailing zeros in factorial of a number.
    static int trailingZeros(int n) {
        int count = 0;
        while (n > 1) {
            n = n / 5;
            count += n;
        }
        return count;
    }

    // Find all the anagram pairs
    static class anagramClass {
        static String frequencyArray(String word) {
            char[] array = word.toCharArray();
            Arrays.sort(array);
            return new String(array).toLowerCase();
        }

        static List<List<String>> findAnagramPairs(List<String> words) {
            Map<String, List<String>> map = new HashMap<>();
            for (String w : words) {
                String frequencyArray = frequencyArray(w);
                map.computeIfAbsent(frequencyArray, k -> new ArrayList<>()).add(w);
            }
            List<List<String>> anagramPairs = new ArrayList<>();
            for (List<String> w : map.values()) {
                if (w.size() > 1) {
                    anagramPairs.add(w);
                }
            }
            return anagramPairs;
        }
    }
    
    // Finding Fibonacci Series
    static void Fibonacci(int n){
        int sum = 0;
        int a = 1; System.out.println("0");
        for(int i = 2; i<=n; i++){
            int temp = a;
            a += sum;
            sum = temp;
            System.out.println(sum);
        }
    }
    
    // Find Occurences of a digit in a number
    static void occurrence(int n, int digit){
        int count = 0;
        while(n >0){
        int rem = n%10;
        if(rem == digit){
            count++;
        }
        n/=10;
        }
        System.out.println("Number of occurrences is: " +count);
    }

    // Revrse a Number
    static void reverseNum(int n){
        int rem = 0;
        while(n>0){
            rem = n%10;
            System.out.print(rem);
            n /= 10;
        }
    }

    static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> h = new HashMap<>();
        for(int i = 0; i< magazine.length(); i++){
            char r = magazine.charAt(i);
            int c = h.getOrDefault(r, 0);
            h.put(r, c+1);
    }
    for(int i = 0; i < ransomNote.length(); i++){
        char r = ransomNote.charAt(i);
        int c = h.getOrDefault(r, 0);
        if(c == 0){
            return false;
        }
        h.put(r, c-1);
    }
            return true;
    }

    // Main Method
    public static void main(String[] args) {
        System.out.println(trailingZeros(700));
        List<String> words = Arrays.asList("Praise", "Raisepe", "Get", "Egt", "Hello", "Lehlo");
        List<List<String>> pairs = test2.anagramClass.findAnagramPairs(words);

        for (List<String> pair : pairs) {
            System.out.println("Anagram Pair: " + pair);
        }
        Fibonacci(7);
        occurrence(1462001132, 0);
        reverseNum(1189230);
        System.out.println(canConstruct("abba", "abbba"));
    }
}
