package domain;

public class BatteryInfo {

    // region - Constructors

    public BatteryInfo() {
        bLevel = "";
        bStatus = "";
        bTemperature="";
        bTechnology = "";
        bVoltage = "";
    }

    // region - Properties

    private String bLevel;
    private String bStatus;
    private String bTemperature;
    private String bTechnology;
    private String bVoltage;

    // region - Public Methods

    public String getbLevel() {
        return bLevel;
    }

    public String getbStatus() {
        return bStatus;
    }

    public String getbTemperature() {
        return bTemperature;
    }

    public String getbTechnology() {
        return bTechnology;
    }

    public String getbVoltage() {
        return bVoltage;
    }

    public void setbLevel(String bLevel) {
        this.bLevel = bLevel;
    }

    public void setbStatus(String bStatus) {
        this.bStatus = bStatus;
    }

    public void setbTemperature(String bTemperature) {
        this.bTemperature = bTemperature;
    }

    public void setbTechnology(String bTechnology) {
        this.bTechnology = bTechnology;
    }

    public void setbVoltage(String bVoltage) {
        this.bVoltage = bVoltage;
    }
}
