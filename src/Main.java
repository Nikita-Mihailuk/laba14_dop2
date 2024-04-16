import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String input = "";
        String empty;
        while (true) {
            empty = input;
            System.out.print("Введите строку: ");
            input = in.nextLine();

            if(sequence(input) && (input.startsWith(empty) || input.endsWith(empty))) {
                System.out.println("True");
            }
            else {
                System.out.println("False");
                break;
            }
        }
    }
    public static boolean sequence(String inputString){

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (int i = 0; i <= inputString.length()-1; i++) {
            str1 = str1.append(Character.getNumericValue(inputString.charAt(0))+i);
            str2 = str2.append(Character.getNumericValue(inputString.charAt(0))-i);
        }

        Pattern pattern1 = Pattern.compile(str1.toString());
        Matcher matcher1 = pattern1.matcher(inputString);

        Pattern pattern2 = Pattern.compile(str2.toString());
        Matcher matcher2 = pattern2.matcher(inputString);

        if (matcher1.find() || matcher2.find()) { return true; }
        return false;
    }
}