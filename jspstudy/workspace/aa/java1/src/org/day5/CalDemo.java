package org.day5;
class Calculator{
	int right;
	int left;
	
	void setOperand(int r, int l) {
		this.right=r;
		this.left=l;
	}
	int sum() {
		return (right+left);
	}
}
public class CalDemo {
	public static void main(String[] args) {
		Claculator c1 = new Calculator();
		c1.setOperand (20,10);
		System.out.println(c1.sum());
		c2.setOperand(5,9);
		System.out.println(c2.sum());
	}

}
