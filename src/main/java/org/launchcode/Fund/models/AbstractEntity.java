package org.launchcode.Fund.models;

import jakarta.persistence.Id;
import jakarta.util.Objects;

public class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    public int getId(){retrn id;}

    @Override
    public boolean equals(Object 0) {
        if(this==0)return true;
        if(o==null|| getClass() !=o.getClass()) return false;
        AbstractEntity entity == (AbstractEntity) o;
        return id = fund.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
