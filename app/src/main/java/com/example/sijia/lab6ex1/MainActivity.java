package com.example.sijia.lab6ex1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText key;
    private String keyString;
    private EditText value;
    private String valueString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupInfo();

    }

    public void setupInfo(){
        SharedPreferences sharedPreferences = getSharedPreferences("user_name",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username","Amy");
        editor.putString("address","9500 Gilman Dr, La Jolla, CA 92093");
        editor.putString("phonenum","8585342230");
        editor.apply();
    }
    public void displayInfo(View view){

        SharedPreferences sharedPreferences = getSharedPreferences("user_name", MODE_PRIVATE);
        String savedName = sharedPreferences.getString("username","");
        EditText enteredName = (EditText)findViewById(R.id.editText);
        if((enteredName.getText().toString()).equals(savedName)){
            String savedAddress = sharedPreferences.getString("address","");
            String savedPhoneNum = sharedPreferences.getString("phonenum","");
            TextView correct = (TextView) findViewById(R.id.textView);
            String output = "Address: "+savedAddress+".\n PhoneNum: "+savedPhoneNum+".";
            correct.setText(output);
        }
        else{
            String output = "Wrong user name, please re-enter.";
            TextView notcorrect = (TextView) findViewById(R.id.textView);
            notcorrect.setText(output);
        }

    }
    public void starter(View view) {
        Intent intent = new Intent (MainActivity.this,MyIntentService.class);
        startService(intent);
        SharedPreferences sharedPreferences = getSharedPreferences("entered_name",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        key = (EditText)findViewById(R.id.editText2);
        value = (EditText)findViewById(R.id.editText);
        keyString=key.getText().toString();
        valueString=value.getText().toString();
        editor.putString(keyString,valueString );
        editor.apply();
    }

    public void show(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("entered_name",MODE_PRIVATE);
        String savedVal = sharedPreferences.getString(keyString,"");

        String output = "Key: \""+keyString+"\". Value: \""+ savedVal+"\".";
        System.out.println(output);
        TextView out = (TextView) findViewById(R.id.textView3);
        out.setText(output);
    }
}
