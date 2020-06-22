

package cast.cruise.service;

import java.util.List;

import cast.cruise.exception.CruiseException;
import cast.cruise.datastore.*;
import cast.cruise.domain.*;
import cast.cruise.contacts.*;
import cast.cruise.memory.*;



public class NotificationService {
	private EmailProvider provider;

    
    public void setProvider(EmailProvider provider) {
        this.provider = provider;
    }

    
    public void notifyUser() {
        if (provider == null) {
            throw new CruiseException();
        }

        ReservationDS reserve = new ReservationMemory();
        List<Reservation> allreserves = reserve.findAll();
        for (Reservation res : allreserves) {
            if (!res.getHasPrePay()) {
                String message = composeMessage(res);
                       
                sendEmail(res.getUser(),
                        "", message);
            }
        }
    }


    private void sendEmail(User user,
            String subject, String message) {
        EmailAddress eMail = user.getEmail();
        if (eMail == null || !eMail.isValid()) {
            return;
        }
        
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setTo(eMail);
        emailMessage.setSubject(subject);
        emailMessage.setBody(message);
        provider.sendEmail(emailMessage);
    }
    
    private String composeMessage(Reservation reserve) {
        String message = " ";
        message += reserve.getReservationId();
        message += " ";
        message += "CANCELED";
        message += "  ";
        return message;
    }
}
