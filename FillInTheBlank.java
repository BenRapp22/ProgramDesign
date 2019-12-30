public class FillInTheBlank extends Question{
	private String correctAnswer;
	
	public FillInTheBlank(int p, int d, int asp, String qtext, String cora){
		super(p, d, asp, qtext, cora);
		this.correctAnswer = cora;
	}
	
	public String toString() {
		return("Question: " + this.questionText);
	}
	
	public String theAnswer(){
		return("Answer: " + this.correctAnswer);
	}
}