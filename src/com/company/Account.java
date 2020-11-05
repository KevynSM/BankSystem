package com.company;

import java.sql.Date;
import java.text.SimpleDateFormat;
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

    public void credit(float value) {
        Tax tax = new Tax();
        this.accBalance = this.accBalance + value - tax.getValue();
        this.accMovements.add(new AccMovement((String)actual_date(), value, tax, 'c'));
    }

    public void debit(float value, double taxe) {
        if(this.accBalance - value >= 0){
            this.accBalance = this.accBalance - value - taxe;
            this.accMovements.add(new AccMovement((String)actual_date(), value, taxe, 'd'));
        }else {

        }
    }

    private String actual_date() {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatarDate.format(data);
    }



}