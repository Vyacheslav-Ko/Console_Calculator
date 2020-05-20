import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    enum RomanNum {//part of "arabicToRoman" converter
        I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100);
        private int val;
        RomanNum(int val) {this.val = val;}
        public int getVal() {return val;}

        public static List<RomanNum> getReverseSortedValues() {
            return Arrays.stream(values()).sorted(Comparator.comparing((RomanNum e) -> e.val).reversed())
                    .collect(Collectors.toList());
        }
    }
    public static String arabicToRoman(int number) {//part of "arabicToRoman" converter
        List<RomanNum> romanNumerals = RomanNum.getReverseSortedValues();
        int temp = 0;
        StringBuilder sb = new StringBuilder();//StringBuilder because it uses less memory
        while ((number > 0) && (temp < romanNumerals.size())) {
            RomanNum currentSymbol = romanNumerals.get(temp);
            if (currentSymbol.getVal() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getVal();
            } else { temp++; }
        }
        return sb.toString();
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
