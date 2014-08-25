package com.example.BuildingManager.k.domain;

/**
 * Created by nkosi on 2014/08/24.
 */
public class Manager {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;

    private Manager() {}

    public Manager(Builder builder)
    {
        id = builder.id;
        name = builder.name;
        surname = builder.surname;
        email = builder.email;
        phoneNumber = builder.phoneNumber;
    }

    public static class Builder{
        private int id;
        private String name;
        private String surname;
        private String email;
        private String phoneNumber;

        public Builder(String name){
            this.name = name;
        }

        public Builder id( int value )
        {
            id = value;
            return this;
        }

        public Builder surname(String val)
        {
            surname = val;
            return this;
        }

        public Builder email(String val)
        {
            email = val;
            return this;
        }

        public Builder phoneNumber(String val)
        {
            phoneNumber = val;
            return this;
        }

        public Manager build() {return new Manager(this);}
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
