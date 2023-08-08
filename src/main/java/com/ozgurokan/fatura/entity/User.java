package com.ozgurokan.fatura.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "accounts")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;


    @Column(name = "code")
    private String code;


    @Column(name = "balance")
    private int balance;


    // constructors
    public User(){

    }

    public User(String firstName, String lastName,String code,int balance){
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.balance = balance;

    }


    // getter-setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", code='" + code + '\'' +
                ", balance=" + balance +
                '}';
    }
}
