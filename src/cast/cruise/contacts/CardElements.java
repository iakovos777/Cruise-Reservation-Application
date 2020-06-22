package cast.cruise.contacts;

/**
 * �� �������� ��� ���������� ������ ��� ������.
 * 
 * 
 *
 */
public class CardElements{
	private String numberCard;
    private String expireDate;
    private String name;
	private String CV;
    
    
	
    public CardElements() { }
    /**
     * ���������� ����� ��� ������� ������, ��� ����������� ����� ��� ������,�� ����� ��� �������,��� ��� ������ CV .
     * @param numberCard, expireDate, name, CV.
     */
   
    public CardElements( String numberCard, String expireDate, String name, String CV) {
       
     	this.numberCard = numberCard;
        this.expireDate = expireDate;
		this.name = name;
        this.CV = CV;
        
    }
    /**
     * ���������� ����� ��� ������������� ��� ����������.
     * @param card To credit card.
     */
    
    public CardElements(String card){
    	String[] c = card.split(",");
    	this.numberCard = c[0];
        this.expireDate = c[1];
        this.name = c[2];
		this.CV = c[3];
        
    }
    /**
     * ����� ��� ���������� ����� ��� ������ �.
     * @param expireDate.
     */
    
    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
    /**
     * ���������� ��� ���������� ����� ��� ������.
     * @return expireDate.
     */
   
    public String getExpireDate() {
        return expireDate;
    }
    /**
     * ����� ��� ������  ��� ������ �.
     * @param numberCard.
     */
    
    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }
    /**
     * ���������� ��� ������ ������.
     * @return numberCard.
     */
    
    public String getNumberCard() {
        return numberCard;
    }
    /**
     * ����� �� ����� ��� �������  ��� ������.
     * @param name.
     */
    

   
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ���������� �� ����� ��� ������� ��� ������.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * ����� ��� ������ CV  ��� ������ .
     * @param CV.
     */
    public void setCV(String CV) {
        this.CV = CV;
    }

    /**
     * ���������� ��� ������ CV ��� ������.
     * @return CV.
     */
    public String getCV() {
        return CV;
    }

   
    
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardElements)) {
            return false;
        }

        CardElements theCard = (CardElements) other;
        if (!(numberCard == null ? theCard.numberCard 
                == null : numberCard.equals(theCard.numberCard))) {
            return false;
        }
        if (!(expireDate == null ? theCard.expireDate 
                == null : expireDate.equals(theCard.expireDate))) {
            return false;
        }
        if (!(name == null ? theCard.name
                == null : name.equals(theCard.name))) {
            return false;
        }
        if (!(CV == null ? theCard.CV
                == null : CV.equals(theCard.CV))) {
            return false;
        }
       
        return true;
    }


    @Override
    public int hashCode() {
        if (numberCard == null && expireDate == null && name == null
                && CV == null ) {
            return 0;
        }

        int result = 0;
        result = numberCard == null ? result : 15 * result + numberCard.hashCode(); 
        result = expireDate == null ? result : 15 * result + expireDate.hashCode();
        result = name == null ? result : 15 * result + name.hashCode();
        result = CV == null ? result : 15 * result + CV.hashCode();
        
        return result;
    }
    
    @Override
    public String toString(){
    	return getNumberCard()+","+getExpireDate()+","+getName()+","+getCV();
    }

}
