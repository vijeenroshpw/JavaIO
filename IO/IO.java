package IO;
import java.io.*;
 

public final class IO {
	static DataInputStream din;            // a data input stream object	
	static boolean is_good;
	static String line;	
	static {
		//try {		
			din = new DataInputStream(System.in);
		//} catch(IOException e) {
		//	System.out.println(" There is some issues with the terminal , Check your console configuration. ");
		//}		
		is_good = false;
		line = "";	
	}
	

        /* Reads a integer from the standard input . If you entered a malformed integer ,
	   the function will prompt for a integer again */	
	public static int  readInt() {  
		int data = 0;		
		while( !is_good ) {
			try {
				line = din.readLine();
				data = Integer.parseInt(line);
				is_good = true;			
			} catch( Exception e ) {
				System.out.println(" Bad Integer , Please Re-enter!!");
			}
		}
		is_good = false; 
		return data;
	}
	public static float  readFloat() {  
		float data = 0;		
		while( !is_good ) {
			try {
				line = din.readLine();
				data = Float.parseFloat(line);
				is_good = true;			
			} catch( Exception e ) {
					System.out.println(" Bad Floating value , Please Re-enter !!");
			}
		}
		is_good = false; 
		return data;
	}
	public static char  readChar() {  
		char data = 'c';		
		while( !is_good ) {
			try {
				line = din.readLine();
				data = line.charAt(0);
				is_good = true;			
			} catch( Exception e ) {
					System.out.println(" No char entered , Please Re-Enter !!");
			}
		}
		is_good = false; 
		return data;
	}
	public static String  readString() {  
		String data = "";		
		while( !is_good ) {
			try {
				line = din.readLine();
				data = line;
				is_good = true;			
			} catch( Exception e ) {
					
			}
		}
		is_good = false; 
		return data;
	}
	public static Double  readDouble() {  
		Double data = 0.00;		
		while( !is_good ) {
			try {
				line = din.readLine();
				data = Double.parseDouble(line);
				is_good = true;			
			} catch( Exception e ) {
				System.out.println(" Bad Double value , Please Re-enter !!");	
			}
		}
		is_good = false; 
		return data;
	}
}

