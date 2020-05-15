public class Calculate {

static void calc (int firstParam, int secondParam){
    int sign = DataParse.getSign();
    switch (sign) {
        case 1: System.out.println(firstParam + secondParam);
            break;
        case 2: System.out.println(firstParam - secondParam);
            break;
        case 3: System.out.println(firstParam * secondParam);
            break;
        case 4: System.out.println(firstParam / secondParam);
            break;
        default: break;
    }
}
}
