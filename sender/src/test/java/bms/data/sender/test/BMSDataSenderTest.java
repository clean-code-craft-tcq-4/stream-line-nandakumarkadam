package bms.data.sender.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import sender.battary.params.impl.SensorDataService;

public class BMSDataSenderTest {
	
	@Test
	  public void testTemperatureSequence() {
		SensorDataService batteryParamsSimulator = new SensorDataService();
	    List<Double> temperatureValues = batteryParamsSimulator.generateTemparatureSequence();
	    assertNotNull("Output should not be null", temperatureValues);
	    assertEquals((Double) 20.0, temperatureValues.get(0));
	    assertEquals((Double) 21.0, temperatureValues.get(1));
	    assertEquals((Double) 80.0, temperatureValues.get(temperatureValues.size() - 1));
	    assertEquals((Double) 79.0, temperatureValues.get(temperatureValues.size() - 2));
	  }

	  @Test
	  public void testChargeRateSequence() {
		  SensorDataService batteryParamsSimulator = new SensorDataService();
	    List<Double> chargeRateValues = batteryParamsSimulator.generateChargeRateSequence();
	    assertNotNull("Output should not be null", chargeRateValues);
	    assertEquals((Double) 1.0, chargeRateValues.get(0));
	    assertEquals((Double) 1.2, chargeRateValues.get(1));
	    assertEquals((Double) 9.0, chargeRateValues.get(chargeRateValues.size() - 1));
	    assertEquals((Double) 8.8, chargeRateValues.get(chargeRateValues.size() - 2));
	  }
}
