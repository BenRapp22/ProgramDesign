public class Driver{
	public static void main(String args[]) {
//		Question q1 = new Question(1, 2, 3, "Hi", "Hey");
//		System.out.println(q1.toString());
//		System.out.println("hi");
		
		String[] pos = {"a", "b", "c"};
		MultipleChoice q2 = new MultipleChoice(1, 2, 3, "a, b, or c?", "b", pos);
//		System.out.println(q2.toString());
//		System.out.println("-------------");
//		System.out.println(q2.theAnswer());
		
		FillInTheBlank q3 = new FillInTheBlank(2, 4, 5, "______ was the sixteenth president of the United States", "Abraham Lincoln");
		ObjectiveQuestion q4 = new ObjectiveQuestion(5, 1, 4, "Who am I?", "I am Ben");
		
		Question[] testbank = {q2, q3, q4};
		
		Test abcd = new Test(testbank);
		System.out.println(abcd.toString());
//		System.out.println();
		System.out.println(abcd.theAnswer());
		
		
	}
}