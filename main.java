import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class sys {
	static String floatToBin(String line,int floatSize) {
		return "1111";
	}
	static String unsignedToBin(String line) {
		return "1111";
	}
	static String intToBin(String line) {
		/*String converted="";
		int a=0;
		if(line.charAt(0)=='-') {
			a++;
			converted+=1;
		}
		else
			converted+=0;
		while(a<line.length()) {
			
			
		}*/
		return "1111";
	}
	static String binToHex(String entered,boolean shouldConvert) {
		String converted="";
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
		if(length%8<4)
			currentString="0"+currentString;
		if(shouldConvert) {
			for(int a=currentString.length()-2;a>-1;a-=2) {
				converted+=(char)currentString.charAt(a)+""+(char)currentString.charAt(a+1);
				if(a!=0)
					converted+=" ";
			}
			return converted;
		}else {
			for(int a=0;a<currentString.length();a+=2) {
				converted+=(char)currentString.charAt(a)+""+(char)currentString.charAt(a+1);
				if(a!=currentString.length()-2)
					converted+=" ";
			}
			return converted;
		}
		
	}
	static String hexConverter() {
		return "";
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
					printToFile.println("i"+binToHex(intToBin(line),LittleEndian));//baştaki i çalıştığını denemek için outputa dosyasına yazdırılıyor, en son silinecek.
					///////////////////printToFile.println(intToBin(line));
				}

			}
		inputLine.close();
		printToFile.close();
		input.close();
		inputFile.close();
	    }
}
