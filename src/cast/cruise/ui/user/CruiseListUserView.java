package cast.cruise.ui.user;

import java.util.List;

import cast.cruise.domain.Cruise;
import cast.cruise.ui.View;


public interface CruiseListUserView extends View {
	void setPresenter(CruiseListUserPresenter presenter);
	 void setCruises(List<Cruise> cruises);
	 Cruise getSelectedCruise();
	 int getPositions();
	 
	
	void setPositions(int position);
}
