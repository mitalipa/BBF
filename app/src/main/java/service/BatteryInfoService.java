package service;

import domain.BatteryInfo;

public class BatteryInfoService {

    // region - Constructor

    public BatteryInfoService() {
        batteryInfo = new BatteryInfo();
    }

    // region - Properties

    private BatteryInfo batteryInfo;

    // region - Public Methods

    public BatteryInfo getBatteryInfo() {
        return batteryInfo;
    }

    // region - Helper Methods

    private int getBatteryLevel()
    {
       return 0;
    }
}
