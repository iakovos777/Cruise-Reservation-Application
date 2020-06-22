//paizei na mhn xreiastoun
package cast.cruise.service;

import cast.cruise.contacts.EmailMessage;

public interface EmailProvider {
	void sendEmail(EmailMessage message);
}
