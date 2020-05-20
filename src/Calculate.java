public class Calculate {

static int calc (int firstParam, int secondParam) {//Calculate
    int sign = DataParse.getSign();
    if (sign == 1){return (firstParam + secondParam);}
    else if (sign == 2){return (firstParam - secondParam);}
    else if (sign == 3){return (firstParam * secondParam);}
    else return (firstParam / secondParam);
}

    public static void printResult (String result) {//result demonstration
        System.out.println(result);
    }
}
