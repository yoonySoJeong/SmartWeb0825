package org.day2;

public class Switch {

	public static void main(String[] args) {

		for (int i=1;i<5;i++) {  //i 가 1에서 지삭 해서 5보다 작을때 까지 ++ 증가 한다.
			                     
		switch(i) {
		case 1, 2:  // case 뒤는 결과 답으로 설정 필
			System.out.println(i+" :가위");break;
            // break 가 있어야만 하나씩 처리함, 없으면 계속 이어서 처리함
		case 3,4:
			System.out.println(i+" :바위");break;
		case 5:
			System.out.println(i+" :보");break;
        default: System.out.println(i+"잘못된 입력");
        
		}
		
		}
	}
}
