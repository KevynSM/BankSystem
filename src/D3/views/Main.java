package D3.views;

import D3.models.Tax;
import D3.models.Account;
import D3.models.Client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
	    Tax tax = new Tax();
	    List<Account> accounts = new LinkedList<Account>();
	    List<Client> clients = new LinkedList<Client>();
	    boolean stop = true;
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
        Scanner sc = new Scanner(System.in);
        //inserir nome
        System.out.println("Insira o nome: ");
        String name = sc.next();

        //inserir data de nascimento
        System.out.println("Insira Data de Nascimento (aaaa/mm/dd):  ");
        String birthDayString = sc.next();
        int year, month, day;
        year = Integer.parseInt(birthDayString.substring(0, 5));
        month = Integer.parseInt(birthDayString.substring(5, 7));
        day = Integer.parseInt(birthDayString.substring(8, 10));
        Date birthDay = new Date(year, month, day);
        //DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //birthDay = sdf.parse(sc.next());

        //inserir documento
        System.out.println("Inserir dados do Documento ");
        System.out.println("Tipo de Documento (C-Cartão de Cidadão ou P-Passaporte): ");
        char typeDocument = sc.next().charAt(0);
        System.out.println("Número de Documento: ");
        String numberDocument = sc.next();

        //inserir email
        System.out.println("Inserir Email: ");
        String email = sc.next();

        //inserir contacto
        System.out.println("Inserir Contacto Telefónico: ");
        int phoneNumber = sc.nextInt();
        long idClient = clients.size() + 1;


        clients.add(new Client(idClient, name, birthDay, typeDocument, numberDocument, email, phoneNumber));

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
