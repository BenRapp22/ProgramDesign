
public class MultipleChoice extends Question{
	private String correctAnswer;
	private String[] possibleAnswers;
	
	public MultipleChoice(int p, int d, int asp, String qtext, String cora, String[] pA) {
		super(p, d, asp, qtext, cora);
		this.correctAnswer = cora;
		this.possibleAnswers = pA;
	}
	
	public String toString() {
		String text = "";
		for(int i = 0; i < this.possibleAnswers.length; i++) {
			text += ("\n" + (i + 1) + ": " + this.possibleAnswers[i]);
		}
		return("Question: " + this.questionText + "\n" + text);
		
	}
	
	public String theAnswer() {
		String text = "Answer:\n";
		for(int i = 0; i < this.possibleAnswers.length; i++) {
			if(this.possibleAnswers[i].equalsIgnoreCase(this.correctAnswer)) {
			text += ("\n" + (i + 1) + ": ***" + this.possibleAnswers[i] + "***\n");
		}else {
		text += ((i + 1) + ": " + this.possibleAnswers[i]);
		}
		}

		return(text);
	}
}