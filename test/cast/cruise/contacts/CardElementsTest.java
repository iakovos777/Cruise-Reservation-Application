package cast.cruise.contacts;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import cast.cruise.util.BasicEqualTester;



public class CardElementsTest {

	@Test
    public void testEqualsObject() {
        CardElements card1 = new  CardElements();
        CardElements card2 = new  CardElements();
        
        assertFalse(card1.equals(null));
        assertEquals(card1, card2);
        assertEquals(card1.hashCode(), card2.hashCode());
        
        card1.setName("Ioannis Metaksas");
        assertFalse(card1.equals(card2));
        assertFalse(card1.hashCode() == card2.hashCode());
        card2.setName("Ioannis Metaksas");
        assertEquals(card1, card2);
        assertEquals(card1.hashCode(), card2.hashCode());
    }
    
    @Test
    public void testEqualsAndHashCode() {
        BasicEqualTester<CardElements> equalsTester = new BasicEqualTester<CardElements>();
        CardElements card = new  CardElements();
        equalsTester.setObjectUnderTest(card);
        
        equalsTester.otherObjectIsNull();
        
        equalsTester.otherObjectIsOfDifferentType(new Object());
        
        CardElements card2 = new  CardElements();
        equalsTester.bothObjectsHaveNoState(card2);
        
        card.setCV("789");
        equalsTester.otherObjectsHasNoState(card2);
        
        equalsTester.sameReferences(card);
        
        card2.setCV("789");
        equalsTester.bothObjectsHaveSameState(card2);
        
        card.setExpireDate("7/2019");
        equalsTester.objectsHaveDifferentState(card2);
        
        card2.setExpireDate("7/2020");
        equalsTester.objectsHaveDifferentState(card2);
        
        card2.setExpireDate("7/2019");
        equalsTester.bothObjectsHaveSameState(card2);
        
        card.setName("Stef Curry");
        equalsTester.objectsHaveDifferentState(card2);
        
        card2.setName("Lebron James");
        equalsTester.objectsHaveDifferentState(card2);
        
        card2.setName("Stef Curry");
        equalsTester.bothObjectsHaveSameState(card2);
        
        card.setNumberCard("1234567890");
        equalsTester.objectsHaveDifferentState(card2);
        
        card2.setNumberCard("2132343468");
        equalsTester.objectsHaveDifferentState(card2);
        
        card2.setNumberCard("1234567890");
        equalsTester.bothObjectsHaveSameState(card2);
        
        
        
        
    }
    
    
	
 
   
	@Test
    public void constructors(){
    	String str = "1234567890,07/2019,Ioannis Papadopoulos,097";
    	CardElements card1 = new CardElements(str);
    	CardElements card2 = new CardElements("1234567890","07/2019","Ioannis Papadopoulos","097");
    	Assert.assertNotNull(card1);
    	Assert.assertNotNull(card2);
    	Assert.assertNotSame(card1,card2);
    }

}
