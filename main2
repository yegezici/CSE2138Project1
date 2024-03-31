import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class test1 {

    static String intToBin(String num) {
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



	static String floatToBin(String floatNum,int floatSize) {
		boolean negative = false;
        if(floatNum.charAt(0) == '-'){
            negative = true;
            floatNum = floatNum.substring(1);
        }
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
        for(int i = 0;i < intToBin(tempStr).length();i++){
            if(intToBin(tempStr).charAt(i) == '1'){
                exponent += ((intToBin(tempStr).length())-1-i);
                break;
            }
        }
        String fraction = intToBin(tempStr).substring(1) + tempStr2.substring(0,23);
        fraction = fraction.substring(0,23);
        if(negative){
            tempStr = "1" + intToBin(exponent + "")  + fraction;
        }
        else{
            tempStr = "0" + intToBin(exponent + "")  + fraction;
        }
        //System.out.print(decToBi(tempStr) + ".");
        System.out.println(exponent);
        System.out.println(tempStr);
        result = tempStr;
        return result;
	}

	static String unsignedToBin(String num) {
        num = num.substring(0,num.length()-1);
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

        for(int i = result.length();i <= 16;i++){
            result = '0' + result;
        }
        result = result.substring(1);
        return result;
	}
	
    public static String decToBi(String num){
        boolean negative=false;
        if(num.charAt(0)=='-') {
            num=num.substring(1);
            negative=true;
        }
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

        for(int i = result.length();i <= 16;i++){
            result = '0' + result;
        }
        result = result.substring(1);

        if(negative){
            String negativeString= "";
            for(int i = 0;i < result.length();i++){
                if(result.charAt(i) == '0'){
                    negativeString += '1';
                }
                else{
                    negativeString += '0';
                }
            }
            String finalBin = "";
            for(int i = negativeString.length()-1;i >= 0;i--){
                if(negativeString.charAt(i) == '0'){
                    finalBin = negativeString.substring(0, i) + '1' + finalBin;
                    break;
                }
                else{
                    finalBin += '0';
                }
            }
            result = finalBin;
        }
        
        return result;
    }
	
	
	
	
	
	
	
	
	
	
	

	
	static String binToHex(String entered,boolean shouldConvert) {
		int length=entered.length();
		if(length%4==1)
			entered="000"+entered;
		if(length%4==2)
			entered="00"+entered;
		if(length%4==3)
			entered="0"+entered;
		int currentNumber;
		String currentString="";
		for(int a=0;a<length;) {
			currentNumber=0;
			for(int b=8;b>=1;b/=2,a++) {
				if(entered.charAt(a)=='1')
					currentNumber+=b;
			}
			if(currentNumber<10) {
				currentString+=(char)(currentNumber+'0');
			}else {
				currentString+=(char)(currentNumber-10+'A');
			}
			
		}
		
        return currentString;
		
	}

	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (System.in);
		Scanner inputLine = new Scanner(System.in);

		System.out.print("Enter file name:");
		String inputFileName=input.next()+".txt";
        
		System.out.print("Enter byte ordering type(Little Endian or Big Endian):");
		String byteOrderingType=inputLine.nextLine();
		boolean LittleEndian=true;

		if(byteOrderingType.equals("Little Endian"))
			LittleEndian=true;
		if(byteOrderingType.equals("Big Endian"))
			LittleEndian=false;

		System.out.print("Enter the size of floating point data type:");
		int floatSize=input.nextInt();

		File inputfile=new File(inputFileName);
		PrintWriter printToFile=new PrintWriter("outputfile.txt");
		Scanner inputFile = new Scanner (inputfile);

		while (inputFile.hasNext()) {
			String line=inputFile.next();
			if(line.contains(".")) {
				printToFile.println("f"+binToHex(floatToBin(line,floatSize),LittleEndian));//baştaki f çalıştığını denemek için output dosyasına yazdırılıyor, en son silinecek.
				////////////////printToFile.println(floatToBin(line,floatSize));
			}else if(line.contains("u")) {
				///////////////printToFile.println(unsignedToBin(line));
				printToFile.println("u"+binToHex(unsignedToBin(line),LittleEndian));//baştaki u çalıştığını denemek için output dosyasına yazdırılıyor, en son silinecek.
				}else {
					printToFile.println("i"+binToHex(decToBi(line),LittleEndian));//baştaki i çalıştığını denemek için outputa dosyasına yazdırılıyor, en son silinecek.
					///////////////////printToFile.println(intToBin(line));
				}

			}
		inputLine.close();
		printToFile.close();
		input.close();
		inputFile.close();
	    }
}
