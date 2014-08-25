package com.example.BuildingManager.k.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.BuildingManager.R;

/**
 * Created by nkosi on 2014/08/24.
 */
public class main extends Activity {

    EditText name;
    EditText surname;
    EditText email;
    EditText phoneNumber;
    EditText streetNum;
    EditText streetName;
    EditText town;
    EditText postalCode;
    Button btnSave;// = (Button) findViewById(R.id.btnSave);

    String[] info = new String[10];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        name = (EditText) findViewById(R.id.txtName);
        surname = (EditText) findViewById(R.id.txtSurname);
        email = (EditText) findViewById(R.id.txtemail);
        phoneNumber = (EditText) findViewById(R.id.txtPhoneNumber);
        streetNum = (EditText) findViewById(R.id.txtStreetNum);
        streetName = (EditText) findViewById(R.id.txtStreetName);
        town = (EditText) findViewById(R.id.txtTown);
        postalCode = (EditText) findViewById(R.id.txtPostalCode);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.btnSave :
                        info[0] = name.getText().toString();
                        info[1] = surname.getText().toString();
                        info[2] = email.getText().toString();
                        info[3] = phoneNumber.getText().toString();
                        info[4] = streetNum.getText().toString();
                        info[5] = streetName.getText().toString();
                        info[6] = town.getText().toString();
                        info[7] = postalCode.getText().toString();

                        Intent intent = new Intent("com.example.BuildingManager.k.views.CONFIRMMANAGER");
                        intent.putExtra( "things", info );
                        startActivity(intent);
                }
            }
        });
    }
}