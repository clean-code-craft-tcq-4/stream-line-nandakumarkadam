#define CATCH_CONFIG_MAIN 


#include "test/catch.hpp"
#include <time.h>
#include <stdlib.h>
#include "senderCode.h"


sensorThresholdValues tempthresoldValues = {.maximumValue = 50.0, .minimumValue=10.0};
sensorThresholdValues socthresoldValues = {.maximumValue = 85.0, .minimumValue=15.0};

void testPrint(float tempData, float socData)
{
    printf("{  tempData = %.2f , socData = %.2f  }\n", tempData, socData);
}

TEST_CASE("TestCase1 : Valid data is being sent on sensor") {

    float tempSensorData[] = {12.0, 20.0, 40.0, 30.0};
    float socSensorData[] = {60.0, 25.0, 45.0, 34.0};
    sensorDataExtract sensorDataInput = {.lengthOfArray = 4, .tempSensorValues = tempSensorData, .socSensorValues = socSensorData};  
    REQUIRE(streamMainFunction(sensorDataInput, tempthresoldValues, socthresoldValues, testPrint)==1);
}

TEST_CASE("TestCase2 : Valid data is being sent on sensor cutoffs values") {

    float tempSensorData[] = {10.5, 29.0, 49.5, 35.0};
    float socSensorData[] = {84.5, 24.0, 64.0, 15.5};
    sensorDataExtract sensorDataInput = {.lengthOfArray = 4, .tempSensorValues = tempSensorData, .socSensorValues = socSensorData};  
    REQUIRE(streamMainFunction(sensorDataInput, tempthresoldValues, socthresoldValues, testPrint)==1);
}

TEST_CASE("TestCase3 : InValid Data is sent on Sensor and check whether the value is corrected before streaming") {

    float tempSensorDataInvalid[] = {60.0, 20.0, 40.0, 5.0};
    float socSensorDataInvalid[] = {90.0, 25.0, 45.0, 14.0};
    sensorDataExtract sensorDataInputInvalid = {.lengthOfArray = 4, .tempSensorValues = tempSensorDataInvalid, .socSensorValues = socSensorDataInvalid};  
    REQUIRE(streamMainFunction(sensorDataInputInvalid, tempthresoldValues, socthresoldValues, testPrint)==1);
}

TEST_CASE("TestCase4: InValid Data is sent on Sensor and check whether the value is corrected before streaming cutoff values") {

    float tempSensorDataInvalid[] = {9.5, 50.5, 49.5, 10.5};
    float socSensorDataInvalid[] = {14.5, 85.5, 84.5, 15.5};
    sensorDataExtract sensorDataInputInvalid = {.lengthOfArray = 4, .tempSensorValues = tempSensorDataInvalid, .socSensorValues = socSensorDataInvalid};  
    REQUIRE(streamMainFunction(sensorDataInputInvalid, tempthresoldValues, socthresoldValues, testPrint)==1);
}