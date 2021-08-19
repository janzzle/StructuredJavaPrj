package Part2.ex3.데이터구조화;

import java.util.Scanner;

public class ListProgram {

	public static void main(String[] args) {

		ExamList list = new ExamList();
		list.exams = new Exam[3];  // before : Exam[] exams = new Exam[3];
		list.current = 0;
		
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
			Exam exam = list.exams[i]; 
			int kor = exam.kor;		   
			int eng = exam.eng;
			int math = exam.math;
			
			int total = kor+eng+math;
			float avg = total/3.0f;
			
			System.out.printf("국어 : %3d\n", kor);
			System.out.printf("영어 : %3d\n", eng);
			System.out.printf("수학 : %3d\n", math);
		    System.out.printf("총점 : %3d\n", total);
		    System.out.printf("평균 : %6.2f\n", avg);
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

      		Exam exam = new Exam(); 
	      	exam.kor = kor;
	      	exam.eng = eng;
	      	exam.math = math;

	      	Exam[] exams = list.exams;
	      	int size = list.current;	// 임시 변수 생성 
	      	
	      	if(exams.length == size) {
	    		Exam[] temp = new Exam[size+5];
	      		for(int i=0; i<size; i++) {
	      			temp[i] = exams[i];
	      		}
	      		list.exams = temp;  // exams에 넣으면 exams에 들어감  
	      	}
	      	list.exams[list.current] = exam;
	      	list.current++;
	}
			
	static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.printf("\n1. 성적입력\n2. 성적출력\n3. 종료\n");
		System.out.print("메뉴 번호 입력 : \n");

		int menu = scan.nextInt();
		return menu;
	}
}
class ExamList{
	Exam[] exams;
	int current;
}