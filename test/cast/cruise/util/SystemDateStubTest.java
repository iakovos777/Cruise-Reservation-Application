package cast.cruise.util;

import java.util.Calendar;

import org.junit.*;

public class SystemDateStubTest {
    int YEAR_STUB = 1971;
    int MONTH_STUB = 11;
    int DATE_STUB = 30;
    
    SimpleCalendar stub;
    
    @Before
    public void setUp() {
        SystemDateStub.reset();
        stub = new SimpleCalendar(YEAR_STUB, MONTH_STUB, DATE_STUB);
    }
    
    @After
    public void reset() {
        SystemDateStub.reset();
    }
    
    @Test
    public void testWithoutStub() {                            
        SimpleCalendar realNow = new SimpleCalendar(Calendar.getInstance());
        Assert.assertEquals(SystemDate.now(), realNow);        
    }
    
    
    @Test
    public void testWithStub() {
        SystemDateStub.setStub(stub);                        
        Assert.assertEquals(stub, SystemDate.now());
        
    }
    
    
    @Test
    public void switchStubUsage() {
        Assert.assertEquals(new SimpleCalendar(Calendar.getInstance()), SystemDate.now());        
        SystemDateStub.setStub(stub);
        Assert.assertEquals(stub, SystemDate.now());        
        SystemDateStub.reset();
        Assert.assertEquals(new SimpleCalendar(Calendar.getInstance()), SystemDate.now());        
    }
    
    @Test
    public void afterBefore(){
    	SimpleCalendar sc1 = new SimpleCalendar(2017,5,17);
    	SimpleCalendar sc2 = new SimpleCalendar(2017,6,17);
    	
    	Assert.assertFalse(sc1.after(sc2));
    	Assert.assertTrue(sc2.after(sc1));
    	Assert.assertTrue(sc1.before(sc2));
    }
}
