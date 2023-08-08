package com.ozgurokan.fatura.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "process_date")
    private String processDate;

    @Column(name = "bill_type")
    private String billType;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "status")
    private String status;


    // constructors
    public Bill() {

    }

    public Bill(int amount, String processDate, String billType, String accountId, String status) {
        this.amount = amount;
        this.processDate = processDate;
        this.billType = billType;
        this.accountId = accountId;
        this.status = status;
    }

    //getter-setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                ", processDate='" + processDate + '\'' +
                ", billType='" + billType + '\'' +
                ", accountId='" + accountId + '\'' +
                ", status='" + status + '\''+
                '}';
    }
}
