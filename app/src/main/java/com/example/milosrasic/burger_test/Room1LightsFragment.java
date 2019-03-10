package com.example.milosrasic.burger_test;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.Uri;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Room1LightsFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {


    public Room1LightsFragment() {
        // Required empty public constructor
    }
    View v;
    WebView webView;
    public int lamp=0;
    Button room1_lamp_button;
    int a=0;
    CheckBox room1_ligths_lumination_checkbox;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
         v = inflater.inflate(R.layout.fragment_room1_lights, container, false);

        room1_lamp_button = (Button) v.findViewById(R.id.room1_lamp_button);
        room1_lamp_button.setOnClickListener(this);

        room1_ligths_lumination_checkbox = (CheckBox) v.findViewById(R.id.room1_ligths_lumination_checkbox);
        room1_ligths_lumination_checkbox.setOnCheckedChangeListener(this);

        webView = (WebView) v.findViewById(R.id.web_view1);
        webView.setWebViewClient(new WebViewClient());

        return v;
    }

    @Override
    public void onClick(View view) {
        if(lamp==0) {
            lamp=1;
            Toast.makeText(getActivity(), "Lamp Turned On!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            lamp=0;
            Toast.makeText(getActivity(), "Lamp Turned Off!", Toast.LENGTH_SHORT).show();
        }
        webView.loadUrl("http://192.168.1.6/H");
        room1_ligths_lumination_checkbox.setChecked(false);
        a=0;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if (room1_ligths_lumination_checkbox.isChecked()){
            if (a==0){
                webView.loadUrl("http://192.168.1.6/A");
                a=1;
            }
            else{
                a=0;
            }

        }

    }
}
