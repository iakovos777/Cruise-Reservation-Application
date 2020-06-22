package cast.cruise.ui;



import java.util.List;



import cast.cruise.domain.Cruise;
import cast.cruise.ui.cruise.CruiseListPresenter;
import cast.cruise.ui.cruise.CruiseListView;


public class CruiseListViewStub extends ViewStub implements CruiseListView {

	private CruiseListPresenter presenter;
	private List<Cruise> cruises;
	private Cruise selectedCruise;
	
	@Override
	public void setPresenter(CruiseListPresenter presenter) {
		this.presenter = presenter;
	}
	
	public CruiseListPresenter getPresenter() {
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
	
	public void setSelectedCruise(Cruise selectedCruise) {
		this.selectedCruise = selectedCruise;
	}

}
