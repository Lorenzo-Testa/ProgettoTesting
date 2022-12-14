/** Generated by YAKINDU Statechart Tools code generator. */


import org.junit.*;
import static org.junit.Assert.*;

/**
 * Unit TestCase for Statechart
 */
@SuppressWarnings("all")
public class StatechartTest {
	
	private Statechart statemachine;	
	
	
	@Before
	public void statechartTest_setUp() {
		statemachine = new Statechart();
		
		
	}

	@After
	public void statechartTest_tearDown() {
		statemachine = null;
		
	}
	
	@Test
	public void test() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(Statechart.State.MAIN_REGION_RR));
		statemachine.raiseDx_Verde();
		assertTrue(statemachine.isStateActive(Statechart.State.MAIN_REGION_RV));
		statemachine.raiseDx_Giallo();
		assertTrue(statemachine.isStateActive(Statechart.State.MAIN_REGION_RG));
		statemachine.raiseDx_Rosso();
		assertTrue(statemachine.isStateActive(Statechart.State.MAIN_REGION_RR));
		statemachine.raiseSx_Verde();
		assertTrue(statemachine.isStateActive(Statechart.State.MAIN_REGION_VR));
		statemachine.raiseSx_Giallo();
		assertTrue(statemachine.isStateActive(Statechart.State.MAIN_REGION_GR));
		statemachine.raiseSx_Rosso();
		assertTrue(statemachine.isStateActive(Statechart.State.MAIN_REGION_RR));
		statemachine.exit();
	}
}
