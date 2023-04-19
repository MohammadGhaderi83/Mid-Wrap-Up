import java.util.HashMap;
import java.util.Map;

public class Lecture4Exercises {
    private static Map<Integer, Long> factorial = new HashMap<>();
    private static Map<Integer, Long> fibo = new HashMap<>();
    public long factorial(int n) {
        if (n == 0)
        {
            return 1;
        } else if (factorial.containsKey(n))
        {
            return factorial.get(n);
        } else {
            Long result = n * factorial(n-1);
            factorial.put(n, result);
            return result;
        }
    }

    public long fibonacci(int n) {
        if (n <= 1){
            return n;
        } else if (fibo.containsKey(n)) {
            return fibo.get(n);
        } else {
            long result = fibonacci(n-1) + fibonacci(n-2);
            fibo.put(n, result);
            return result;
        }
    }

    public String reverse(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = word.length()-1; i >= 0 ; i--){
            result.append(word.charAt(i));
        }
        return result.toString();
    }

    public boolean isPalindrome(String line) {
        int i = 0;
        int j = line.length() - 1;
        while (i < j) {
            char leftChar = Character.toLowerCase(line.charAt(i));
            char rightChar = Character.toLowerCase(line.charAt(j));
            if (!Character.isLetterOrDigit(leftChar)) {
                i++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                j--;
            } else if (leftChar != rightChar) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }


    public char[][] dotPlot(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        char[][] result = new char[len1][len2];

        for (int i = 0 ; i < len1 ; i++){
            for (int j = 0 ; j < len2; j++){
                if (str1.charAt(i) == str2.charAt(j)){
                    result[i][j] = '*';
                } else {
                    result[i][j] = ' ';
                }
            }
        }
        return result;
    }
}
