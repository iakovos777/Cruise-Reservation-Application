package cast.cruise.ui;



import java.util.List;



import cast.cruise.domain.Cruise;
import cast.cruise.ui.host.CruiseListHostPresenter;
import cast.cruise.ui.host.CruiseListHostView;





	public class CruiseListHostViewStub extends ViewStub implements CruiseListHostView{
		
		private CruiseListHostPresenter presenter;
		private List<Cruise> cruises;
		private Cruise selectedCruise;
		
		@Override
		public void setPresenter(CruiseListHostPresenter presenter) {
			this.presenter = presenter;
		}
		
		public CruiseListHostPresenter getPresenter() {
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


