package Reciever;

import java.util.ArrayList;
import java.util.List;

public class ReceiverServiceImpl {
	public static void main(String args[]) {

		List<Float> socValues = new ArrayList<Float>();
		List<Float> temperatureValues = new ArrayList<Float>();

		BatteryParameters battery = new BatteryParameters();
		CheckBatteryParamaters propertyEvaluator = new CheckBatteryParamaters();

		if (args.length > 0) {
			for (String dataInput : args) {
				String batteryProperties[] = dataInput.split(",");
				if (batteryProperties.length == 3) {
					temperatureValues.add(Float.valueOf(batteryProperties[1]));
					socValues.add(Float.valueOf(batteryProperties[2]));
				} else {
					System.out.println("Data streamed not a valid data- " + dataInput);
				}
			}

			checkBatteryTemperatureProperties(temperatureValues, battery, propertyEvaluator);
			checkBatterySocProperties(socValues, battery, propertyEvaluator);
			PrintProperty print = new PrintFuntion();
			print.printReport(battery);

		}

	}

	public static void checkBatterySocProperties(List<Float> socList, BatteryParameters battery,
			CheckBatteryParamaters propertyEvaluator) {
		battery.setMaxSoc(propertyEvaluator.getMaxSocValue(socList));
		battery.setMinSoc(propertyEvaluator.getMinSocValue(socList));
		battery.setAverageSoc(propertyEvaluator.getAverageInSocListValues(socList));
	}

	public static void checkBatteryTemperatureProperties(List<Float> chargeRateList, BatteryParameters battery,
			CheckBatteryParamaters propertyEvaluator) {
		battery.setAverageChargeRate(propertyEvaluator.getAverageInTemperatureList(chargeRateList));
		battery.setMinChargeRate(propertyEvaluator.getMinTemperatureValue(chargeRateList));
		battery.setMaxChargeRate(propertyEvaluator.getMaxTemperatureValue(chargeRateList));
	}

}