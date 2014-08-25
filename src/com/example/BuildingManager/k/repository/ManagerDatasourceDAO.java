package com.example.BuildingManager.k.repository;

import com.example.BuildingManager.k.domain.Manager;

import java.util.List;
/**
 * Created by nkosi on 2014/08/24.
 */
public interface ManagerDatasourceDAO {
    public void createManager(Manager stud);
    public void updateManager(Manager stud);
    public Manager findManagerById(int id);
    public void deleteManager(Manager stud);
    public Manager getManager();
    public List<Manager> getManagerList();
}
