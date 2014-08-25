package com.example.BuildingManager.k.domain;

/**
 * Created by nkosi on 2014/08/24.
 */
public class Address {
    private int id;
    private String streetNum;
    private String streetName;
    private String town;
    private String postal_code;

    private Address()
    {}

    private Address( Builder builder )
    {
        id = builder.id;
        streetNum = builder.streetNum;
        streetName = builder.streetName;
        town = builder.town;
        postal_code = builder.postal_code;
    }

    public static class Builder
    {
        private int id;
        private String streetNum;
        private String streetName;
        private String town;
        private String postal_code;

        public Builder( String street_number )
        {
            this.streetNum = street_number;

        }

        public Builder id( int value )
        {
            id = value;
            return this;
        }

        public Builder streetName( String value )
        {
            streetName = value;
            return this;
        }

        public Builder town( String value )
        {
            town = value;
            return this;
        }

        public Builder postal_code( String value )
        {
            postal_code = value;
            return this;
        }

        public Address build()
        {
            return new Address(this);
        }

    }

    public int getId() {
        return id;
    }

    public String getStreet_number() {
        return streetNum;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getTown() {
        return town;
    }

    public String getPostal_code() {
        return postal_code;
    }
}
