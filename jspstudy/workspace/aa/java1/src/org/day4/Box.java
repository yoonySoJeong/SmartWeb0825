package org.day4;

public class Box {

	public static void main(String[] args) {
		int width=0, height=0, depth=0;
		public Box() {}
		public Box(int w) {}
			width = w;
	}
		public Box(int w, int h) {
			width=w, height=h;
		}
		public void state() {
			System.out.println("Box 의 width 는 " + width);
			System.out.println("Box 의 height 는 " + height);
		}
		public static void main(String[] args) {
			Box b1 = new box(100);
			Box b2 = new (200,400);
			b1.state();
			b2.state(); 
		}
}