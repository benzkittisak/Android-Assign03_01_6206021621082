/**
 * 6206021621082
 * กิตติศักดิ์ ปานเหลือ
 */
package com.moochiking.assign03_01_6206021621082;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNumber;
    private RadioButton binaryRadio , octalRadio , hexRadio ;
    private Button btnChange;
    private TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber = (EditText) findViewById(R.id.editNumber);

        binaryRadio = (RadioButton) findViewById(R.id.binaryRadio);
        octalRadio = (RadioButton) findViewById(R.id.octalRadio);
        hexRadio = (RadioButton) findViewById(R.id.hexRadio);

        show = (TextView) findViewById(R.id.show);

        btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(editNumber.getText().toString().equals("")){
            Toast.makeText(this, "กรุณาป้อนตัวเลข", Toast.LENGTH_SHORT).show();
            return;
        }

        String message = "";
        int decimalNumber = Integer.parseInt(editNumber.getText().toString());

        if(!binaryRadio.isChecked() && !octalRadio.isChecked() && !hexRadio.isChecked()){
            Toast.makeText(this, "กรุณาเลือกรูปแบบการแปลงตัวเลข" , Toast.LENGTH_SHORT).show();
            return;
        }

        if(binaryRadio.isChecked()){
            int temp ;
            while(decimalNumber > 0) {
                temp = decimalNumber % 2;
                decimalNumber = decimalNumber / 2;
                message = temp + message;
            }
            show.setText( "\nDecimal : " + editNumber.getText().toString() + "\nBinary : " + message);
            message = "";
        }
        else if(octalRadio.isChecked()){
            int temp ;
            while(decimalNumber > 0) {
                temp = decimalNumber % 8;
                decimalNumber = decimalNumber / 8;
                message = temp + message;
            }
            show.setText( "\nDecimal : " + editNumber.getText().toString() + "\nOctal : " + message);
            message = "";
        }

        else if(hexRadio.isChecked()){
            int temp ;
            char[] hexChar = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            while(decimalNumber > 0) {
                temp = decimalNumber % 16;
                decimalNumber = decimalNumber / 16;
                message = hexChar[temp] + message;
            }
            show.setText( "\nDecimal : " + editNumber.getText().toString() + "\nHexa : " + message);
            message = "";
        }
    }
}