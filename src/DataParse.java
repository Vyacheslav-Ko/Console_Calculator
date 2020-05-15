import java.io.IOException;
import java.util.Scanner;

class DataParse {
    private static String[] signs = {"+", "-", "*", "/"};
    static String[] romanDigits = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static int sign;
    static int tempFlag;

    static String[] userInput(){//get user data
        System.out.println("Введите данные для вычисления. Допустимо использование римских, либо арабских чисел в диапазоне от 1 до 10, а также знаков + - / *.");
        System.out.println("Между числами необходим пробел." + "\n" + "Input:" + "\n");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine().trim();//data receiving then delete unused spaces "before 'n after"
        input.close();//scanner close
        System.out.println("\n" + "Output:" + "\n");
        String[] tok = userInput.split("\\s");// split string with space as delimiter
        return tok;
    }

    static boolean signsCheck(String tempSignsCheck) {//check sign correctness
        for (int i = 0; i < signs.length; i++) {
            if (tempSignsCheck.equals(signs[i])) {
                sign = i + 1;//save type of sign
                return true;
            }
        }
        return false;
    }

    static int getSign(){
        return sign;
    }//getter

    static int romanCheck(String tempRoman) {//roman digits checking
        for (int i = 0; i < romanDigits.length; i++) {
            if (tempRoman.equalsIgnoreCase(romanDigits[i])) {
                return i + 1;
            }
        }
        return tempFlag = 11;
    }

    static int arabicCheck(String tempArabic) {//arabic digits checking
        try {
            if ((Integer.parseInt(tempArabic) > 0) & ((Integer.parseInt(tempArabic) < 11))) {
                return Integer.parseInt(tempArabic);
            }
        } catch (NumberFormatException e) {
            return tempFlag = 11;
        }
        return tempFlag = 11;
    }
}
