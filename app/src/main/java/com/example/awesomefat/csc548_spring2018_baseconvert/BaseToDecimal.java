package com.example.awesomefat.csc548_spring2018_baseconvert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class BaseToDecimal extends AppCompatActivity
{
    private EditText inputET;
    private TextView answerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_to_decimal);

        this.inputET = (EditText)this.findViewById(R.id.inputET);
        this.answerTV = (TextView)this.findViewById(R.id.answerTV);
    }

    private int mapCharToNum(char ch)
    {
        if (ch >= '0' && ch <= '9')
            return ch - '0';

        if (ch >= 'A' && ch <= 'Z')
        {
            return ch - 'A' + 10;
        }
        return ch - 'a' + 10;
    }

    private int convertBaseToDecimal(int base, String numStr)
    {
        int len = numStr.length();

        int val = 0;

        for (int i = 0; i < len; i++)
        {
            char ch = numStr.charAt(i);
            int n = 0;

            if (ch >= '0' && ch <= '9')
            {
                n = ch - 48;
            }
            else if (ch >= 'A' && ch <= 'Z')
            {
                n = ch - 'A' + 10;
            }
            else if (ch >= 'a' && ch <= 'z')
            {
                n = ch - 'a' + 10;
            }

            val = val  * base +  n;
        }

        return val;
    }

    private boolean isValidBaseNumber(int base, String numStr)
    {
        int len = numStr.length();

        for (int i = 0; i < len; i++)
        {
            char ch = numStr.charAt(i);

            if (!(ch >= '0' && ch <= '9') &&
                    !(ch >= 'A' && ch <= 'Z') &&
                    !(ch >= 'a' && ch <= 'z'))
            {
                return false;
            }

            if (mapCharToNum(ch) >= base)
                return false;
        }
        return true;
    }

    public void base2ButtonPressed(View v)
    {
        if (this.inputET.getText().toString().equals(""))
        {
            return;
        }

        String num = inputET.getText().toString();

        if (!isValidBaseNumber(2, num))
        {
            Toast.makeText(BaseToDecimal.this, "Invalid number",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        answerTV.setText("" + convertBaseToDecimal(2, num));

    }

    public void base8ButtonPressed(View v)

    {
        if (this.inputET.getText().toString().equals(""))
        {
            return;
        }

        String num = inputET.getText().toString();

        if (!isValidBaseNumber(8, num))
        {
            Toast.makeText(BaseToDecimal.this, "Invalid number",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        answerTV.setText("" + convertBaseToDecimal(8, num));
    }

    public void base10ButtonPressed(View v)

    {
        if (this.inputET.getText().toString().equals(""))
        {
            return;
        }

        String num = inputET.getText().toString();

        if (!isValidBaseNumber(10, num))
        {
            Toast.makeText(BaseToDecimal.this, "Invalid number",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        answerTV.setText("" + convertBaseToDecimal(10, num));
    }

    public void base16ButtonPressed(View v)

    {
        if (this.inputET.getText().toString().equals(""))
        {
            return;
        }

        String num = inputET.getText().toString();

        if (!isValidBaseNumber(16, num))
        {
            Toast.makeText(BaseToDecimal.this, "Invalid number",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        answerTV.setText("" + convertBaseToDecimal(16, num));
    }

}
