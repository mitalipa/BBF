package view;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.mitali.bbf.R;

import common.Constants;
import domain.BatteryInfo;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    private BatteryInfo batteryInfo;

    TextView bStatus, bLevel, bTemperature, bVoltage, bTechnology;

    public AboutFragment() {
        batteryInfo = new BatteryInfo();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        bStatus = (TextView) view.findViewById(R.id.bStatus);
        bLevel= (TextView) view.findViewById(R.id.bLevel);
        bTemperature = (TextView) view.findViewById(R.id.bTemperature);
        bVoltage = (TextView)view.findViewById(R.id.bVoltage);
        bTechnology = (TextView)view.findViewById(R.id.bTechnology);
        getActivity().registerReceiver(this.batteryInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        return view;
    }

    private BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isCharging = isBatteryCharging(intent);

            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, Constants.defaultIntent);
            boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int temperature = intent.getIntExtra("temperature",0);
            int voltage = intent.getIntExtra("voltage", 0);
            batteryInfo.setbLevel(Integer.toString(level));
            if(isCharging)
            {
                batteryInfo.setbStatus("Charging");
                bStatus.setText("Charging");
            }
            else {
                batteryInfo.setbStatus("Not Charging");
                bStatus.setText("Not Charging");
            }

            batteryInfo.setbTemperature(Integer.toString(temperature));
            bTemperature.setText(Integer.toString(temperature));

            batteryInfo.setbVoltage(Integer.toString(voltage));
            bVoltage.setText(Integer.toString(voltage));
        }
    };

    private boolean isBatteryCharging(Intent intent) {
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, Constants.defaultIntent);
        return status == BatteryManager.BATTERY_STATUS_CHARGING;
    }
}
