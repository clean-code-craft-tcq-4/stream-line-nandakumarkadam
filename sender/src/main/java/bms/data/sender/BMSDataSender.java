package bms.data.sender;

import java.util.List;

import sender.battary.params.impl.SensorDataService;

public class BMSDataSender {

	public static void main(String[] args) {
		SensorDataService batteryParamsSimulator = new SensorDataService();

		List<Double> temperatureValues = batteryParamsSimulator.generateTemparatureSequence();
		batteryParamsSimulator.printSequenceInConsole("Temperature Sequence", temperatureValues);

		List<Double> chargeRateValues = batteryParamsSimulator.generateChargeRateSequence();
		batteryParamsSimulator.printSequenceInConsole("Charge Rate Sequence", chargeRateValues);
	}
}
