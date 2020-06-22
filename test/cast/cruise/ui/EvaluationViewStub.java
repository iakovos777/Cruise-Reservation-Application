package cast.cruise.ui;



import cast.cruise.ui.reservation.EvaluationPresenter;
import cast.cruise.ui.reservation.EvaluationView;


public class EvaluationViewStub extends ViewStub implements EvaluationView {

	private EvaluationPresenter presenter;
	private String rate;
	private String com;

	@Override
	public void setPresenter(EvaluationPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	public EvaluationPresenter getPresenter(){
		return presenter;
	}

	@Override
	public String getRating() {
		return rate ; 
	}

	@Override
	public String getComment() {
		return com;
	}

	@Override
	public void setRating(String rate) {
		this.rate = rate;
		
	}

	@Override
	public void setComment(String com) {
		this.com = com;
		
	}

	

}
