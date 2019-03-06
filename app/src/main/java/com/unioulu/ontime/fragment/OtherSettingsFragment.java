package com.unioulu.ontime.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TimePicker;

import com.unioulu.ontime.R;

import java.text.BreakIterator;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OtherSettingsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OtherSettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtherSettingsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Fragment's buttons !
    private Button morningBtn, afternoonBtn, eveningBtn, customBtn, save, cancel;
    // Fragment's radioButtons
    private RadioButton[] snoozeRbtn; // 5 buttons in total

    private OnFragmentInteractionListener mListener;

    public OtherSettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OtherSettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OtherSettingsFragment newInstance(String param1, String param2) {
        OtherSettingsFragment fragment = new OtherSettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_other_settings, container, false);

        // Initialization of buttons
        morningBtn   = rootView.findViewById(R.id.morningBtn);
        afternoonBtn = rootView.findViewById(R.id.afternoonBtn);
        eveningBtn   = rootView.findViewById(R.id.eveningBtn);
        customBtn    = rootView.findViewById(R.id.customBtn);
        save         = rootView.findViewById(R.id.saveBtn);
        cancel       = rootView.findViewById(R.id.cancelBtn);

        // Initialization of radio buttons
        snoozeRbtn = new RadioButton[]{
                rootView.findViewById(R.id.s5Rbtn),
                rootView.findViewById(R.id.s10Rbtn),
                rootView.findViewById(R.id.s15Rbtn),
                rootView.findViewById(R.id.s20Rbtn),
                rootView.findViewById(R.id.s25Rbtn),
        };

        morningBtn.setOnClickListener(timeBtnOnClickListener);
        afternoonBtn.setOnClickListener(timeBtnOnClickListener);
        eveningBtn.setOnClickListener(timeBtnOnClickListener);
        customBtn.setOnClickListener(timeBtnOnClickListener);
        save.setOnClickListener(timeBtnOnClickListener);
        cancel.setOnClickListener(timeBtnOnClickListener);

        return rootView;
    }

    private View.OnClickListener timeBtnOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Time picker parameters (Current time)
            Calendar mcurrentTime = Calendar.getInstance();
            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            int minute = mcurrentTime.get(Calendar.MINUTE);
            TimePickerDialog mTimePicker; // Time picker dialog


            if (R.id.morningBtn == v.getId() ) {
                Log.d("OtherSettings", "morning");

                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Log.d("OtherSettings", selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle(R.string.SelectMorningTime);
                mTimePicker.show();

            }
            else if (R.id.afternoonBtn == v.getId()) {

                Log.d("OtherSettings", "Afternoon");
                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Log.d("OtherSettings", selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle(R.string.SelectAfternoonTime);
                mTimePicker.show();


            }else if (R.id.eveningBtn == v.getId()){
                Log.d("OtherSettings", "Evening");

                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Log.d("OtherSettings", selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle(R.string.SelectEveningTime);
                mTimePicker.show();

            }else if (R.id.customBtn == v.getId()){
                Log.d("OtherSettings", "Custom");

                mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        Log.d("OtherSettings", selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle(R.string.SelectCustomTime);
                mTimePicker.show();

            }else if (R.id.saveBtn == v.getId()){
                Log.d("OtherSettings", "Save");
            }else if (R.id.cancelBtn == v.getId()){
                Log.d("OtherSettings", "Cancel");
            }

        }
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // Define functions later...
    }
}