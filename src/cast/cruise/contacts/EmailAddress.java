package cast.cruise.contacts;



/**
 * � ��������� ������������ ������������.
 * ����������� �� ����������� ���� (value object)
 * 
 *
 */
public class EmailAddress {
    private String value;

    /**
     * ���������� ����� ��� ������������� ��� ����������.
     * @param email �� e-mail.
     */
    public EmailAddress(String email) {
        this.value = email;
    }

    /**
     * ���������� �� ��������� �� ������������.
     * @return � ��������� ������������ ������������.
     */
    public String getAddress() {
        return value;
    }

    /**
     * ���������� ��� �������� ��� ���������� ������������ ������������.
     * @return {@code true} ��� ����� ���� � ���������
     * ��� ������������ ������������
     */
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof EmailAddress)) {
            return false;
        }

        EmailAddress theEmail = (EmailAddress) other;
        return value == null ? theEmail.getAddress() == null
                : value.equals(theEmail.getAddress());
    }

    @Override
    public int hashCode() {
        return value == null ? 0 : value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
