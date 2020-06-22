package cast.cruise.contacts;

/**
 * � ����������� ���������.
 *
 *
 */
public class Address {
    private String street;
    private String number;
    private String city;
	private String country;
    private String zip;
    /**
     * ��������������� �������������.
     */
	
    public Address() { }
    /**
     * ���������� ������������� ��� ���������� ��� ���������.
     * ������� ����� ����������
     * @param address � ���� ���������
     */
   
    public Address(Address address) {
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.city = address.getCity();
		this.country = address.getCountry();
        this.zip = address.getZipCode();
        
    }
    public Address(String street, String number, String city, String zip, String country) {
        this.street = street;
        this.number = number;
        this.city = city;
		this.country = country;
        this.zip = zip;
        
    }
    
    public Address(String address){
    	String[] a = address.split(",");
    	this.street = a[0];
        this.number = a[1];
        this.city = a[2];
		this.country = a[4];
        this.zip = a[3]; 
    			
    }

    /**
     * ����� ��� ���.
     * @param street � ����
     */
    public void setStreet(String street) {
        this.street = street;
    }

    
    /**
     * ���������� ��� ���.
     * @return � ����
     */
    public String getStreet() {
        return street;
    }

    /**
     * ����� ��� ������.
     * @param number � �������
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * ���������� ��� ������.
     * @return � �������
     */
    public String getNumber() {
        return number;
    }

    /**
     * ����� ��� ����.
     * @param city � ����
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * ���������� ��� ����.
     * @return � ����
     */
    public String getCity() {
        return city;
    }

    /**
     * ����� ��� ����������� ������.
     * @param zipcode � ������������ �������
     */
    public void setZipCode(String zipcode) {
        this.zip = zipcode;
    }

    /**
     * ���������� ��� ����������� ������.
     * @return � ������������ �������
     */
    public String getZipCode() {
        return zip;
    }

    /**
     * ����� �� ����.
     * @param country � ����
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * ���������� �� ����.
     * @return � ����
     */
    public String getCountry() {
        return country;
    }

    /**
     * � ������� ��������� �� ��� �� ����� ��� ����������.
     * @param other �� ���� ����������� ���� ������
     * @return  {@code true} �� �� ����������� ����� ���
     */

    
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }

        Address theAddress = (Address) other;
        if (!(street == null ? theAddress.street 
                == null : street.equals(theAddress.street))) {
            return false;
        }
        if (!(number == null ? theAddress.number 
                == null : number.equals(theAddress.number))) {
            return false;
        }
        if (!(city == null ? theAddress.city 
                == null : city.equals(theAddress.city))) {
            return false;
        }
        if (!(zip == null ? theAddress.zip
                == null : zip.equals(theAddress.zip))) {
            return false;
        }
        if (!(country == null ? theAddress.country
                == null : country.equals(theAddress.country))) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        if (street == null && number == null && city == null
                && zip == null && country == null) {
            return 0;
        }

        int result = 0;
        result = street == null ? result : 13 * result + street.hashCode(); 
        result = number == null ? result : 13 * result + number.hashCode();
        result = city == null ? result : 13 * result + city.hashCode();
        result = zip == null ? result : 13 * result + zip.hashCode();
        result = country == null ? result : 13 * result + country.hashCode();
        return result;
    }
    
    @Override
    public String toString() {
        return getStreet()+","+getNumber()+","+getCity()+","+getZipCode()+","+getCountry();
    }

}
