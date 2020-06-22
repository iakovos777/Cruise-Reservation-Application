package cast.cruise.ui.reservation;

import java.util.List;

import cast.cruise.domain.Reservation;
import cast.cruise.ui.View;


public interface ReservationListView extends View {
	 void setPresenter(ReservationListPresenter presenter);
	 void setReservations(List<Reservation> reserves);
	 Reservation getSelectedReserve();

}
