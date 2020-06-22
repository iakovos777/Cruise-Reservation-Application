package cast.cruise.ui.cruise;
import java.util.List;



import cast.cruise.datastore.CruiseDS;
import cast.cruise.domain.Cruise;
import cast.cruise.memory.CruiseMemory;




public class CruiseListPresenter {
	private CruiseListView view;
    private List<Cruise> cruises;
    private CruiseDS cruiseds;
    
    public CruiseListPresenter(CruiseListView view) {
        this.view = view;
        cruiseds = new CruiseMemory();
    }
    
    public void start() {
        view.setPresenter(this);
        getCruiseList();
        view.open();
    }

	private void getCruiseList() {
		cruises = cruiseds.findAll();
        view.setCruises(cruises);
	}
    
    public List<Cruise> getCruises() {
        return cruises;
    }
    
   
    
    
    
}
