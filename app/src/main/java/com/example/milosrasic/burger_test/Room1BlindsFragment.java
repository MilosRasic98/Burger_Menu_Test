package com.example.milosrasic.burger_test;


import android.app.TimePickerDialog;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.CheckBox;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Room1BlindsFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{


    public Room1BlindsFragment() {
        // Required empty public constructor
    }

    int hour, minute;
    int houl_final,minute_final;
    int a=0,d=0,c=0;
    View v;
    WebView webView;
    ImageButton room1_blinds_up_button;
    Button room1_blinds_stop_button;
    ImageButton room1_blinds_down_button;
    Button room1_blinds_completely_down;
    Button room1_blinds_completely_up;
    CheckBox room1_blinds_alarm_checkbox;
    Button room1_blinds_time_picker_button;
    TextView textView7;
    TextView room1_blinds_alarm_text_view;
    CheckBox room1_blinds_up_checkbox;
    CheckBox room1_blinds_down_checkbox;
    Button room1_blinds_cancel_button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_room1_blinds, container, false);

        getFragmentManager();

        room1_blinds_up_button = (ImageButton) v.findViewById(R.id.room1_blinds_up_button);
        room1_blinds_up_button.setOnClickListener(this);

        room1_blinds_stop_button = (Button) v.findViewById(R.id.room1_blinds_stop_button);
        room1_blinds_stop_button.setOnClickListener(this);

        room1_blinds_down_button = (ImageButton) v.findViewById(R.id.room1_blinds_down_button);
        room1_blinds_down_button.setOnClickListener(this);

        room1_blinds_completely_down = (Button) v.findViewById(R.id.room1_blinds_completely_down);
        room1_blinds_completely_down.setOnClickListener(this);

        room1_blinds_completely_up = (Button) v.findViewById(R.id.room1_blinds_completely_up);
        room1_blinds_completely_up.setOnClickListener(this);

        room1_blinds_alarm_checkbox = (CheckBox) v.findViewById(R.id.room1_blinds_alarm_checkbox);
        room1_blinds_alarm_checkbox.setOnCheckedChangeListener(this);

        room1_blinds_time_picker_button = (Button) v.findViewById(R.id.room1_blinds_time_picker_button);
        room1_blinds_time_picker_button.setOnClickListener(this);

        textView7 = (TextView) v.findViewById(R.id.textView7);

        room1_blinds_alarm_text_view = (TextView) v.findViewById(R.id.room1_blinds_alarm_text_view);

        room1_blinds_up_checkbox = (CheckBox) v.findViewById(R.id.room1_blinds_up_checkbox);
        room1_blinds_up_checkbox.setOnCheckedChangeListener(this);

        room1_blinds_down_checkbox = (CheckBox) v.findViewById(R.id.room1_blinds_down_checkbox);
        room1_blinds_down_checkbox.setOnCheckedChangeListener(this);

        room1_blinds_cancel_button = (Button) v.findViewById(R.id.room1_blinds_cancel_button);
        room1_blinds_cancel_button.setOnClickListener(this);

        room1_blinds_alarm_text_view = (TextView) v.findViewById(R.id.room1_blinds_alarm_text_view);

        webView = (WebView) v.findViewById(R.id.web_view_blinds);
        webView.setWebViewClient(new WebViewClient());



        return v;
    }







    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.room1_blinds_up_button:
                webView.loadUrl("http://192.168.1.6/U");
                Toast.makeText(getActivity(), "Blinds Going Up!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.room1_blinds_down_button:
                webView.loadUrl("http://192.168.1.6/D");
                Toast.makeText(getActivity(), "Blinds Going Down!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.room1_blinds_stop_button:
                webView.loadUrl("http://192.168.1.6/S");
                Toast.makeText(getActivity(), "Blinds Stopped!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.room1_blinds_completely_down:
                webView.loadUrl("http://192.168.1.6/D");
                Toast.makeText(getActivity(), "Blinds going completely down!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.room1_blinds_completely_up:
                webView.loadUrl("http://192.168.1.6/U");
                Toast.makeText(getActivity(), "Blinds going completely up!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.room1_blinds_time_picker_button:
                Toast.makeText(getActivity(), "Pick the time at which the blinds should activate!", Toast.LENGTH_SHORT).show();
                Calendar c = Calendar.getInstance();
                hour=c.get(Calendar.HOUR_OF_DAY);
                minute=c.get(Calendar.MINUTE);


        }

    }



    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(room1_blinds_alarm_checkbox.isChecked()){
            if (a==0) {
                Toast.makeText(getActivity(), "Alarm mode enabled!", Toast.LENGTH_SHORT).show();
                a=1;
            }
            room1_blinds_time_picker_button.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            textView7.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            room1_blinds_alarm_text_view.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            room1_blinds_up_checkbox.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            room1_blinds_down_checkbox.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            room1_blinds_cancel_button.setEnabled(room1_blinds_alarm_checkbox.isChecked());
        } else {
            Toast.makeText(getActivity(), "Alarm mode disabled!", Toast.LENGTH_SHORT).show();
            room1_blinds_time_picker_button.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            textView7.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            room1_blinds_alarm_text_view.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            room1_blinds_up_checkbox.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            room1_blinds_down_checkbox.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            room1_blinds_cancel_button.setEnabled(room1_blinds_alarm_checkbox.isChecked());
            a=0;
            room1_blinds_up_checkbox.setChecked(false);
            room1_blinds_down_checkbox.setChecked(false);
        }

        if (room1_blinds_down_checkbox.isChecked()){
            if(c==0) {
                c=1;
                room1_blinds_up_checkbox.setChecked(false);
                d=0;
            }
        }

        if (room1_blinds_up_checkbox.isChecked()){
            if(d==0) {
                d=1;
                room1_blinds_down_checkbox.setChecked(false);
                c=0;
            }
        }

    }

}
