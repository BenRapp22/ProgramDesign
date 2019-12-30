public class Test{
	private Question[] questions;
	
	public Test(Question[] list) {
		this.questions = list;
	}
	
	public int getTotalPoints() {
		int sum = 0;
		for(int i = 0; i < this.questions.length; i++) {
			sum += this.questions[i].points;
		}
		return(sum);
	}
	
	public String toString() {
		String text = "TEST:\n";
		for(int i = 0; i < this.questions.length; i++) {
			text += "(" + (i + 1) + ") " + this.questions[i].toString() + "\n--------------\n";
			
		}
		return(text);
	}
	
	public String theAnswer() {
		String text = "ANSWER KEY\n";
		for(int i = 0; i < this.questions.length; i++) {
			text += "(" + (i + 1) + ") " + this.questions[i].theAnswer() + "\n-------------\n";
		}
		return(text);
	}
	
}