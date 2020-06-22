package cast.cruise.ui;



import java.util.List;



import cast.cruise.domain.Reservation;
import cast.cruise.ui.reservation.ReservationListPresenter;
import cast.cruise.ui.reservation.ReservationListView;

public class ReservationListViewStub extends ViewStub implements ReservationListView {
	private ReservationListPresenter presenter;
	private List<Reservation> reserves;
	private Reservation selectedReserve;
	
	@Override
	public void setPresenter(ReservationListPresenter presenter) {
		this.presenter = presenter;
		
	}
	
	public ReservationListPresenter getPresenter(){
		return presenter;
	}

	@Override
	public void setReservations(List<Reservation> reserves) {
		this.reserves = reserves;
		
	}
	
	public List<Reservation> getReservations(){
		return reserves;
	}

	@Override
	public Reservation getSelectedReserve() {
		return selectedReserve;
	}
	
	public void setSelectedReserve(Reservation selectedReserve){
		this.selectedReserve = selectedReserve ;
	}

}
