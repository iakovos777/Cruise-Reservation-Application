package cast.cruise.ui.reservation;



import cast.cruise.ui.View;

public interface EvaluationView extends View {
	 void setPresenter(EvaluationPresenter presenter);
	 String getRating();
	 String getComment();
	 void setRating(String rate);
	 void setComment(String com);
}
