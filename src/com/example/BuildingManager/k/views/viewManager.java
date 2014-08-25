package com.example.BuildingManager.k.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
public class viewManager extends Activity {
    List<Manager> ManagerList = new ArrayList<Manager>();
    List<Address> addList = new ArrayList<Address>();
    Button btndisp;
    final ManagerDatasourceDAO daoa = new ManagerDatasourceDAOImpl(this);
    final addressDatasourceDAO daob = new addressDatasourceDAOImpl(this);
    TextView lbldisp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutviewmanager);
        btndisp = (Button) findViewById(R.id.btnView);
        lbldisp = (TextView) findViewById(R.id.lblName);

        btndisp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.btnView :

                        ManagerList = daoa.getManagerList();
                        addList = daob.getAddressList();
                        lbldisp.setText("");
                }
            }
        });
    }
}