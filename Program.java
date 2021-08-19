package Part2.ex3.데이터구조화;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		ExamList list = new ExamList();
		list.exams = new Exam[3];  // before : Exam[] exams = new Exam[3];
		list.current = 0;
		list.exam = new Exam();

		int menu;
		boolean keepLoop = true;
		
		while(keepLoop) {
			menu = inputMenu();
		  				
		  switch(menu) {
		  case 1:
			  inputList(list); 
			  break;
		  case 2: 
		      printList(list);
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
	
	private static void printList(ExamList list) {
		System.out.println("성적 출력");
		int size = list.current;
		for(int i=0; i<size; i++) {
			Exam exam = list.exams[i]; // (5) 여기는 메인 메서드에서 list.exams로 객체 생성,
			int kor = exam.kor;		   // (6) 파라미터로 같이 들어왔기 때문에 객체 생성 없이 사용 가능 
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

	private static void inputList(ExamList list) {  
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
      		
//      	Exam exam = list.exam;  // (3) 방법이라면 list 데이터로 exam을 만들고 list.exam에 객체를 만들어주면 
      								// (4) 파라미터 list에 같이 받아올 수 있으므로 좌측과 같이 사용 가

      		Exam exam = new Exam(); // (1) 여기서 Exam 객체 미 생성시 밑으로 에러 발생, 
	      	exam.kor = kor;			// (2) 메인 메서드에 생성해도 불가(파라미터로 들어오지 않기 때문)
	      	exam.eng = eng;
	      	exam.math = math;
	      	
	      	list.exams[list.current] = exam;
	      	list.current++;			
	}
			
	static int inputMenu() {
		Scanner scan = new Scanner(System.in);

		System.out.printf("\n1. 성적입력\n2. 성적출력\n3. 종료\n");
		System.out.print("메뉴 번호 입력 : ");
		int menu = scan.nextInt();
		return menu;
	}
}
class ExamList{
	Exam[] exams;
	Exam exam;
	int current;
	
}