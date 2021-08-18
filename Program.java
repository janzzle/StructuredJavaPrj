package Part2.ex3.데이터구조화;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Exam[] exams = new Exam[3];
		Test test = new Test();
		System.out.println(test.current);
		int menu;
		boolean keepLoop = true;
		
		while(keepLoop) {
			menu = inputMenu();
		  				
		  switch(menu) {
		  case 1:
			  inputList(exams, test); 
			  break;
		  case 2: 
		      printList(exams, test);	//exams라는 것을 출력해주세요 
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
	
	private static void printList(Exam[] exams, Test t) {
		System.out.println("성적 출력");
		int size = t.current;
		for(int i=0; i<size; i++) {
			Exam exam = exams[i];
			int kor = exam.kor;	//임시 변수 사용 
			int eng = exam.eng;
			int math = exam.math;
			
			int total = kor+eng+math;
			float avg = total/3.0f;
			
			System.out.printf("국어 : %3d\n", kor);
			System.out.printf("영어 : %3d\n", eng);
			System.out.printf("수학 : %3d\n", math);
	    
		    System.out.printf("총점 : %3d\n", total);
		    System.out.printf("평균 : %6.2f\n", avg);
		    System.out.println();
		}
	}

	private static void inputList(Exam[] exams, Test t) { // 지역변수 current를 넘겨받음 
		Scanner scan = new Scanner(System.in);
	    System.out.println("성적 입력");
	   	int kor, eng, math;
			
		do {
		    System.out.printf("국어 : ");
			kor = scan.nextInt();
			
			if(kor < 0 || 100 < kor) {	
			  System.out.println("성적 범위(0~100)를 벗어났습니다");
			    } 
			  } while(kor < 0 || 100 < kor);
	      	
      	do {
	        System.out.printf("영어 : ");
	        eng = scan.nextInt();
	        
	        if(eng < 0 || 100 < eng) {	
	          System.out.println("성적 범위(0~100)를 벗어났습니다");
	        } 
	      } while(eng < 0 || 100 < eng);
	      	
      	do {
	        System.out.printf("수학 : ");
	        math = scan.nextInt();
	        
	        if(math < 0 || 100 < math) {	
	          System.out.println("성적 범위(0~100)를 벗어났습니다");
	        } 
	      } while(math < 0 || 100 < math);
      		Exam exam = new Exam();
	      	exam.kor = kor;
	      	exam.eng = eng;
	      	exam.math = math;
	      	
	      	exams[t.current] = exam;
	      	t.current++;			// current 사본에 +1 하므로 원 current는 그대로 0
	}
			
	static int inputMenu() {
		Scanner scan = new Scanner(System.in);

		System.out.printf("\n1. 성적입력\n2. 성적출력\n3. 종료\n");
		System.out.print("메뉴 번호 입력 : ");
		int menu = scan.nextInt();
		return menu;
	}
}
class Test{
	int current;
	
	public Test() {
		current = 0;
	}
}