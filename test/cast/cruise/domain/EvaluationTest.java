package cast.cruise.domain;



import org.junit.Assert;
import org.junit.Test;



public class EvaluationTest {

	@Test
	public void testEvalId() {
		Evaluation e = new Evaluation();
		Evaluation t = new Evaluation();
		Evaluation d = new Evaluation();
		Assert.assertEquals(20, e.getEvalId());
		Assert.assertEquals(21, t.getEvalId());
		Assert.assertEquals(22, d.getEvalId());
	}
	
	@Test
	public void testConstructor(){
		Evaluation e = new Evaluation(0,"Amazing");
		Evaluation t = new Evaluation(10,"Great");
		Assert.assertTrue(t.getHasEvaluated());
		Assert.assertFalse(e.getHasEvaluated());
	}
}
