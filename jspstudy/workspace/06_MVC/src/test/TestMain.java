package test;

public class TestMain {

	public static void main(String[] args) {
		
		// 인터페이스(TestInterface)를 구현한 클래스 (TestA, TestB)는 
		// 인터페이스 타입으로 생성할 수 있다.
		
		TestInterface obj = null;
		
		if ( Math.random() < 0.5 ) {
			obj = new TestA();
		} else {
			obj = new TestB();				// TestA와 TestB는 Type이 같다 == 같은 Interface를 구현했기 때문에
		}
		
		obj.doSome(); // 이건 A가 될 수도 B 가 될 수도.
		
	}

}
