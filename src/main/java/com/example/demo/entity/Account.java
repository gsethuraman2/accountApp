package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

//@Entity(name = "Account_Table")
@Entity
//@IdClass(AccountId.class)
public class Account {
    // account - table - name and bean name (if no name specified for entity)

    // if explicitly table name has been specified using name parameter in @Entity
    // account - bean name
    // Account_Table - table name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    // account_id

    //@Id
    //@Column(unique = true)
    private String aadhar;

    // account_name - Column name in database
    private String accountName;

    @Transient  // this field will be ignored from saving in database
    // initial_amount - Column name in database
    private BigInteger initialAmount;



    // default varchar - 255
    // max 65556 4kb
    // long text 4gb
    // account_holder_name - Column name in database
    @Column(length = 500)
    private String accountHolderName;

    // created_timestamp - Column name in database
    private LocalDateTime createdTimestamp;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getID() {
        return ID;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public BigInteger getInitialAmount() {
        return initialAmount;
    }

    public String getAadhar() {
        return aadhar;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setInitialAmount(BigInteger initialAmount) {
        this.initialAmount = initialAmount;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", accountName='" + accountName + '\'' +
                ", initialAmount=" + initialAmount +
                ", aadhar='" + aadhar + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", user=" + user +
                '}';
    }
}
