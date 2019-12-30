public class ObjectiveQuestion extends Question{
	private String correctAnswer;
	
	public ObjectiveQuestion(int p, int d, int asp, String qtext, String corA) {
		super(p, d, asp, qtext, corA);
		this.correctAnswer = corA;
	}
	
	public String theAnswer() {
		return("Answer: " + this.correctAnswer);
	}
	
	
}
