package com.example.ligang.timepickert;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by ligang on 2015/11/20.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    int hour;
    int minute;
    private MainActivity mainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity mainActivity=(MainActivity)getActivity();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog dialog=new TimePickerDialog(getActivity(),this,hour,minute,true);
        return dialog;
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        this.hour=hourOfDay;
        this.minute=minute;
        mainActivity.TimeValue(hour,minute);

    }
}
