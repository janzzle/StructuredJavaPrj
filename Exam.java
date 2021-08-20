package Part3.ex2.메소드;

public class Exam {
	int kor;
	int eng;
	int math;

	public static void main(String[] args) {
		Exam exam = new Exam();
		
		testMethod(exam);
		
		
		
	}
	
	private static void testMethod(Exam exam) {
		
		exam.kor = 30;
		System.out.println(exam.kor);
	}
}

