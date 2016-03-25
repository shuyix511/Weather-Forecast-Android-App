package com.example.thinkpad.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Thinkpad on 2015/12/10.
 */
public class DetailsActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        final RelativeLayout Table1 = (RelativeLayout)findViewById(R.id.T1_1);
        final RelativeLayout Table2 = (RelativeLayout)findViewById(R.id.Day_List);
        final RelativeLayout Table3 = (RelativeLayout)findViewById(R.id.next_24_table);

        final Button Next_24_hours = (Button) findViewById(R.id.Next_24_hours);
        final Button Next_7_days = (Button) findViewById(R.id.Next_7_Days);
        final ImageButton Button_Control = (ImageButton)findViewById(R.id.button_control);
        Next_24_hours.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Table1.setVisibility(View.VISIBLE);
                Table2.setVisibility(View.GONE);
                Next_24_hours.setBackgroundResource(R.color.blue);
                Next_7_days.setBackgroundResource(R.color.white);
            }
        });

        Next_7_days.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Table1.setVisibility(View.GONE);
                Table2.setVisibility(View.VISIBLE);
                Next_24_hours.setBackgroundResource(R.color.white);
                Next_7_days.setBackgroundResource(R.color.blue);

            }
        });
        Button_Control.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Table3.setVisibility(View.VISIBLE);
                Button_Control.setVisibility(View.GONE);
            }
        });

        Bundle bundle = this.getIntent().getExtras();
        final String json = bundle.getString("json");
        final String city = bundle.getString("city");
        final String state = bundle.getString("state");
        final String degree = bundle.getString("degree");

        try {
            JSONObject myJsonObject = new JSONObject(json);
            String Unit_Display = "";
            switch (degree){
                case "Fahrenheit":
                    Unit_Display = "F";
                    break;
                case "Celsius":
                    Unit_Display = "C";
                    break;
                default:
                    break;
            }
            double min_temp_7_1= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("temperatureMin");
            double max_temp_7_1= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(1).getDouble("temperatureMax");
            int min_temp_7_1_display = (int)Math.floor(min_temp_7_1);
            int max_temp_7_1_display = (int)Math.floor(max_temp_7_1);
            TextView D1_3 = (TextView)findViewById(R.id.D1_3);
            D1_3.setText("Min:"+ min_temp_7_1_display + "°" + Unit_Display +" | " + "Max:"+ max_temp_7_1_display  + "°" + Unit_Display);
            double min_temp_7_2= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(2).getDouble("temperatureMin");
            double max_temp_7_2= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(2).getDouble("temperatureMax");
            int min_temp_7_2_display = (int)Math.floor(min_temp_7_2);
            int max_temp_7_2_display = (int)Math.floor(max_temp_7_2);
            TextView D2_3 = (TextView)findViewById(R.id.D2_3);
            D2_3.setText("Min:"+ min_temp_7_2_display + "°" + Unit_Display +" | " + "Max:"+ max_temp_7_2_display  + "°" + Unit_Display);
            double min_temp_7_3= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(3).getDouble("temperatureMin");
            double max_temp_7_3= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(3).getDouble("temperatureMax");
            int min_temp_7_3_display = (int)Math.floor(min_temp_7_3);
            int max_temp_7_3_display = (int)Math.floor(max_temp_7_3);
            TextView D3_3 = (TextView)findViewById(R.id.D3_3);
            D3_3.setText("Min:"+ min_temp_7_3_display + "°" + Unit_Display +" | " + "Max:"+ max_temp_7_3_display  + "°" + Unit_Display);
            double min_temp_7_4= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(4).getDouble("temperatureMin");
            double max_temp_7_4= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(4).getDouble("temperatureMax");
            int min_temp_7_4_display = (int)Math.floor(min_temp_7_4);
            int max_temp_7_4_display = (int)Math.floor(max_temp_7_4);
            TextView D4_3 = (TextView)findViewById(R.id.D4_3);
            D4_3.setText("Min:"+ min_temp_7_4_display + "°" + Unit_Display +" | " + "Max:"+ max_temp_7_4_display  + "°" + Unit_Display);
            double min_temp_7_5= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(5).getDouble("temperatureMin");
            double max_temp_7_5= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(5).getDouble("temperatureMax");
            int min_temp_7_5_display = (int)Math.floor(min_temp_7_5);
            int max_temp_7_5_display = (int)Math.floor(max_temp_7_5);
            TextView D5_3 = (TextView)findViewById(R.id.D5_3);
            D5_3.setText("Min:"+ min_temp_7_5_display + "°" + Unit_Display +" | " + "Max:"+ max_temp_7_5_display  + "°" + Unit_Display);
            double min_temp_7_6= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(6).getDouble("temperatureMin");
            double max_temp_7_6= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(6).getDouble("temperatureMax");
            int min_temp_7_6_display = (int)Math.floor(min_temp_7_6);
            int max_temp_7_6_display = (int)Math.floor(max_temp_7_6);
            TextView D6_3 = (TextView)findViewById(R.id.D6_3);
            D6_3.setText("Min:"+ min_temp_7_6_display + "°" + Unit_Display +" | " + "Max:"+ max_temp_7_6_display  + "°" + Unit_Display);
            double min_temp_7_7= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(7).getDouble("temperatureMin");
            double max_temp_7_7= myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(7).getDouble("temperatureMax");
            int min_temp_7_7_display = (int)Math.floor(min_temp_7_7);
            int max_temp_7_7_display = (int)Math.floor(max_temp_7_7);
            TextView D7_3 = (TextView)findViewById(R.id.D7_3);
            D7_3.setText("Min:" + min_temp_7_7_display + "°" + Unit_Display + " | " + "Max:" + max_temp_7_7_display + "°" + Unit_Display);

            String[] Icon = new String[7];
            String[] Icon_7_Display = new String[7];
            String[] Day_7 = new String[7];
            String[]  month_date_time = new String[7];
            Long timestamp_date;
            for(int i=0;i<7;i++){
                Day_7[i] = myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(i+1).optString("time");
                timestamp_date = Long.parseLong(Day_7[i])*1000;
                month_date_time[i] = new java.text.SimpleDateFormat("E, MMM dd").format(new java.util.Date(timestamp_date));
                Log.v("monthdate",month_date_time[i]);
                Icon[i] = myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(i+1).optString("icon");
                switch(Icon[i]){
                    case "fog":
                        Icon_7_Display[i] = Icon[i];
                        break;
                    case "rain":
                        Icon_7_Display[i]= Icon[i];
                        break;
                    case "sleet":
                        Icon_7_Display[i] = Icon[i];
                        break;
                    case "snow":
                        Icon_7_Display[i]= Icon[i];
                        break;
                    case "wind":
                        Icon_7_Display[i] = Icon[i];
                        break;
                    case "cloudy":
                        Icon_7_Display[i] = Icon[i];
                        break;
                    case "clear-day":
                        Icon_7_Display[i]= "clear";
                        break;
                    case "clear-night":
                        Icon_7_Display[i] = "clear_night";
                        break;
                    case "partly-cloudy-day":
                        Icon_7_Display[i]= "cloud_day";
                        break;
                    case "partly-cloudy-night":
                        Icon_7_Display[i] = "cloud_night";
                        break;
                    default:
                        break;
                }
            }
            ImageView D1_2 = (ImageView)findViewById(R.id.D1_2);
            Icon_7_Display[0] = "@drawable/"+Icon_7_Display[0];
            int imageResource_0 = getResources().getIdentifier(Icon_7_Display[0],null,getPackageName());
            Drawable image_0 = getResources().getDrawable(imageResource_0);
            D1_2.setImageDrawable(image_0);
            ImageView D2_2 = (ImageView)findViewById(R.id.D2_2);
            Icon_7_Display[1] = "@drawable/"+Icon_7_Display[1];
            int imageResource_1 = getResources().getIdentifier(Icon_7_Display[1],null,getPackageName());
            Drawable image_1 = getResources().getDrawable(imageResource_1);
            D2_2.setImageDrawable(image_1);
            ImageView D3_2 = (ImageView)findViewById(R.id.D3_2);
            Icon_7_Display[2] = "@drawable/"+Icon_7_Display[2];
            int imageResource_2 = getResources().getIdentifier(Icon_7_Display[2],null,getPackageName());
            Drawable image_2 = getResources().getDrawable(imageResource_2);
            D3_2.setImageDrawable(image_2);
            ImageView D4_2 = (ImageView)findViewById(R.id.D4_2);
            Icon_7_Display[3] = "@drawable/"+Icon_7_Display[3];
            int imageResource_3 = getResources().getIdentifier(Icon_7_Display[3],null,getPackageName());
            Drawable image_3 = getResources().getDrawable(imageResource_3);
            D4_2.setImageDrawable(image_3);

            ImageView D5_2 = (ImageView)findViewById(R.id.D5_2);
            Icon_7_Display[4] = "@drawable/"+Icon_7_Display[4];
            int imageResource_4 = getResources().getIdentifier(Icon_7_Display[4],null,getPackageName());
            Drawable image_4 = getResources().getDrawable(imageResource_4);
            D5_2.setImageDrawable(image_4);

            ImageView D6_2 = (ImageView)findViewById(R.id.D6_2);
            Icon_7_Display[5] = "@drawable/"+Icon_7_Display[5];
            int imageResource_5 = getResources().getIdentifier(Icon_7_Display[5],null,getPackageName());
            Drawable image_5 = getResources().getDrawable(imageResource_5);
            D6_2.setImageDrawable(image_5);

            ImageView D7_2 = (ImageView)findViewById(R.id.D7_2);
            Icon_7_Display[6] = "@drawable/"+Icon_7_Display[6];
            int imageResource_6 = getResources().getIdentifier(Icon_7_Display[6],null,getPackageName());
            Drawable image_6 = getResources().getDrawable(imageResource_6);
            D7_2.setImageDrawable(image_6);

            TextView D1_1 = (TextView)findViewById(R.id.D1_1);
            D1_1.setText(month_date_time[0]);
            TextView D2_1 = (TextView)findViewById(R.id.D2_1);
            D2_1.setText(month_date_time[1]);
            TextView D3_1 = (TextView)findViewById(R.id.D3_1);
            D3_1.setText(month_date_time[2]);
            TextView D4_1 = (TextView)findViewById(R.id.D4_1);
            D4_1.setText(month_date_time[3]);
            TextView D5_1 = (TextView)findViewById(R.id.D5_1);
            D5_1.setText(month_date_time[4]);
            TextView D6_1 = (TextView)findViewById(R.id.D6_1);
            D6_1.setText(month_date_time[5]);
            TextView D7_1 = (TextView)findViewById(R.id.D7_1);
            D7_1.setText(month_date_time[6]);

            String[] Time_24 = new String[48];
            String[] Time_Display_24 = new String[48];
            String[] ico = new String[48];
            String[] ico_24 =new String[48];
            String[] Temp_24 =new String[48];
            for(int j=0; j<48; j++){
                Time_24[j] = myJsonObject.getJSONObject("hourly").getJSONArray("data").getJSONObject(j+1).optString("time");
                timestamp_date = Long.parseLong(Time_24[j])*1000;
                Time_Display_24[j] = new java.text.SimpleDateFormat("HH:mm a").format(new java.util.Date(timestamp_date));
                Temp_24[j] = myJsonObject.getJSONObject("hourly").getJSONArray("data").getJSONObject(j+1).optString("temperature");
                ico[j] = myJsonObject.getJSONObject("hourly").getJSONArray("data").getJSONObject(j+1).optString("icon");
                switch(ico[j]){
                    case "fog":
                        ico_24[j] = ico[j];
                        break;
                    case "rain":
                        ico_24[j]= ico[j];
                        break;
                    case "sleet":
                        ico_24[j] = ico[j];
                        break;
                    case "snow":
                        ico_24[j]= ico[j];
                        break;
                    case "wind":
                        ico_24[j] = ico[j];
                        break;
                    case "cloudy":
                        ico_24[j] = ico[j];
                        break;
                    case "clear-day":
                        ico_24[j]= "clear";
                        break;
                    case "clear-night":
                        ico_24[j] = "clear_night";
                        break;
                    case "partly-cloudy-day":
                        ico_24[j]= "cloud_day";
                        break;
                    case "partly-cloudy-night":
                        ico_24[j] = "cloud_night";
                        break;
                    default:
                        break;
                }
            }

            TextView T4 = (TextView)findViewById(R.id.T4);
            T4.setText(Time_Display_24[0]);
            TextView T7 = (TextView)findViewById(R.id.T7);
            T7.setText(Time_Display_24[1]);
            TextView T10 = (TextView)findViewById(R.id.T10);
            T10.setText(Time_Display_24[2]);
            TextView T13 = (TextView)findViewById(R.id.T13);
            T13.setText(Time_Display_24[3]);
            TextView T16 = (TextView)findViewById(R.id.T16);
            T16.setText(Time_Display_24[4]);
            TextView T19 = (TextView)findViewById(R.id.T19);
            T19.setText(Time_Display_24[5]);
            TextView T22 = (TextView)findViewById(R.id.T22);
            T22.setText(Time_Display_24[6]);
            TextView T25 = (TextView)findViewById(R.id.T25);
            T25.setText(Time_Display_24[7]);
            TextView T28 = (TextView)findViewById(R.id.T28);
            T28.setText(Time_Display_24[8]);
            TextView T31 = (TextView)findViewById(R.id.T31);
            T31.setText(Time_Display_24[9]);
            TextView T34 = (TextView)findViewById(R.id.T34);
            T34.setText(Time_Display_24[10]);
            TextView T37 = (TextView)findViewById(R.id.T37);
            T37.setText(Time_Display_24[11]);
            TextView T40 = (TextView)findViewById(R.id.T40);
            T40.setText(Time_Display_24[12]);
            TextView T43 = (TextView)findViewById(R.id.T43);
            T43.setText(Time_Display_24[13]);
            TextView T46 = (TextView)findViewById(R.id.T46);
            T46.setText(Time_Display_24[14]);
            TextView T49 = (TextView)findViewById(R.id.T49);
            T49.setText(Time_Display_24[15]);
            TextView T52 = (TextView)findViewById(R.id.T52);
            T52.setText(Time_Display_24[16]);
            TextView T55 = (TextView)findViewById(R.id.T55);
            T55.setText(Time_Display_24[17]);
            TextView T58 = (TextView)findViewById(R.id.T58);
            T58.setText(Time_Display_24[18]);
            TextView T61 = (TextView)findViewById(R.id.T61);
            T61.setText(Time_Display_24[19]);
            TextView T64 = (TextView)findViewById(R.id.T64);
            T64.setText(Time_Display_24[20]);
            TextView T67 = (TextView)findViewById(R.id.T67);
            T67.setText(Time_Display_24[21]);
            TextView T70 = (TextView)findViewById(R.id.T70);
            T70.setText(Time_Display_24[22]);
            TextView T73 = (TextView)findViewById(R.id.T73);
            T73.setText(Time_Display_24[23]);
            TextView T76 = (TextView)findViewById(R.id.T76);
            T76.setText(Time_Display_24[24]);
            TextView T79 = (TextView)findViewById(R.id.T79);
            T79.setText(Time_Display_24[25]);
            TextView T82 = (TextView)findViewById(R.id.T82);
            T82.setText(Time_Display_24[26]);
            TextView T85 = (TextView)findViewById(R.id.T85);
            T85.setText(Time_Display_24[27]);
            TextView T88 = (TextView)findViewById(R.id.T88);
            T88.setText(Time_Display_24[28]);
            TextView T91 = (TextView)findViewById(R.id.T91);
            T91.setText(Time_Display_24[29]);
            TextView T94 = (TextView)findViewById(R.id.T94);
            T94.setText(Time_Display_24[30]);
            TextView T97 = (TextView)findViewById(R.id.T97);
            T97.setText(Time_Display_24[31]);
            TextView T100 = (TextView)findViewById(R.id.T100);
            T100.setText(Time_Display_24[32]);
            TextView T103 = (TextView)findViewById(R.id.T103);
            T103.setText(Time_Display_24[33]);
            TextView T106 = (TextView)findViewById(R.id.T106);
            T106.setText(Time_Display_24[34]);
            TextView T109 = (TextView)findViewById(R.id.T109);
            T109.setText(Time_Display_24[35]);
            TextView T112 = (TextView)findViewById(R.id.T112);
            T112.setText(Time_Display_24[36]);
            TextView T115 = (TextView)findViewById(R.id.T115);
            T115.setText(Time_Display_24[37]);
            TextView T118 = (TextView)findViewById(R.id.T118);
            T118.setText(Time_Display_24[38]);
            TextView T121 = (TextView)findViewById(R.id.T121);
            T121.setText(Time_Display_24[39]);
            TextView T124 = (TextView)findViewById(R.id.T124);
            T124.setText(Time_Display_24[40]);
            TextView T127 = (TextView)findViewById(R.id.T127);
            T127.setText(Time_Display_24[41]);
            TextView T130 = (TextView)findViewById(R.id.T130);
            T130.setText(Time_Display_24[42]);
            TextView T133 = (TextView)findViewById(R.id.T133);
            T133.setText(Time_Display_24[43]);
            TextView T136 = (TextView)findViewById(R.id.T136);
            T136.setText(Time_Display_24[44]);
            TextView T139 = (TextView)findViewById(R.id.T139);
            T139.setText(Time_Display_24[45]);
            TextView T142 = (TextView)findViewById(R.id.T142);
            T142.setText(Time_Display_24[46]);
            TextView T145 = (TextView)findViewById(R.id.T145);
            T145.setText(Time_Display_24[47]);

            int imageResource;
            Drawable image;

            ImageView T5 = (ImageView)findViewById(R.id.T5);
            ico_24[0] = "@drawable/"+ico_24[0];
            imageResource = getResources().getIdentifier(ico_24[0], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T5.setImageDrawable(image);

            ImageView T8 = (ImageView)findViewById(R.id.T8);
            ico_24[1] = "@drawable/"+ico_24[1];
            imageResource = getResources().getIdentifier(ico_24[1], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T8.setImageDrawable(image);

            ImageView T11 = (ImageView)findViewById(R.id.T11);
            ico_24[2] = "@drawable/"+ico_24[2];
            imageResource = getResources().getIdentifier(ico_24[2], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T11.setImageDrawable(image);

            ImageView T14 = (ImageView)findViewById(R.id.T14);
            ico_24[3] = "@drawable/"+ico_24[3];
            imageResource = getResources().getIdentifier(ico_24[3], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T14.setImageDrawable(image);

            ImageView T17 = (ImageView)findViewById(R.id.T17);
            ico_24[4] = "@drawable/"+ico_24[4];
            imageResource = getResources().getIdentifier(ico_24[4], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T17.setImageDrawable(image);

            ImageView T20 = (ImageView)findViewById(R.id.T20);
            ico_24[5] = "@drawable/"+ico_24[5];
            imageResource = getResources().getIdentifier(ico_24[5], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T20.setImageDrawable(image);

            ImageView T23 = (ImageView)findViewById(R.id.T23);
            ico_24[6] = "@drawable/"+ico_24[6];
            imageResource = getResources().getIdentifier(ico_24[6], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T23.setImageDrawable(image);

            ImageView T26 = (ImageView)findViewById(R.id.T26);
            ico_24[7] = "@drawable/"+ico_24[7];
            imageResource = getResources().getIdentifier(ico_24[7], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T26.setImageDrawable(image);

            ImageView T29 = (ImageView)findViewById(R.id.T29);
            ico_24[8] = "@drawable/"+ico_24[8];
            imageResource = getResources().getIdentifier(ico_24[8], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T29.setImageDrawable(image);

            ImageView T32 = (ImageView)findViewById(R.id.T32);
            ico_24[9] = "@drawable/"+ico_24[9];
            imageResource = getResources().getIdentifier(ico_24[9], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T32.setImageDrawable(image);

            ImageView T35 = (ImageView)findViewById(R.id.T35);
            ico_24[10] = "@drawable/"+ico_24[10];
            imageResource = getResources().getIdentifier(ico_24[10], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T35.setImageDrawable(image);

            ImageView T38 = (ImageView)findViewById(R.id.T38);
            ico_24[11] = "@drawable/"+ico_24[11];
            imageResource = getResources().getIdentifier(ico_24[11], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T38.setImageDrawable(image);

            ImageView T41 = (ImageView)findViewById(R.id.T41);
            ico_24[12] = "@drawable/"+ico_24[12];
            imageResource = getResources().getIdentifier(ico_24[12], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T41.setImageDrawable(image);

            ImageView T44 = (ImageView)findViewById(R.id.T44);
            ico_24[13] = "@drawable/"+ico_24[13];
            imageResource = getResources().getIdentifier(ico_24[13], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T44.setImageDrawable(image);

            ImageView T47 = (ImageView)findViewById(R.id.T47);
            ico_24[14] = "@drawable/"+ico_24[14];
            imageResource = getResources().getIdentifier(ico_24[14], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T47.setImageDrawable(image);

            ImageView T50 = (ImageView)findViewById(R.id.T50);
            ico_24[15] = "@drawable/"+ico_24[15];
            imageResource = getResources().getIdentifier(ico_24[15], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T50.setImageDrawable(image);

            ImageView T53 = (ImageView)findViewById(R.id.T53);
            ico_24[18] = "@drawable/"+ico_24[18];
            imageResource = getResources().getIdentifier(ico_24[18], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T53.setImageDrawable(image);

            ImageView T56 = (ImageView)findViewById(R.id.T56);
            ico_24[19] = "@drawable/"+ico_24[19];
            imageResource = getResources().getIdentifier(ico_24[19], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T56.setImageDrawable(image);

            ImageView T59 = (ImageView)findViewById(R.id.T59);
            ico_24[20] = "@drawable/"+ico_24[20];
            imageResource = getResources().getIdentifier(ico_24[20], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T59.setImageDrawable(image);

            ImageView T62 = (ImageView)findViewById(R.id.T62);
            ico_24[21] = "@drawable/"+ico_24[21];
            imageResource = getResources().getIdentifier(ico_24[21], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T62.setImageDrawable(image);

            ImageView T65 = (ImageView)findViewById(R.id.T65);
            ico_24[22] = "@drawable/"+ico_24[22];
            imageResource = getResources().getIdentifier(ico_24[22], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T65.setImageDrawable(image);

            ImageView T68 = (ImageView)findViewById(R.id.T68);
            ico_24[23] = "@drawable/"+ico_24[23];
            imageResource = getResources().getIdentifier(ico_24[23], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T68.setImageDrawable(image);

            ImageView T71 = (ImageView)findViewById(R.id.T71);
            ico_24[24] = "@drawable/"+ico_24[24];
            imageResource = getResources().getIdentifier(ico_24[24], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T71.setImageDrawable(image);

            ImageView T74 = (ImageView)findViewById(R.id.T74);
            ico_24[25] = "@drawable/"+ico_24[25];
            imageResource = getResources().getIdentifier(ico_24[25], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T74.setImageDrawable(image);

            ImageView T77 = (ImageView)findViewById(R.id.T77);
            ico_24[26] = "@drawable/"+ico_24[26];
            imageResource = getResources().getIdentifier(ico_24[26], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T77.setImageDrawable(image);

            ImageView T80 = (ImageView)findViewById(R.id.T80);
            ico_24[27] = "@drawable/"+ico_24[27];
            imageResource = getResources().getIdentifier(ico_24[27], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T80.setImageDrawable(image);

            ImageView T83 = (ImageView)findViewById(R.id.T83);
            ico_24[28] = "@drawable/"+ico_24[28];
            imageResource = getResources().getIdentifier(ico_24[28], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T83.setImageDrawable(image);

            ImageView T86 = (ImageView)findViewById(R.id.T86);
            ico_24[29] = "@drawable/"+ico_24[29];
            imageResource = getResources().getIdentifier(ico_24[29], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T86.setImageDrawable(image);

            ImageView T89 = (ImageView)findViewById(R.id.T89);
            ico_24[30] = "@drawable/"+ico_24[30];
            imageResource = getResources().getIdentifier(ico_24[30], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T89.setImageDrawable(image);

            ImageView T92 = (ImageView)findViewById(R.id.T92);
            ico_24[31] = "@drawable/"+ico_24[31];
            imageResource = getResources().getIdentifier(ico_24[31], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T92.setImageDrawable(image);

            ImageView T95 = (ImageView)findViewById(R.id.T95);
            ico_24[32] = "@drawable/"+ico_24[32];
            imageResource = getResources().getIdentifier(ico_24[32], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T95.setImageDrawable(image);

            ImageView T98 = (ImageView)findViewById(R.id.T98);
            ico_24[33] = "@drawable/"+ico_24[33];
            imageResource = getResources().getIdentifier(ico_24[33], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T98.setImageDrawable(image);

            ImageView T101 = (ImageView)findViewById(R.id.T101);
            ico_24[34] = "@drawable/"+ico_24[34];
            imageResource = getResources().getIdentifier(ico_24[34], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T101.setImageDrawable(image);

            ImageView T104 = (ImageView)findViewById(R.id.T104);
            ico_24[35] = "@drawable/"+ico_24[35];
            imageResource = getResources().getIdentifier(ico_24[35], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T104.setImageDrawable(image);

            ImageView T107 = (ImageView)findViewById(R.id.T107);
            ico_24[36] = "@drawable/"+ico_24[36];
            imageResource = getResources().getIdentifier(ico_24[36], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T107.setImageDrawable(image);

            ImageView T110 = (ImageView)findViewById(R.id.T110);
            ico_24[37] = "@drawable/"+ico_24[37];
            imageResource = getResources().getIdentifier(ico_24[37], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T110.setImageDrawable(image);

            ImageView T113 = (ImageView)findViewById(R.id.T113);
            ico_24[38] = "@drawable/"+ico_24[38];
            imageResource = getResources().getIdentifier(ico_24[38], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T113.setImageDrawable(image);

            ImageView T116 = (ImageView)findViewById(R.id.T116);
            ico_24[39] = "@drawable/"+ico_24[39];
            imageResource = getResources().getIdentifier(ico_24[39], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T116.setImageDrawable(image);

            ImageView T119 = (ImageView)findViewById(R.id.T119);
            ico_24[40] = "@drawable/"+ico_24[40];
            imageResource = getResources().getIdentifier(ico_24[40], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T119.setImageDrawable(image);

            ImageView T122 = (ImageView)findViewById(R.id.T122);
            ico_24[41] = "@drawable/"+ico_24[41];
            imageResource = getResources().getIdentifier(ico_24[41], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T122.setImageDrawable(image);

            ImageView T125 = (ImageView)findViewById(R.id.T125);
            ico_24[42] = "@drawable/"+ico_24[42];
            imageResource = getResources().getIdentifier(ico_24[42], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T125.setImageDrawable(image);

            ImageView T128 = (ImageView)findViewById(R.id.T128);
            ico_24[43] = "@drawable/"+ico_24[43];
            imageResource = getResources().getIdentifier(ico_24[43], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T128.setImageDrawable(image);

            ImageView T131 = (ImageView)findViewById(R.id.T131);
            ico_24[44] = "@drawable/"+ico_24[44];
            imageResource = getResources().getIdentifier(ico_24[44], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T131.setImageDrawable(image);

            ImageView T134 = (ImageView)findViewById(R.id.T134);
            ico_24[45] = "@drawable/"+ico_24[45];
            imageResource = getResources().getIdentifier(ico_24[45], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T134.setImageDrawable(image);

            ImageView T137 = (ImageView)findViewById(R.id.T137);
            ico_24[46] = "@drawable/"+ico_24[46];
            imageResource = getResources().getIdentifier(ico_24[46], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T137.setImageDrawable(image);

            ImageView T140 = (ImageView)findViewById(R.id.T140);
            ico_24[47] = "@drawable/"+ico_24[47];
            imageResource = getResources().getIdentifier(ico_24[47], null, getPackageName());
            image = getResources().getDrawable(imageResource);
            T140.setImageDrawable(image);



            TextView T6 = (TextView)findViewById(R.id.T6);
            T6.setText(Temp_24[0]);
            TextView T9 = (TextView)findViewById(R.id.T9);
            T9.setText(Temp_24[1]);
            TextView T12 = (TextView)findViewById(R.id.T12);
            T12.setText(Temp_24[2]);
            TextView T15 = (TextView)findViewById(R.id.T15);
            T15.setText(Temp_24[3]);
            TextView T18 = (TextView)findViewById(R.id.T18);
            T18.setText(Temp_24[4]);
            TextView T21 = (TextView)findViewById(R.id.T21);
            T21.setText(Temp_24[5]);
            TextView T24 = (TextView)findViewById(R.id.T24);
            T24.setText(Temp_24[6]);
            TextView T27 = (TextView)findViewById(R.id.T27);
            T27.setText(Temp_24[7]);
            TextView T30 = (TextView)findViewById(R.id.T30);
            T30.setText(Temp_24[8]);
            TextView T33 = (TextView)findViewById(R.id.T33);
            T33.setText(Temp_24[9]);
            TextView T36 = (TextView)findViewById(R.id.T36);
            T36.setText(Temp_24[10]);
            TextView T39 = (TextView)findViewById(R.id.T39);
            T39.setText(Temp_24[11]);
            TextView T42= (TextView)findViewById(R.id.T42);
            T42.setText(Temp_24[12]);
            TextView T45 = (TextView)findViewById(R.id.T45);
            T45.setText(Temp_24[13]);
            TextView T48 = (TextView)findViewById(R.id.T48);
            T48.setText(Temp_24[14]);
            TextView T51 = (TextView)findViewById(R.id.T51);
            T51.setText(Temp_24[15]);
            TextView T54 = (TextView)findViewById(R.id.T54);
            T54.setText(Temp_24[16]);
            TextView T57 = (TextView)findViewById(R.id.T57);
            T57.setText(Temp_24[17]);
            TextView T60 = (TextView)findViewById(R.id.T60);
            T60.setText(Temp_24[18]);
            TextView T63 = (TextView)findViewById(R.id.T63);
            T63.setText(Temp_24[19]);
            TextView T66 = (TextView)findViewById(R.id.T66);
            T66.setText(Temp_24[20]);
            TextView T69 = (TextView)findViewById(R.id.T69);
            T69.setText(Temp_24[21]);
            TextView T72 = (TextView)findViewById(R.id.T72);
            T72.setText(Temp_24[22]);
            TextView T75 = (TextView)findViewById(R.id.T75);
            T75.setText(Temp_24[23]);
            TextView T78 = (TextView)findViewById(R.id.T78);
            T78.setText(Temp_24[24]);
            TextView T81 = (TextView)findViewById(R.id.T81);
            T81.setText(Temp_24[25]);
            TextView T84 = (TextView)findViewById(R.id.T84);
            T84.setText(Temp_24[26]);
            TextView T87 = (TextView)findViewById(R.id.T87);
            T87.setText(Temp_24[27]);
            TextView T90 = (TextView)findViewById(R.id.T90);
            T90.setText(Temp_24[28]);
            TextView T93 = (TextView)findViewById(R.id.T93);
            T93.setText(Temp_24[29]);
            TextView T96 = (TextView)findViewById(R.id.T96);
            T96.setText(Temp_24[30]);
            TextView T99 = (TextView)findViewById(R.id.T99);
            T99.setText(Temp_24[31]);
            TextView T102 = (TextView)findViewById(R.id.T102);
            T102.setText(Temp_24[32]);
            TextView T105 = (TextView)findViewById(R.id.T105);
            T105.setText(Temp_24[33]);
            TextView T108 = (TextView)findViewById(R.id.T108);
            T108.setText(Temp_24[34]);
            TextView T111 = (TextView)findViewById(R.id.T111);
            T111.setText(Temp_24[35]);
            TextView T114 = (TextView)findViewById(R.id.T114);
            T114.setText(Temp_24[36]);
            TextView T117 = (TextView)findViewById(R.id.T117);
            T117.setText(Temp_24[37]);
            TextView T120 = (TextView)findViewById(R.id.T120);
            T120.setText(Temp_24[38]);
            TextView T123 = (TextView)findViewById(R.id.T123);
            T123.setText(Temp_24[39]);
            TextView T126 = (TextView)findViewById(R.id.T126);
            T126.setText(Temp_24[40]);
            TextView T129 = (TextView)findViewById(R.id.T129);
            T129.setText(Temp_24[41]);
            TextView T132 = (TextView)findViewById(R.id.T132);
            T132.setText(Temp_24[42]);
            TextView T135 = (TextView)findViewById(R.id.T135);
            T135.setText(Temp_24[43]);
            TextView T138 = (TextView)findViewById(R.id.T138);
            T138.setText(Temp_24[44]);
            TextView T141 = (TextView)findViewById(R.id.T141);
            T141.setText(Temp_24[45]);
            TextView T144 = (TextView)findViewById(R.id.T144);
            T144.setText(Temp_24[46]);
            TextView T147 = (TextView)findViewById(R.id.T147);
            T147.setText(Temp_24[47]);













        }
        catch(JSONException e)
        {
        }


    }
}
