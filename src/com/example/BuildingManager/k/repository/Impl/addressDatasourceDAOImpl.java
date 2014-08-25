package com.example.BuildingManager.k.repository.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.BuildingManager.k.conf.DBAdapter;
import com.example.BuildingManager.k.domain.Address;
import com.example.BuildingManager.k.repository.addressDatasourceDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2014/08/24.
 */
public class addressDatasourceDAOImpl implements addressDatasourceDAO {

    private SQLiteDatabase db;
    private DBAdapter dbhelper;

    public addressDatasourceDAOImpl(Context context)
    {
        dbhelper = new DBAdapter(context);
    }

    public void open() throws SQLException
    {
        db = dbhelper.getWritableDatabase();
    }

    public void close()
    {
        dbhelper.close();
    }

    @Override
    public void createAddress(Address address) {
        try
        {
            open();
            ContentValues values = new ContentValues();
            values.put(DBAdapter.COLUMN_STREET_NO, address.getStreet_number());
            values.put(DBAdapter.COLUMN_STREET_NAME, address.getStreetName());
            values.put(DBAdapter.COLUMN_TOWN, address.getTown());
            values.put(DBAdapter.COLUMN_POSTAL_CODE, address.getPostal_code());

            db.insert(DBAdapter.TABLE_ADDRESS, null, values );
            close();
        }catch(SQLException e)
        {
            System.out.println( "Helper error" + e.getStackTrace() );
        }
    }

    @Override
    public void updateAddress(Address address) {

    }

    @Override
    public Address findStudentById(int id) {
        return null;
    }

    @Override
    public void deleteStudent(Address address) {

    }

    @Override
    public Address getAddress() {
        Address address = new Address.Builder(" ").streetName(" ").town(" ").postal_code(" ").build();
        try {
            String selectQuery = "SELECT  * FROM " + DBAdapter.TABLE_ADDRESS;


            open();
            Cursor c = db.rawQuery(selectQuery, null);

            if (c.moveToFirst()) {
                do {
                    address = new Address.Builder(c.getString(1))
                            .streetName(c.getString(2))
                            .town(c.getString(3))
                            .postal_code(c.getString(4))
                            .id(c.getInt(0))
                            .build();


                } while (c.moveToNext());


            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        close();
        return address;
    }

    @Override
    public List<Address> getAddressList() {
        List<Address> studs = new ArrayList<Address>();




        try {
            String selectQuery = "SELECT * FROM " + DBAdapter.TABLE_ADDRESS;

            open();
            Cursor c = db.rawQuery(selectQuery, null);

            if( c.moveToFirst()) {
                do {
                    Address stad = new Address.Builder(c.getString(1))
                            .id(c.getInt(0))
                            .postal_code(c.getString(2))
                            .streetName(c.getString(4))
                            .town(c.getString(3))
                            .build();
                    studs.add(stad);
                } while (c.moveToNext());

            }

        }
        catch(SQLException e)
        {
            e.getStackTrace();
        }
        close();



        return studs;
    }

}
