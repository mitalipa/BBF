package receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

import common.Constants;

public class BatteryInfoReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isCharging = isBatteryCharging(intent);

        int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, Constants.defaultIntent);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, filter);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

    }

    // region - Helper Methods

    private boolean isBatteryCharging(Intent intent) {
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, Constants.defaultIntent);
        return status == BatteryManager.BATTERY_STATUS_CHARGING;
    }
}
