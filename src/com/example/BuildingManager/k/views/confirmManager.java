package com.example.BuildingManager.k.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.BuildingManager.R;
import com.example.BuildingManager.k.domain.Address;
import com.example.BuildingManager.k.domain.Manager;
import com.example.BuildingManager.k.repository.Impl.ManagerDatasourceDAOImpl;
import com.example.BuildingManager.k.repository.Impl.addressDatasourceDAOImpl;
import com.example.BuildingManager.k.repository.ManagerDatasourceDAO;
import com.example.BuildingManager.k.repository.addressDatasourceDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2014/08/24.
 */
public class confirmManager extends Activity {
    TextView txtname;
    Button btndisp;
    TextView lbldisp;
    List<Manager> ManagerList = new ArrayList<Manager>();
    List<Address> addList = new ArrayList<Address>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutconfirm);

        final ManagerDatasourceDAO daoa = new ManagerDatasourceDAOImpl(this);
        final addressDatasourceDAO daob = new addressDatasourceDAOImpl(this);

        String[] info = new String[10];

        Manager man = new Manager.Builder(" ").surname(" ").email(" ").phoneNumber(" ").build();
        Address address = new Address.Builder(" ").streetName(" ").town(" ").postal_code(" ").build();

        Bundle intent = getIntent().getExtras();
        if( intent != null ) {
            info = intent.getStringArray("things");

        }
        else
        {
            Toast.makeText(getApplicationContext(), "Fail!", Toast.LENGTH_SHORT).show();
        }

        txtname = (TextView) findViewById(R.id.lblName);
        txtname.setText(info[0]);


        man = new Manager.Builder(info[0]).surname(info[1]).email(info[2]).phoneNumber(info[3]).build();
        address = new Address.Builder(info[4]).streetName(info[5]).town(info[6]).postal_code(info[7]).build();


        daoa.createManager(man);
        daob.createAddress(address);

        ManagerList = daoa.getManagerList();
        addList = daob.getAddressList();



    }
}