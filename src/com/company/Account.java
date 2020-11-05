package com.company;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class Account {
    private long accId;
    private Client mainClient;
    private List<Client> otherClients;
    private double accBalance;
    private List<AccMovement> accMovements;

    public Account(long accId, Client mainClient) {
        this.accId = accId;
        this.mainClient = mainClient;
        this.otherClients =  new LinkedList<Client>();
        this.accMovements = new LinkedList<AccMovement>();
    }

    public long getAccId() {
        return this.accId;
    }

    public void setMainClient(Client mainClient) {
        this.mainClient = mainClient;
    }

    public Client getMainClient() {
        return mainClient;
    }

    public void addOtherClients(Client otherClient) {
        this.otherClients.add(otherClient);
    }

    public void removeOtherClients(Client otherClient) {
        this.otherClients.remove(otherClient);
    }

    public List<Client> getOtherClients() {
        return this.otherClients;
    }

    public List<AccMovement> getAccMovements() {
        return this.accMovements;
    }

    public void addAccMovements(AccMovement accMovement) {
        this.accMovements.add(accMovement);
    }

    public double getAccBalance() {
        return this.accBalance;
    }

    public void credit(double value) {
        Tax tax = new Tax();
        this.accBalance = this.accBalance + value - tax.getValue();
        this.accMovements.add(new AccMovement(actual_date(), value, tax.getValue(), 'c'));
    }

    public void debit(double value) {
        if(this.accBalance - value >= 0){
            Tax tax = new Tax();
            this.accBalance = this.accBalance - value - tax.getValue();
            this.accMovements.add(new AccMovement(actual_date(), value, tax.getValue(), 'd'));
        }
    }

    private String actual_date() {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatDate.format(data);
    }



}