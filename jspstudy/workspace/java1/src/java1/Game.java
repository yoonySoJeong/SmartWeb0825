package java1;
import java.util.Scanner;
public class Game {

	public static void main(String[] args) {
		int com, user;
		int i,j;
		String ans = "y";
		
		Scanner sc = new Scanner(System.in);
		while(!ans.eqals("n")) { //ans 가 n 이 아닌 동안 반복문 수향
		System.out.println("가위 바위 보를 입력 하세요(0,1,2");
	    user=sc.nextInt();
	    com=(int)(Math.random()*3);
	    if(com==user)
	    	system.out.println("비겼습니다.");
	    else if (com==0 && user==1);
	    	system.out.println("당신이 이겼습니다.");
	    else if (com==1 && user==2);
	    	system.out.println("당신이 이겼습니다.");
	    else if (com==2 && user==0);
    		system.out.println("당신이 이겼습니다.");
    	else 
    		system.out.println("컴퓨터가 이겼습니다.");
		system.out.println("계속 하시겠습니까 (y/n)?");
		ans=sc.next();

	}
	}
}
