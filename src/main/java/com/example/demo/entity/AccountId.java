package com.example.demo.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AccountId implements Serializable {

    private Long ID;
    private String aadhar;

 // private String accountName;    can have more than one composite key

    // Default constructor
    public AccountId() {
    }

    // Parameterized constructor
    public AccountId(Long ID, String aadhar) {
        this.ID = ID;
        this.aadhar = aadhar;
    }

    // Getters and Setters
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return Objects.equals(ID, accountId.ID) && Objects.equals(aadhar, accountId.aadhar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, aadhar);
    }
}
