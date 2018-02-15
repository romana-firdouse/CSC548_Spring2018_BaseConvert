package com.example.awesomefat.csc548_spring2018_baseconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class DecimalToBase extends AppCompatActivity
{

    private EditText inputET;
    private TextView answerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal_to_base);

        this.inputET = (EditText)this.findViewById(R.id.inputET);
        this.answerTV = (TextView)this.findViewById(R.id.answerTV);
    }

    private String convertDecimalToBaseNumber(String numStr, int base)
    {
        int  num = Integer.parseInt(numStr);

        String baseNum = "";
        String rem = "";

        while (num > 0)
        {
            if ((num % base) <= 9)
                rem = Integer.toString(num % base);
            else
                rem = Character.toString((char)('A' + (num % base) - 10));

            baseNum = rem + baseNum;
            num = num / base;
        }

        if (baseNum == "") /* To handle a case where input is zero*/
            return "0";

        return baseNum;
    }


    public void base2ButtonPressed(View v)
    {
        if (inputET.getText().toString().equals(""))
        {
            return;
        }
        String num = inputET.getText().toString();
        String val = convertDecimalToBaseNumber(num, 2);
        answerTV.setText("Base " + num + " :  " + val);

    }

    public void base8ButtonPressed(View v)
    {
        if (inputET.getText().toString().equals(""))
        {
            return;
        }
        String num = inputET.getText().toString();
        String val = convertDecimalToBaseNumber(num, 8);
        answerTV.setText("Base " + num + " :  " + val);
    }

    public void base10ButtonPressed(View v)
    {
        if (inputET.getText().toString().equals(""))
        {
            return;
        }
        String num = inputET.getText().toString();
        String val = convertDecimalToBaseNumber(num, 10);
        answerTV.setText("Base " + num + " :  " + val);
    }

    public void base16ButtonPressed(View v)
    {
        if (inputET.getText().toString().equals(""))
        {
            return;
        }
        String num = inputET.getText().toString();
        String val = convertDecimalToBaseNumber(num, 16);
        answerTV.setText("Base " + num + " :  " + val);
    }

}
