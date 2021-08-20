package Part3.ex2.메소드;

import java.util.Scanner;

public class ExamList{
	Exam[] exams;
	int current;
	
	static void printList(ExamList list) { // 같은 기능 함수가 두 개인 경우, 코드 집중화 실시
		printList(list, list.current);
	}
	
	static void printList(ExamList list, int size) {
		System.out.println("성적 출력");
//		int size = list.current;
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

	static void inputList(ExamList list) {  
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

	
	public static void init(ExamList list) {
		// TODO Auto-generated method stub
		list.exams = new Exam[3]; 
		list.current = 0;
		
	}
	
	
}

