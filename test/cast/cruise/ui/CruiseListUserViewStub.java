package cast.cruise.ui;



import java.util.List;





import cast.cruise.domain.Cruise;
import cast.cruise.ui.user.CruiseListUserPresenter;
import cast.cruise.ui.user.CruiseListUserView;

public class CruiseListUserViewStub extends ViewStub implements CruiseListUserView {

	private CruiseListUserPresenter presenter;
	private List<Cruise> cruises;
	private Cruise selectedCruise;
	
	private int pos;

	@Override
	public void setPresenter(CruiseListUserPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	public CruiseListUserPresenter getPresenter() {
		return presenter;
	}

	@Override
	public void setCruises(List<Cruise> cruises) {
		this.cruises = cruises;
		
	}
	
	public List<Cruise> getCruises() {
		return cruises;
	}

	@Override
	public Cruise getSelectedCruise() {
		
		return selectedCruise;
	}
	
	public void setSelectedCruise(Cruise selectedCruise ){
		this.selectedCruise = selectedCruise;
	}

	@Override
	public int getPositions() {
		
		return pos;
	}
	
	public void setPositions(int positions){
		pos = positions;
	}

	

}
