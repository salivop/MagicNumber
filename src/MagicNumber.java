import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MagicNumber {
    public static void main(String[] args) {
        checkMagicNumber();
    }

    private static void checkMagicNumber() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String multipliedSortedNumber;
        boolean isMagicNumber = true;

        System.out.println("Enter magic number");
        try {
            int number = Integer.parseInt(br.readLine());
            String str = Integer.toString(number);
            String sortedNumber = sortString(str);

            for (int i = 2; i <= str.length(); i++) {
                multipliedSortedNumber = sortString(Integer.toString(number * i));
                if (multipliedSortedNumber.equals(sortedNumber) == false) {
                    isMagicNumber = false;
                    break;
                }
            }
            if (isMagicNumber) {
                System.out.println(number + " is a magic number");
            } else {
                System.out.println(number + " is not a magic number");
            }
        } catch (IOException e) {
            System.out.println("Unexpected error");
            e.printStackTrace();
        }
    }

    private static String sortString(String number) {
        String sortedString = "";
        char chars[] = number.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char r = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = r;
                }
            }
        }
        for (int i = 0; i < chars.length; i++)
            sortedString = sortedString + chars[i];
        return sortedString;
    }

}






