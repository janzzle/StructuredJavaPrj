package Part3.ex2.메소드;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ExamList list = new ExamList();
		ExamList.init(list);		// 객체 생성, 초기화는 ExamList 클래스에서 하도록 함수 설정 
//		list.exams = new Exam[3]; 
//		list.current = 0;
		
		int menu;
		boolean keepLoop = true;
		
		while(keepLoop) {
			menu = inputMenu();
		  				
		  switch(menu) {
		  case 1:
			  ExamList.inputList(list); // 중요! 외부 클래스의 함수 이용 시 '클래스.' 필수 
			  break;
		  case 2: 
			  ExamList.printList(list);
		      break;
		  case 3:
			  System.out.println("Good Bye");
			  keepLoop = false;
			  break;
		  default : 
			  System.out.println("1~3 중에 선택해주세요");
		  } 
		}
	}
	
	
			
	static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.printf("\n1. 성적입력\n2. 성적출력\n3. 종료\n");
		System.out.print("메뉴 번호 입력 : \n");

		int menu = scan.nextInt();
		return menu;
	}
}
