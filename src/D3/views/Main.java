package D3.views;

import D3.controllers.Bank;
import D3.models.Tax;
import D3.models.Account;
import D3.models.Client;


import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
	    Bank bk = new Bank();
        Scanner sc = new Scanner(System.in);
	    System.out.println("Banking system V1.0\n");


        while(true){
            System.out.print("Insert a Command (0 to finish): ");
            String comm = sc.nextLine();
           // String[] comm2 = comm.split(" ", 8);

            switch (comm){
                case "RC":
                    commandRC(bk, sc);
                    break;

                case "AC":
                    commandAC(bk, sc);
                    break;

                case "NC":
                    commandNC(bk, sc);
                    break;

                case "M":
                    commandM(bk, sc);
                    break;

                case "SC":
                    commandSC(bk, sc);
                    break;

                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Command entered was not recognized.\n");

            }

        }

    }

    static void commandRC(Bank bk, Scanner sc) {
        //inserir nome
        System.out.print("Insert the name: ");
        String name = sc.nextLine();

        //inserir data de nascimento
        System.out.print("\nInsert the birth date (yyyy/mm/dd):  ");
        String birthDayString = sc.next();
        int year, month, day;
        year = Integer.parseInt(birthDayString.substring(0, 3));
        month = Integer.parseInt(birthDayString.substring(5, 6));
        day = Integer.parseInt(birthDayString.substring(8, 9));
        Date birthDay = new Date(year, month, day);
        //DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //birthDay = sdf.parse(sc.next());

        //inserir documento


        System.out.println("\nInsert documents ");


        //tipo do documento
        System.out.print("Type of the document (C-Citizen Card or P-Passport): ");
        char typeDocument = sc.next().charAt(0);

        while(typeDocument != 'C' && typeDocument != 'P') {
            System.out.println("\nType of document was not recognized.\nIt is only allowed C-Citizen Card or P-Passport.  ");
            System.out.print("Insert again the document type allowed: ");
            typeDocument = sc.next().charAt(0);
        }


        //numero do documento
        System.out.print("\nDocument number: ");
        String numberDocument = sc.next();
        while(bk.document_existent(numberDocument)){
            System.out.println("\nDocument number already registered. ");
            System.out.print("Insert another document number: ");
            numberDocument = sc.next();
        }
        //inserir email
        System.out.print("\nInsert Email: ");
        String email = sc.next();

        //inserir contacto
        System.out.print("\nInsert phone number: ");
        int phoneNumber = sc.nextInt();

        //inserir endereço
        System.out.println("\nInsert address ");

        System.out.print("Street: ");
        String street = sc.next(); sc.nextLine();

        System.out.print("Postal Code: ");
        String postalCode = sc.next(); sc.nextLine();

        System.out.print("City: ");
        String city = sc.next(); sc.nextLine();

        System.out.print("Country: ");
        String country = sc.next();


        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        System.out.println("\nClient added successfully!\n");
    }
    static void commandAC(Bank bk, Scanner sc){
        System.out.print("Insert the document number:");
        String numberDocument = sc.next();

        while(!bk.document_existent(numberDocument)) {
            System.out.println("\nDocument number inserted is not registered. ");
            System.out.print("Insert another document number: ");
            numberDocument = sc.next();

        }
        System.out.println("\n\nChange Client data");
        System.out.println(bk.data_client(numberDocument));
        System.out.print("Insert the number of the data you want to change: ");
        int opcao = sc.nextInt();
        switch(opcao){
            case 1:
                System.out.print("New name: ");
                String name = sc.next();
                bk.alter_client_name(numberDocument,name);
                System.out.print("The name was changed successfully!");

                break;
            case 2:
                System.out.print("New Birth Date: ");
                String birthDayString = sc.next();
                int year, month, day;
                year = Integer.parseInt(birthDayString.substring(0, 3));
                month = Integer.parseInt(birthDayString.substring(5, 6));
                day = Integer.parseInt(birthDayString.substring(8, 9));
                Date birthDay = new Date(year, month, day);
                bk.alter_client_birthDay(numberDocument, birthDay);
                System.out.print("The birth date was changed successfully!");

                break;
            case 3:
                System.out.print("New Email: ");
                String email = sc.next();
                bk.alter_client_email(numberDocument,email);
                System.out.print("The Email was changed successfully!");
                break;
            case 4:
                System.out.print("New phone number: ");
                int phoneNumber = sc.nextInt();
                bk.alter_client_phoneNumber(numberDocument,phoneNumber);
                System.out.print("The phone number was changed successfully!");
                break;
            case 5:
                System.out.println("New Address ");
                System.out.print("Street: ");
                String street = sc.next();
                System.out.print("Postal Code: ");
                String postalCode = sc.next();
                System.out.print("City: ");
                String city = sc.next();
                System.out.print("country: ");
                String country = sc.next();

                bk.alter_client_address(numberDocument,street, postalCode, city, country);
                System.out.print("The address was changed successfully!");
                break;
        }

    }
    static void commandNC(Bank bk, Scanner sc){
        List<String> numberDocumentOthers = new LinkedList<String>();
        char choice;
        double value;
        //inserir cliente principal da conta
        System.out.print("Insert the document number of the main client of the account to be created:");
        String numberDocumentMain = sc.next();

        while(!bk.document_existent(numberDocumentMain)) {
            System.out.println("\nThe number of the inserted document is not registered. ");
            System.out.print("Insert another document number: ");
            numberDocumentMain = sc.next();

        }
        //inserir clientes secundários na conta
        do{
            System.out.print("Do you wish to associate more clients to the account (S ou N)? ");
            choice = sc.next().charAt(0);
            if (choice == 'S'){
                System.out.print("Insert the document number of the associated client of the account to be created:");
                String numberOther = sc.next();
                while(!bk.document_existent(numberDocumentMain)) {
                    System.out.println("\nThe number of the inserted document is not registered. ");
                    System.out.print("Insert another document number: ");
                    numberOther = sc.next();
                }
                numberDocumentOthers.add(numberOther);

            }
        }while(choice == 'S');

        //depósito inicial
        System.out.print("Do you wish to make a first deposit (S ou N)? ");
        choice = sc.next().charAt(0);
        if (choice == 'S'){
            System.out.print("Insert the value of the first deposit: ");
            value = sc.nextDouble();
        }else{
            value=0;
        }
        System.out.println("The account was created successfully, with the following account code: " + bk.add_account(numberDocumentMain, numberDocumentOthers, value));

    }
    static void commandM(Bank bk, Scanner sc){
        System.out.print("Do you know the account number (S ou N)? ");
        char choice = sc.next().charAt(0);
        if (choice == 'S'){
            System.out.print("Account number: ");
            long accId = sc.nextLong();
            while(!bk.account_existent(accId)) {
                System.out.println("\nThe account number inserted does not correspond to any already account created. ");
                System.out.print("Insert another document number: ");
                accId = sc.nextLong();

            }

            //escolher o tipo de movimento
            System.out.print("Do you wish to make a Debit (D) or a Credit (C)? ");
            char choice2 = sc.next().charAt(0);

            System.out.print("Insert the value of the movement: ");
            double value = sc.nextDouble();

            switch (choice2){
                case 'D':
                    if(bk.debit_account(accId, value)) {
                        System.out.println("The movement was successfully executed!");
                    }else{
                        System.out.println("The movement was not executed!");
                    }
                    break;
                case 'C':
                    bk.credit_account(accId, value);
                    System.out.println("The movement was successfully executed!");
                    break;
            }

        }else{ //caso não saiba o numero da conta, vai inserir o cliente e procurar as contas associadas ao cliente
            System.out.print("\nInsert the document number associated with your account: ");
            String numberDocument = sc.next();

            while(!bk.document_existent(numberDocument)) {
                System.out.println("\nThe number of the inserted document is not registered. ");
                System.out.print("Insert another document number: ");
                numberDocument = sc.next();
            }
            //idAccounts tem todos os ids das contas associadas ao cliente
            List<Long> idAccounts = bk.idAccounts_Client(numberDocument);
            if(idAccounts.size() == 0){
                System.out.println("The client does not have associated accounts.");
            }else{
                System.out.println("The account IDs associated with the client are as follows:");
                for(int i=0; i<idAccounts.size(); i++){
                    System.out.println("\t" + (i+1) + ") " + idAccounts.get(i));
                }
                System.out.println("Insert the account number you wish to check the balance: ");
                int number = sc.nextInt();

                //escolher o tipo de movimento
                System.out.print("Do you wish to make a Debit (D) or a Credit (C)? ");
                char choice2 = sc.next().charAt(0);

                System.out.print("Insert the value of the movement: ");
                double value = sc.nextDouble();

                switch (choice2){
                    case 'D':
                        if(bk.debit_account(number, value)) {
                            System.out.println("The movement was successfully executed!");
                        }else{
                            System.out.println("The movement was not executed!");
                        }
                        break;
                    case 'C':
                        bk.credit_account(number, value);
                        System.out.println("The movement was successfully executed!");
                        break;
                }

            }
        }
    }
    static void commandSC(Bank bk, Scanner sc){
        System.out.print("Do you know the account number (S ou N)? ");
        char choice = sc.next().charAt(0);
        if (choice == 'S'){
            System.out.print("Account number: ");
            long accId = sc.nextLong();
            while(!bk.account_existent(accId)) {
                System.out.println("\nThe number of the inserted document is not registered. ");
                System.out.print("Insert another document number: ");
                accId = sc.nextLong();

            }
            //verifica o saldo da conta
            System.out.println("\nThe account balance " + accId + ": " + bk.balance_account(accId));

        }else{ //caso não saiba o numero da conta, vai inserir o cliente e procurar as contas associadas ao cliente
            System.out.print("\nInsert the document number associated with your account: ");
            String numberDocument = sc.next();

            while(!bk.document_existent(numberDocument)) {
                System.out.println("\nThe number of the inserted document is not registered. ");
                System.out.print("Insert another document number: ");
                numberDocument = sc.next();
            }
            //idAccounts tem todos os ids das contas associadas ao cliente
            List<Long> idAccounts = bk.idAccounts_Client(numberDocument);
            if(idAccounts.size() == 0){
                System.out.println("The client does not have associated accounts.");
            }else{
                System.out.println("The account IDs associated with the client are as follows:");
                for(int i=0; i<idAccounts.size(); i++){
                    System.out.println("\t" + (i+1) + ") " + idAccounts.get(i));
                }
                System.out.println("Insert the account number you wish to check the balance: ");
                int number = sc.nextInt();

                //verifica o saldo da conta
                System.out.println("\nThe account balance " + idAccounts.get(number-1) + ": " + bk.balance_account(idAccounts.get(number-1)));


            }
        }
    }
}
