public class test {
    public static void main(String[] args)throws Exception{
        /*File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);

        while(scanner.hasNextLine()){

        }*/

        fDecToBi("243.76");

        /*String number = "12005";
        System.out.println(number + " -> " + decToBi(number));
        String binary = "1101001";
        System.out.println(binary + " -> " + biToDec(binary));
        String input = "-9";
        System.out.println(input + " -> " + Type(input));
        String Hex = "110000111010";
        System.out.println(Hex + " -> " + biToHex(Hex));
        System.out.println(1275 + " -> " + biToHex(decToBi(1275)));*/
    }
    public static String decToBi(String num){
        int number = Integer.parseInt(num);
        String result = "";
        boolean bool = true;
        char ch;
        do{
            ch = (char)((number % 2) + '0');
            result = ch + result;
            number /= 2;
            if(number == 0){
                bool = false;
            }
        }while(bool);
        return result;
    }

    public static int biToDec(String binary){
        int result = 0;
        int length = binary.length();
        String ch;
        for(int i = length-1,j = 0;i >= 0;i--,j++){
            ch = binary.charAt(i) + "";
            result = result + Integer.parseInt(ch)*(int)(Math.pow(2,j));
        }
        return result;
    }

    public static String Type(String input){
        String result = "signed integer";
        int length = input.length();
        char ch;
        for(int i=0;i < length;i++){
            ch = input.charAt(i);
            if(ch == '.'){
                result = "floating point number";
            }
            else if(ch == 'u'){
                result = "unsigned integer";
            }
        }
        return result;
    }

    public static String biToHex(String binary){
        String result = "";
        String tempStr = "";
        int tempInt = 0;
        int length = binary.length();
        if(length%4 != 0){
            for(int l = 4-(length%4);l>0;l--){
                binary = '0' + binary;
            }
        }
        System.out.println(binary);
        for(int i = 0,j=4;j<=length+1;i+=4,j+=4){
            tempStr = binary.substring(i, j);
            tempInt = biToDec(tempStr);
            switch(tempInt){
                case 10:
                result = result + 'A';break;
                case 11:
                result = result + 'B';break;
                case 12:
                result = result + 'C';break;
                case 13:
                result = result + 'D';break;
                case 14:
                result = result + 'E';break;
                case 15:
                result = result + 'F';break;
                default:
                result = result + tempInt;
            }
        }
        return result;
    }

    public static String fDecToBi(String floatNum){
        String result = "";
        int length = floatNum.length();
        String tempStr = "";
        String tempStr2 = "";
        float tempF;
        int exponent = 127;
        for(int i = 0;i < length;i++){
            if(floatNum.charAt(i) == '.'){
                tempStr = floatNum.substring(0, i);
                tempStr2 = "0." + floatNum.substring(i+1,length);
                break;
            }
        }


        tempF = Float.parseFloat(tempStr2);
        tempStr2 = "";
        for(int j = 0;j < 23;j++){
            tempF *= 2;
            if(tempF >= 1.0){
                tempStr2 += '1';
                tempF -= 1.0;
            }
            else{
                tempStr2 += '0';
            }
        }
        for(int i = 0;i < decToBi(tempStr).length();i++){
            if(decToBi(tempStr).charAt(i) == '1'){
                exponent += ((decToBi(tempStr).length())-1-i);
                break;
            }
        }
        tempStr = "0 " + decToBi(exponent + "") + " " + decToBi(tempStr).substring(1) + tempStr2;
        //System.out.print(decToBi(tempStr) + ".");
        System.out.println(exponent);
        System.out.println(tempStr);
        return result;
    }
}
