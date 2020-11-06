package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
	    Tax tax = new Tax();
	    List<Account> accounts = new LinkedList<Account>();
	    List<Client> clients = new LinkedList<Client>();
	    Boolean stop = true;
        Scanner sc = new Scanner(System.in);
	    System.out.println("Sistema Bancário V1.0\n");


        while(stop){
            System.out.print("Insira um Comando: ");
            String comm = sc.next();
           // String[] comm2 = comm.split(" ", 8);

            switch (comm){
                case "RC":
                    commandRC(accounts, clients, tax);
                    break;

                case "AC":
                    commandAC(accounts, clients, tax);
                    break;

                case "NC":
                    commandNC(accounts, clients, tax);
                    break;

                case "M":
                    commandM(accounts, clients, tax);
                    break;

                case "SC":
                    commandSC(accounts, clients, tax);
                    break;

                case "":
                    stop = false;
                    //System.exit(0);
                    break;
                default:
                    System.out.println("Comando inserido não foi reconhecido.");

            }

        }

    }

    static void commandRC(List<Account> accounts, List<Client> clients, Tax tax) throws ParseException {


    }
    static void commandAC(List<Account> accounts, List<Client> clients, Tax tax){

    }
    static void commandNC(List<Account> accounts, List<Client> clients, Tax tax){

    }
    static void commandM(List<Account> accounts, List<Client> clients, Tax tax){

    }
    static void commandSC(List<Account> accounts, List<Client> clients, Tax tax){

    }
}
