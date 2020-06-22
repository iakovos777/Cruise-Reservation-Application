package cast.cruise.ui.host;

import java.util.List;

import cast.cruise.domain.Cruise;
import cast.cruise.ui.View;


public interface CruiseListHostView extends View {
	void setPresenter(CruiseListHostPresenter cruiseListHostPresenter);
	 void setCruises(List<Cruise> cruises);
	 Cruise getSelectedCruise();
}
