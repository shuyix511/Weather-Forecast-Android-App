package com.example.thinkpad.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.AsyncTask;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MyActivity extends AppCompatActivity {
    private RadioButton FBtn;
    private Spinner StateSpinner;
    private TextView error;
    private ImageButton forecast_log_button_2;
    private String Degree_Selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final EditText TextStreet = (EditText) findViewById(R.id.edit_street);
        final EditText TextCity = (EditText) findViewById(R.id.edit_city);
        FBtn = (RadioButton)findViewById(R.id.radio_button_F);

        StateSpinner = (Spinner)findViewById(R.id.Spinner_State);
        error = (TextView)findViewById(R.id.error_text);
        forecast_log_button_2 = (ImageButton)findViewById(R.id.forecast_log_button);
        final Button ButtonClear = (Button) findViewById(R.id.clear);
        final Button ButtonSearch = (Button) findViewById(R.id.search);
        final Button ButtonAbout = (Button) findViewById(R.id.about);

        ButtonClear.setOnClickListener(new OnClickListener() {  //Clear button
            public void onClick(View v) {
                TextStreet.setText("");
                TextCity.setText("");
                StateSpinner.setSelection(0);
                FBtn.setChecked(true);
                error.setText("");
            }
        });

        forecast_log_button_2.setOnClickListener(new OnClickListener() {  //logo
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://forecast.io"));
                startActivity(intent);
            }
        });

        ButtonAbout.setOnClickListener(new OnClickListener() {  //logo
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this, AboutActivity.class);
                MyActivity.this.startActivity(intent);
            }
        });

        ButtonSearch.setOnClickListener(new OnClickListener() {  //Search button
            public void onClick(View v) {
                //Validation
                if (TextStreet.getText().length() <= 0) {
                    error.setText("Please enter a Street");
                    return;
                } else if (TextCity.getText().length() <= 0) {
                    error.setText("Please enter a City");
                    return;
                } else if (StateSpinner.getSelectedItem().toString().equals("Select")) {
                    error.setText("Please enter a State");
                    return;
                }
                if (FBtn.isChecked())
                    Degree_Selected = "Fahrenheit";
                else
                    Degree_Selected = "Celsius";
                String[] formData = new String[4];
                formData[0] = TextStreet.getText().toString();
                formData[1] = TextCity.getText().toString();
                formData[2] = StateSpinner.getSelectedItem().toString();
                formData[3] = Degree_Selected;

                searchTask task = new searchTask();
                task.execute(formData);
            }
        });
    }

    public class searchTask extends AsyncTask<String[], Void, String[]> {
        @Override
        protected String[] doInBackground(String[]... params) {
            // create url
            String[] Input_Value = params[0];
            final String ADDRESS = "Address";
            final String CITY = "City";
            final String STATE = "State";
            final String DEGREE = "Degree";
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            String Result_Json = "";

            try {
                Uri.Builder uriBuilder = new Uri.Builder();
                uriBuilder.scheme("http").authority("shuyixu-env.elasticbeanstalk.com")
                        .appendQueryParameter(ADDRESS, Input_Value[0])
                        .appendQueryParameter(CITY, Input_Value[1])
                        .appendQueryParameter(STATE, Input_Value[2])
                        .appendQueryParameter(DEGREE, Input_Value[3]);

                String Url = uriBuilder.build().toString();
                URL MyUrl = new URL(Url);
                Log.v("tag",Url);

                urlConnection = (HttpURLConnection)MyUrl.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    Log.e("tag", "No json from php");
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {

                    buffer.append(line);
                }
                reader.close();

                if (buffer.length() == 0) {
                    Log.e("tag", "Empty json");
                    return null;
                }
                Result_Json = buffer.toString();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if(urlConnection != null){
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("SearchFragment", "Error closing stream", e);
                    }
                }
            }
            return new String[]{Input_Value[1],Input_Value[2],Input_Value[3],Result_Json};
        }
        @Override
        protected void onPostExecute(String[] s) {
            super.onPostExecute(s);

            Intent intent =new Intent(MyActivity.this, ResultActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("json", s[3]);
            bundle.putString("degree", s[2]);
            bundle.putString("city", s[0]);
            bundle.putString("state", s[1]);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
