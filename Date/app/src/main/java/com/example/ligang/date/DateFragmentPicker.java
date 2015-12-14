package com.example.ligang.date;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by ligang on 2015/11/21.
 */
public class DateFragmentPicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private MainActivity mainActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity=(MainActivity)getActivity();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int monnth=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_YEAR);
        Dialog dialog=new DatePickerDialog(getActivity(),this,year,monnth,day);
        return dialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mainActivity.setDate(year,monthOfYear,dayOfMonth);
    }
}
