package cast.cruise.ui.cruise;
import cast.cruise.ui.View;
import java.util.List;
import cast.cruise.domain.Cruise;

public interface CruiseListView extends View {
	 void setPresenter(CruiseListPresenter presenter);
	 void setCruises(List<Cruise> cruises);
	 Cruise getSelectedCruise();
	
}
