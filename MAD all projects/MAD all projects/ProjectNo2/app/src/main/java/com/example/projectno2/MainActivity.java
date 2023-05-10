package com.example.projectno2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    EditText txtDecimal;
    TextView txtBinary, txtOctal, txtHexadecimal;
    Button btnAbout;

    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_main);
        txtDecimal = (EditText) findViewById(R.id.txtDecimal);
        txtBinary = (TextView) findViewById(R.id.txtBinary);
        txtOctal = (TextView) findViewById(R.id.txtOctal);
        txtHexadecimal = (TextView) findViewById(R.id.txtHexadecimal);
        btnAbout = (Button) findViewById(R.id.button1);
        btnAbout.setOnClickListener(this::onClick);
    }

    public void calculate(int base, TextView txtView) {
        if (txtDecimal.getText().toString().trim().length() == 0) {
            txtView.setText("");
            return;

        }
        try {
            Stack<Object> stack = new Stack<>();
            int number = Integer.parseInt(txtDecimal.getText().toString());

            while (number > 0) {
                int remainder = number % base;
                if (remainder < 10) {
                    stack.push(remainder);
                } else {
                    switch (remainder) {

                        case 10:
                            stack.push("A");
                            break;
                        case 11:
                            stack.push("B");
                            break;
                        case 12:
                            stack.push("C");
                            break;
                        case 13:
                            stack.push("D");
                            break;
                        case 14:
                            stack.push("E");
                            break;
                        case 15:
                            stack.push("F");
                            break;
                    }
                }
                number /= base;
            }
            StringBuilder buffer = new StringBuilder();
            while (!stack.isEmpty()) {
                buffer.append(stack.pop().toString());
            }
            txtView.setText(buffer.toString());
        } catch (Exception e) {
            txtView.setText(e.getMessage());
        }
    }

    public void onClick(View view) {
        calculate(2, txtBinary);
        calculate(8, txtOctal);
        calculate(16, txtHexadecimal);

    }
}
