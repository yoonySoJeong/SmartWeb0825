package java1;
class Plus{
	int plus (int x, int y) {
		return x+y;
	}
	double plus (double x, double y) {
		return x+y;
	}
	int plus (int x, int z) {
		return (x+y+z);
	}
}
public class PlusDemo {
	public static void main(String[] args) {
		Plus p1 = new Plus();
		System.out.println(p1.plus(10,20));
		System.out.println(p1.plus(2.2,3.3));
		System.out.println(p1.plus(15,1.25));
		System.out.println(p1.plus(1,2,3));
	}

}
