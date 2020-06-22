package cast.cruise.contacts;



/**
	 * ������ ������������ ������������.
	 * ��� ������ ������������ ������������ ������������ ���
	 * ��� ���������, ��� ���������, �� ���� ���
	 * �� ������� (����) ��� ���������.
	 * 
	 *
	 */
	public class EmailMessage {
	    private EmailAddress from;
	    private EmailAddress to;
	    private String subject;
	    private String body;
	    
	    /**
	     * ����� �� ��������� ��� ���������.
	     * @param from � ���������� ��� ���������.
	     */
	    public void setFrom(EmailAddress from) {
	        this.from = from;
	    }

	    /**
	     * ���������� ��� ��������� ��� ���������.
	     * @return � ���������� ��� ���������.
	     */
	    public EmailAddress getFrom() {
	        return from;
	    }


	    /**
	     * ����� ��� ��������� ��� ���������.
	     * @param to � ����������.
	     */
	    public void setTo(EmailAddress to) {
	        this.to = to;
	    }

	    /**
	     * ���������� ��� ��������� ��� ���������.
	     * @return � ����������
	     */
	    public EmailAddress getTo() {
	        return to;
	    }
	    
	    /**
	     * ����� �� ���� ��� ���������.
	     * @param subject �� ���� ��� ���������.
	     */
	    public void setSubject(String subject) {
	        this.subject = subject;
	    }


	    /**
	     * ���������� �� ���� ��� ���������.
	     * @return �� ���� ��� ���������.
	     */
	    public String getSubject() {
	        return subject;
	    }


	    /**
	     * ����� �� ������� ��� ���������.
	     * @param body �� ������� ��� ���������.
	     */
	    public void setBody(String body) {
	        this.body = body;
	    }


	    /**
	     * ���������� �� ������� ��� ���������.
	     * @return �� ������� ��� ���������.
	     */
	    public String getBody() {
	        return body;
	    }

	    
	    /**
	     * ����������� ������� ��� ����� ��� ���������.
	     * @param text �� ������� ��� ������������� ��� ����� ��� ���������.
	     */
	    public void appendToBody(String text) {
	        subject += text;
	    }
}
