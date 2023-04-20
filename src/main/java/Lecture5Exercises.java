import java.util.Random;

public class Lecture5Exercises {


    private static final String lowerCaseLetters  = "abcdefghijklmnopqrstuvwxyz";
    private static final String digits            = "0123456789";
    private static final String specialCharacters = "!@#$%^&*()";
    public String weakPassword(int length) {
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++){
            int index = random.nextInt(lowerCaseLetters.length());
            char randomChar = lowerCaseLetters.charAt(index);
            password.append(randomChar);
        }
        return password.toString();
    }

    public String strongPassword(int length) throws Exception {
        if (length < 3){
            throw new IllegalArgumentException("Input must be greater than 3");
        } else {
            StringBuilder password = new StringBuilder();
            Random random = new Random();
            password.append(getRandomCharacter(digits, random));
            password.append(getRandomCharacter(specialCharacters, random));
            password.append(getRandomCharacter(lowerCaseLetters, random));
            for (int i = 3; i < length; i++) {
                String characterSet = getRandomCharacterSet(random);
                char randomCharacter = getRandomCharacter(characterSet, random);
                password.append(randomCharacter);
            }
            return password.toString();
        }
    }

    public boolean isFiboBin(int n) {
        Lecture4Exercises lecture4Exercises = new Lecture4Exercises();
        for (int i = 1 ; i < n ; i++){
            String binary = Integer.toBinaryString(i);
            int bin = howManyOnes(Integer.parseInt(binary));
            long fib = lecture4Exercises.fibonacci(i);
            if (n == (fib + bin)){
                return true;
            }
        }
        return false;
    }
    public String getRandomCharacterSet(Random random){
        int index = random.nextInt(3);
        switch (index) {
            case 0:
                return lowerCaseLetters;
            case 1:
                return specialCharacters;
            case 2:
                return digits;
            default:
                return "";
        }
    }
    private char getRandomCharacter(String characterSet, Random random){
        int index = random.nextInt(characterSet.length());
        return characterSet.charAt(index);
    }
    public int howManyOnes(int n){
        int temp;
        int counter = 0;
        while (n > 0){
            temp = n%10;
            n /= 10;
            if (temp == 1){
                counter++;
            }
        }
        return counter;
    }
}
