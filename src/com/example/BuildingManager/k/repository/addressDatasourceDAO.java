package com.example.BuildingManager.k.repository;

import com.example.BuildingManager.k.domain.Address;

import java.util.List;

/**
 * Created by nkosi on 2014/08/24.
 */
public interface addressDatasourceDAO {
    public void createAddress(Address address);
    public void updateAddress(Address address);
    public Address findStudentById(int id);
    public void deleteStudent(Address address);
    public Address getAddress();
    public List<Address> getAddressList();
}
