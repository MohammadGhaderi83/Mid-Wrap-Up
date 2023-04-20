import java.util.ArrayList;
import java.util.List;

public class Lecture6Exercises {


    public long calculateEvenSum(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i += 2){
            sum += arr[i];
        }
        return sum;
    }


    public int[] reverseArray(int[] arr) {
        int[] reverseOrder = new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--){
            reverseOrder[i] = arr[arr.length-1-i];
        }
        return reverseOrder;
    }


    public double[][] matrixProduct(double[][] m1, double[][] m2) throws RuntimeException {
        int rows1 = m1.length;
        int cols1 = m1[0].length;
        int rows2 = m2.length;
        int cols2 = m2[0].length;
        if (rows2 != cols1){
            throw new RuntimeException("Matrices cannot be multiplied");
        } else {
            double[][] result = new double[rows1][cols2];

            for (int i = 0 ; i < rows1; i++){
                for (int j = 0 ; j < cols2 ; j++){
                    for (int k = 0; k < cols1; k++){
                        result[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
            return result;
        }
    }


    public List<List<String>> arrayToList(String[][] names) {
        List<List<String>> result = new ArrayList<>();
        for (String[] row : names){
            List<String> newRow = new ArrayList<>();
            for (String element : row){
                newRow.add(element);
            }
            result.add(newRow);
        }

        return result;
    }


    public List<Integer> primeFactors(int n) {
        List<Integer> PrimeFactors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                if (! PrimeFactors.contains(i)){
                    PrimeFactors.add(i);
                }
                n /= i;
            }
        }
        return PrimeFactors;
    }


    public List<String> extractWord(String line) {
        String[] words = line.split("\\W+");
        return List.of(words);
    }
}
