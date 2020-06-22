package cast.cruise.domain;
/**
 * Η αξιολόγηση της κρουαζιέρας.
 */

public class Evaluation {
	private static int count = 0;
	private int evalId;
	private int rating;
	private String comment;
	private boolean hasEvaluated;

	public Evaluation() {
		this.evalId = count++;
		this.hasEvaluated = false;
	}

	public Evaluation(int rating, String comment) {
		
		this.evalId = count++;
		
		this.rating = rating;
		if(this.rating!=0){
			this.hasEvaluated = true;
		}
		else{
			this.hasEvaluated = false;
		}
		this.comment = comment;
		
	}
	
	public void setEvalId(int evalId) {
		this.evalId = evalId;
	}

	public int getEvalId() {
		return evalId;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRating() {
		return rating;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
	
	public void setHasEvaluated(boolean hasEvaluated) {
		this.hasEvaluated = hasEvaluated;
	}

	public boolean getHasEvaluated() {
		return hasEvaluated;
	}
}