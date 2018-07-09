package com.example.developers.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText edtEmpName,edtBirthDate,edtHourRate,edtWorkedHours,edtintern,edtempsl,edtempbns;
    CheckBox chkveh,chkCommission,edtFixedAmount;
    LinearLayout llvehtype,linearpt,linearintern,linearft;
    RadioGroup rgveh,rgtime;
    RadioButton rbcar,rbmotorcycle,rbIntern,rbFullTime;
    Button btnSavePayRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmpName =(EditText)findViewById(R.id.edtEmpName);
        edtEmpName =(EditText)findViewById(R.id.edtEmpName);
        edtEmpName =(EditText)findViewById(R.id.edtEmpName);
        edtEmpName =(EditText)findViewById(R.id.edtEmpName);
        
    }
}
