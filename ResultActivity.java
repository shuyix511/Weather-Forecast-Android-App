package com.example.thinkpad.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.math.BigDecimal;
import org.json.JSONObject;
import org.json.JSONException;
/**
 * Created by Thinkpad on 2015/12/9.
 */
public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Bundle bundle = this.getIntent().getExtras();
        final String json = bundle.getString("json");
        final String city = bundle.getString("city");
        final String state = bundle.getString("state");
        final String degree = bundle.getString("degree");
        final Button More_Details = (Button) findViewById(R.id.more_details);

        More_Details.setOnClickListener(new View.OnClickListener() {  //logo
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ResultActivity.this, DetailsActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("json", json);
                bundle.putString("degree", degree);
                bundle.putString("city", city);
                bundle.putString("state", state);
                intent.putExtras(bundle);
                ResultActivity.this.startActivity(intent);
            }
        });

        try {
            JSONObject myJsonObject = new JSONObject(json);
            String Unit_Display = "";
            String windspeed_unit = "";
            String visibility_unit = "";
            String pressure_unit = "";

            //temperature
            int GetTemp = myJsonObject.getJSONObject("currently").getInt("temperature");
            TextView Temp_Display = (TextView)findViewById(R.id.temperature);
            TextView unit_Display = (TextView)findViewById(R.id.unit);

            switch (degree){
                case "Fahrenheit":
                    Unit_Display = "F";
                    windspeed_unit = "mph";
                    visibility_unit = "mi";
                    pressure_unit = "mb";
                    break;
                case "Celsius":
                    Unit_Display = "C";
                    windspeed_unit = "m/s";
                    visibility_unit = "km";
                    pressure_unit = "hPa";
                    break;
                default:
                    break;
            }
            Temp_Display.setText(" " + GetTemp);
            unit_Display.setText("°"+ Unit_Display);

            //low high temperature
            double Low_Temp = myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("temperatureMin");
            double High_Temp = myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(0).getDouble("temperatureMax");
            BigDecimal bd_low_temp = new BigDecimal(Low_Temp);
            BigDecimal bd_high_temp = new BigDecimal(High_Temp);
            bd_low_temp = bd_low_temp.setScale(0,BigDecimal.ROUND_HALF_UP);
            bd_high_temp = bd_high_temp.setScale(0,BigDecimal.ROUND_HALF_UP);
            TextView Low_High_Temp_Display = (TextView)findViewById(R.id.Low_High_Temperature);
            Low_High_Temp_Display.setText("L:" + bd_low_temp + "°" + Unit_Display + "| H:" + bd_high_temp + "°" + Unit_Display);

            //rain
            double GetChance_of_rain = myJsonObject.getJSONObject("currently").getDouble("precipProbability");
            int GetChance_of_rain_int = (int)Math.floor(GetChance_of_rain * 100);
            TextView Chance_of_rain_Display = (TextView)findViewById(R.id.Chance_of_rain_Value);
            Chance_of_rain_Display.setText(GetChance_of_rain_int + " %");

            //icon
            String icon = myJsonObject.getJSONObject("currently").optString("icon");
            String icon_display="";
            switch (icon) {
                case "fog":
                    icon_display = icon;
                    break;
                case "rain":
                    icon_display = icon;
                    break;
                case "sleet":
                    icon_display = icon;
                    break;
                case "snow":
                    icon_display = icon;
                    break;
                case "wind":
                    icon_display = icon;
                    break;
                case "cloudy":
                    icon_display = icon;
                    break;
                case "clear-day":
                    icon_display = "clear";
                    break;
                case "clear-night":
                    icon_display = "clear_night";
                    break;
                case "partly-cloudy-day":
                    icon_display = "cloud_day";
                    break;
                case "partly-cloudy-night":
                    icon_display = "cloud_night";
                    break;
                default:
                    break;
            }

            ImageView Weather_Image_Display = (ImageView)findViewById(R.id.Weather_Image);
            icon_display = "@drawable/"+icon_display;
            int imageResource = getResources().getIdentifier(icon_display,null,getPackageName());
            Drawable image = getResources().getDrawable(imageResource);
            Weather_Image_Display.setImageDrawable(image);

            //summary
            String GetSummary = myJsonObject.getJSONObject("currently").optString("summary");
            TextView Summary_Display = (TextView)findViewById(R.id.summary);
            Summary_Display.setText(GetSummary + " in " + city + ", " + state);

            //precipitation
            TextView Precipitation_Display = (TextView)findViewById(R.id.Precipitation_Value);
            double GetPrecipitation = myJsonObject.getJSONObject("currently").getDouble("precipIntensity");
            if(Unit_Display.equals("C") == true )
                GetPrecipitation/=25.4;
            if(GetPrecipitation >= 0 && GetPrecipitation < 0.002)
                Precipitation_Display.setText("None");
            if(GetPrecipitation >= 0.002 && GetPrecipitation < 0.017)
                Precipitation_Display.setText("Very Light");
            if(GetPrecipitation >= 0.017 && GetPrecipitation < 0.1)
                Precipitation_Display.setText("Light");
            if(GetPrecipitation >= 0.1 && GetPrecipitation < 0.4)
                Precipitation_Display.setText("Moderate");
            if(GetPrecipitation >= 0.4)
                Precipitation_Display.setText("Heavy");

            //wind speed
            double GetWind_Speed = myJsonObject.getJSONObject("currently").getDouble("windSpeed");
            BigDecimal bd_Wind_Speed = new BigDecimal(GetWind_Speed);
            bd_Wind_Speed = bd_Wind_Speed.setScale(2,BigDecimal.ROUND_HALF_UP);
            TextView Wind_Speed_Display = (TextView)findViewById(R.id.Wind_Speed_Value);
            Wind_Speed_Display.setText(bd_Wind_Speed + " " + windspeed_unit);

            //dew point
            double GetDew_Point = myJsonObject.getJSONObject("currently").getDouble("dewPoint");
            BigDecimal bd_Dew_Point = new BigDecimal(GetDew_Point);
            bd_Dew_Point = bd_Dew_Point.setScale(2,BigDecimal.ROUND_HALF_UP);
            TextView Dew_Point_Display = (TextView)findViewById(R.id.Dew_Point_Value);
            Dew_Point_Display.setText(bd_Dew_Point + "°" + Unit_Display);

            //humidity
            double GetHumidity = myJsonObject.getJSONObject("currently").getDouble("humidity");
            int GetHumidity_int = (int)Math.floor(GetHumidity*100);
            TextView Humidity_Display = (TextView)findViewById(R.id.Humidity_Value);
            Humidity_Display.setText(GetHumidity_int + " %");

            //visibility
            double GetVisibility = myJsonObject.getJSONObject("currently").getDouble("visibility");
            BigDecimal bd_Visibility = new BigDecimal(GetVisibility);
            bd_Visibility = bd_Visibility.setScale(2,BigDecimal.ROUND_HALF_UP);
            TextView Visibility_Display = (TextView)findViewById(R.id.Visibility_Value);
            Visibility_Display.setText(bd_Visibility + " " + visibility_unit);

            //sunrise
            String GetSunrise = myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(0).optString("sunriseTime");
            Long timestamp_sunrise = Long.parseLong(GetSunrise)*1000;
            String date_sunrise = new java.text.SimpleDateFormat("HH:mm a").format(new java.util.Date(timestamp_sunrise));
            TextView Sunrise_Display = (TextView)findViewById(R.id.Sunrise_Value);
            Sunrise_Display.setText(date_sunrise);

            //sunset
            String GetSunset = myJsonObject.getJSONObject("daily").getJSONArray("data").getJSONObject(0).optString("sunsetTime");
            Long timestamp_sunset = Long.parseLong(GetSunset)*1000;
            String date_sunset = new java.text.SimpleDateFormat("HH:mm a").format(new java.util.Date(timestamp_sunset));
            TextView Sunset_Display = (TextView)findViewById(R.id.Sunset_Value);
            Sunset_Display.setText(date_sunset);
        }
        catch(JSONException e)
        {
        }



    }
}
