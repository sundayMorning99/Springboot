package org.launchcode.Fund.models;

import jakarta.validation.Valid;
import jakarta.persistence.Entity;
import jakarta.validation.NotBlank;
import jakarta.validation.Size;

@Entity
public class AssetClass extends AbstractEntity {

    @Size(max=100, message="Asset class must be less than 100 characters long")
    private String name;

    @OneToMany(mappedBy="assetClass")
    private final List<Fund> funds = new ArrayList<>();

    public AssetClass(@Size(max=100, message="Asset Class must be less than 100 character long")){
        this.name=name;
    }


    public AssetClass(){}


    //getter and setter for name. And only getter for List.
    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public List<Fund> getFund(){return funds;}

    @Override
    public String toString(){return name;}
}
