package Part3.ex2.메소드;

import java.util.Scanner;

public class ExamList{
	private Exam[] exams;
	private int current;
	
	public void printList() { 
		this.printList(this.current);  // printList(list, list.current);
	}
	
	public void printList(int size) {
		System.out.println("성적 출력");
		for(int i=0; i<size; i++) {
			Exam exam = this.exams[i]; 
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
		
	public void inputList() {  
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

	      	Exam[] exams = this.exams;
	      	int size = this.current;	
	      	
	      	if(exams.length == size) {
	    		Exam[] temp = new Exam[size+5];
	      		for(int i=0; i<size; i++) {
	      			temp[i] = exams[i];
	      		}
	      		this.exams = temp;  // exams에 넣으면 exams에 들어감  
	      	}
	      	this.exams[this.current] = exam;
	      	this.current++;
	}
	
	public ExamList() {
		// TODO Auto-generated method stub
		this.exams = new Exam[3]; 
		this.current = 0;
		
	}
	
	
}

