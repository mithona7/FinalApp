package com.example.jupitercls.appleangchhean;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
ListView lst;
    String[] itemname ={
            "POLICE",
            "TRAFFIC POLICE",
            "FIRE STATION",
            "AMBULANCE",
            "BLOOD TRANSFUSION CENTER",
            "WATER SUPPLY",
            "PUBLIC Electricity[EDC]",
            "AMBULANCE(S.A.M.U)"
    };
    String[] phoneNumber ={"012 999999","012896628","023 723 555 1","023 723 840"," 023 215 949","023 724 046","023 723 871","012 912 947"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = (ListView) findViewById(R.id.list);
        lst.setAdapter(new ArrayAdapter<String>(
                this, R.layout.list_item,
                R.id.firstLine, itemname));



        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) lst.getItemAtPosition(position);


                Intent intentCall = new Intent(Intent.ACTION_CALL);

                intentCall.setData(Uri.parse("tel:" + phoneNumber[itemPosition]));
                intentCall.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentCall);

            }
        });
    }
}
