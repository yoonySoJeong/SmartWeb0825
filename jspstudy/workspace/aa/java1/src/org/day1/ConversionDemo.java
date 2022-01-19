package org.day1;

public class ConversionDemo {

	public static void main(String[] args) {
		byte b;
		int i = 259;
		double d = 525.428;
		
		System.out.println("축소 형변환 결과");
		
	    b=(byte)i;
	    System.out.println("int 259 bye 로:" +b);
	    
	    i=(int)d;
	    System.out.println("double 525.428을 int로:"+i);
	    
	    b=(byte)d;
	    System.out.println("double 525.428을 byte 로:"+b);

	}

}
