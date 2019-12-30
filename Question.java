public class Question{
	protected int points;
	protected int difficulty;
	protected int answerSpace;
	protected String questionText;
	protected String answerText;
	
	public int MIN_DIFFICULTY = 1;
	public int MAX_DIFFICULTY = 5;
	
	
	public Question(int p, int d, int asp, String qtext, String ans) {
		this.points = p;
		this.difficulty = d;
		this.answerSpace = asp;
		this.questionText = qtext;
		this.answerText = ans;
	}
	
	public String toString() {
		String space = "";
		for(int i = 0; i < this.answerSpace; i++) {
			space += "\n";
		}
		return("Question: " + this.questionText + space);
	}
	
	public String theAnswer() {
		return("Answer: " + this.answerText);
	}
	
	public int getPoints() {
		return(this.points);
	}
	
}