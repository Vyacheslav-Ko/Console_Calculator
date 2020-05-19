/*
* written by Vyacheslav Kozlov on 13/05/2020
 */

import java.util.zip.DataFormatException;

public class ConsoleCalculator {
    public static void main(String[] args) throws DataFormatException {
        String[] tokens = DataParse.userInput();//get user data
        if (tokens.length != 3) {//the number of participants must be equal to 3
            System.out.println("Введенные данные некорректны.");
            throw new DataFormatException();
        }
        boolean signCorrect = DataParse.signsCheck(tokens[1]);//check sign corrrectness
        int romanTemp1 = DataParse.romanCheck(tokens[0]);//roman digits parsing
        int romanTemp2 = DataParse.romanCheck(tokens[2]);
        if (signCorrect & (romanTemp1 < 11) & (romanTemp2 < 11)) {
            int resultArabic1 = Calculate.calc(romanTemp1, romanTemp2);
            String romanResult = DataParse.arabicToRoman(resultArabic1);
            Calculate.printResult(romanResult);
        } else if (signCorrect & DataParse.arabicCheck(tokens[0]) < 11 & DataParse.arabicCheck(tokens[2]) < 11) {
            int resultArabic2 = Calculate.calc(DataParse.arabicCheck(tokens[0]), DataParse.arabicCheck(tokens[2]));
            Calculate.printResult(String.valueOf(resultArabic2));
        } else {
            System.out.println("Введенные данные некорректны");
            throw new NumberFormatException();
        }
    }
}
