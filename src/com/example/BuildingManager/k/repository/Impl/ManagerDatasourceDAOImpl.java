package com.example.BuildingManager.k.repository.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.BuildingManager.k.conf.DBAdapter;
import com.example.BuildingManager.k.domain.Manager;
import com.example.BuildingManager.k.repository.ManagerDatasourceDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkosi on 2014/08/24.
 */
public class ManagerDatasourceDAOImpl implements ManagerDatasourceDAO {

    private SQLiteDatabase db;
    private DBAdapter dbhelper;

    public ManagerDatasourceDAOImpl(Context context)
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
    public void createManager(Manager buildingManager)
    {
        try
        {
            open();
            ContentValues values = new ContentValues();
            values.put(DBAdapter.COLUMN_NAME, buildingManager.getName());
            values.put(DBAdapter.COLUMN_SURNAME, buildingManager.getSurname());
            values.put(DBAdapter.COLUMN_EMAIL, buildingManager.getEmail());
            values.put(DBAdapter.COLUMN_CELL, buildingManager.getPhoneNumber());

            db.insert(DBAdapter.TABLE_STUDENTS, null, values );
            close();
        }catch(SQLException e)
        {
            System.out.println( "Helper error" + e.getStackTrace() );
        }
    }


    @Override
    public void updateManager(Manager buildingManager) {

    }

    @Override
    public Manager findManagerById(int id) {
        return null;
    }

    @Override
    public void deleteManager(Manager buildingManager) {

    }

    @Override
    public Manager getManager() {
        Manager buildingManager = new Manager.Builder(" ").surname(" ").email(" ").phoneNumber(" ").build();
        try {
            String selectQuery = "SELECT  * FROM " + DBAdapter.TABLE_STUDENTS;


            open();
            Cursor c = db.rawQuery(selectQuery, null);

            if (c.moveToFirst()) {
                do {
                    buildingManager = new Manager.Builder(c.getString(1))
                            .surname(c.getString(2))
                            .email(c.getString(3))
                            .phoneNumber(c.getString(4))
                            .id(c.getInt(0))
                            .build();

                } while (c.moveToNext());


            }

        } catch (SQLException e) {
            e.getStackTrace();
        }
        close();
        return buildingManager;
    }

    @Override
    public List<Manager> getManagerList() {
        List<Manager> managers = new ArrayList<Manager>();

        try {
            String selectQuery = "SELECT * FROM " + DBAdapter.TABLE_STUDENTS;

            open();
            Cursor c = db.rawQuery(selectQuery, null);

            if( c.moveToFirst()) {
                do {
                    Manager man = new Manager.Builder(c.getString(1))
                            .id(c.getInt(0))
                            .surname(c.getString(2))
                            .phoneNumber(c.getString(4))
                            .email(c.getString(3))
                            .build();
                    managers.add(man);
                } while (c.moveToNext());

            }

        }
        catch(SQLException e)
        {
            e.getStackTrace();
        }
        close();



        return managers;
    }

}

