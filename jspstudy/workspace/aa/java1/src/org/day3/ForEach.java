package org.day3;

public class ForEach {

	public static void main(String[] args) {
		int n[] = {2,4,6,8,10};
		int sum = 0;
		
		for(int k:n)
			sum+=k;
		System.out.println("합은 "+ sum);
		
	}

}
