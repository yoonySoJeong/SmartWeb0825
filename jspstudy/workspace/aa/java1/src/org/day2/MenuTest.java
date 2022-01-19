// switch 사용 가격을 알려 주는, 에스프레소, 카푸치노,라떼 3500 , 아메 2000

package org.day2;
import java.util.Scanner;
public class MenuTest {

	public static void main(String[] args) {
        string oder;  // string 패치 받아야 함.......이거 나중에 하
	    int price;
        
		Scanner sc = new Scanner(System.in);
		System.out.println("무슨 커피를 드릴까요?");
	    oder=sc.next();
	    
	    switch(oder) {
	    case "에스프레소", "카푸치노", "카페라떼" :
	    	price=3500;break;
	    case "아메리카노", "카푸치노", "카페라떼" :
	    	price=2000;break;
        default: 
    	    System.out.println("메뉴에 없습니다. "); }
	    
	    System.out.println(oder + "는" + price + "원 입니다. ");
	    sc.close();
	    
	    
	}

}
