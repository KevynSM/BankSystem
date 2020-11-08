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
	    System.out.println("Sistema Bancário V1.0\n");


        while(true){
            System.out.print("Insira um Comando (0 para terminar): ");
            String comm = sc.next();
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
                    System.out.println("Comando inserido não foi reconhecido.\n");

            }

        }

    }

    static void commandRC(Bank bk, Scanner sc) {
        //inserir nome
        System.out.print("Insira o nome: ");
        String name = sc.next();

        //inserir data de nascimento
        System.out.print("\nInsira Data de Nascimento (aaaa/mm/dd):  ");
        String birthDayString = sc.next();
        int year, month, day;
        year = Integer.parseInt(birthDayString.substring(0, 3));
        month = Integer.parseInt(birthDayString.substring(5, 6));
        day = Integer.parseInt(birthDayString.substring(8, 9));
        Date birthDay = new Date(year, month, day);
        //DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        //birthDay = sdf.parse(sc.next());

        //inserir documento


        System.out.println("\nInserir dados do Documento ");


        //tipo do documento
        System.out.print("Tipo de Documento (C-Cartão de Cidadão ou P-Passaporte): ");
        char typeDocument = sc.next().charAt(0);

        while(typeDocument != 'C' && typeDocument != 'P') {
            System.out.println("\nTipo de Documento não aceite.\nApenas é aceite C-Cartão de Cidadão ou P-Passaporte.  ");
            System.out.print("Insira outra vez o Tipo de Documente aceite: ");
            typeDocument = sc.next().charAt(0);
        }


        //numero do documento
        System.out.print("\nNúmero de Documento: ");
        String numberDocument = sc.next();
        while(bk.document_existent(numberDocument)){
            System.out.println("\nNúmero de Documento já registado. ");
            System.out.print("Insira outro Número de Documento: ");
            numberDocument = sc.next();
        }
        //inserir email
        System.out.print("\nInserir Email: ");
        String email = sc.next();

        //inserir contacto
        System.out.print("\nInserir Contacto Telefónico: ");
        int phoneNumber = sc.nextInt();

        //inserir endereço
        System.out.println("\nInserir Endereço ");

        System.out.print("Street: ");
        String street = sc.next(); sc.nextLine();

        System.out.print("Postal Code: ");
        String postalCode = sc.next(); sc.nextLine();

        System.out.print("City: ");
        String city = sc.next(); sc.nextLine();

        System.out.print("Country: ");
        String country = sc.next();


        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber, street, postalCode, city, country);
        System.out.println("\nCliente Adicionado com sucesso!\n");
    }
    static void commandAC(Bank bk, Scanner sc){
        System.out.print("Insira o número do documento:");
        String numberDocument = sc.next();

        while(!bk.document_existent(numberDocument)) {
            System.out.println("\nNúmero de Documento inserido não está registado. ");
            System.out.print("Insira outro Número de Documento: ");
            numberDocument = sc.next();

        }
        System.out.println("\n\nAlteração dos dados do Cliente");
        System.out.println(bk.data_client(numberDocument));
        System.out.print("Insira o número do dado que quer alterar: ");
        int opcao = sc.nextInt();
        switch(opcao){
            case 1:
                System.out.print("Novo Nome: ");
                String name = sc.next();
                bk.alter_client_name(numberDocument,name);
                System.out.print("O Nome foi alterado com Sucesso!");

                break;
            case 2:
                System.out.print("Nova Datebirth: ");
                String birthDayString = sc.next();
                int year, month, day;
                year = Integer.parseInt(birthDayString.substring(0, 3));
                month = Integer.parseInt(birthDayString.substring(5, 6));
                day = Integer.parseInt(birthDayString.substring(8, 9));
                Date birthDay = new Date(year, month, day);
                bk.alter_client_birthDay(numberDocument, birthDay);
                System.out.print("A Data de Nascimento foi alterada com Sucesso!");

                break;
            case 3:
                System.out.print("Novo Email: ");
                String email = sc.next();
                bk.alter_client_email(numberDocument,email);
                System.out.print("O Email foi alterado com Sucesso!");
                break;
            case 4:
                System.out.print("Novo Contacto Telefónico: ");
                int phoneNumber = sc.nextInt();
                bk.alter_client_phoneNumber(numberDocument,phoneNumber);
                System.out.print("O Contacto Telefónico foi alterado com Sucesso!");
                break;
            case 5:
                System.out.println("Novo Endereço ");
                System.out.print("Street: ");
                String street = sc.next();
                System.out.print("Postal Code: ");
                String postalCode = sc.next();
                System.out.print("City: ");
                String city = sc.next();
                System.out.print("country: ");
                String country = sc.next();

                bk.alter_client_address(numberDocument,street, postalCode, city, country);
                System.out.print("O Endereço foi alterado com Sucesso!");
                break;
        }

    }
    static void commandNC(Bank bk, Scanner sc){
        List<String> numberDocumentOthers = new LinkedList<String>();
        char choice;
        double value;
        //inserir cliente principal da conta
        System.out.print("Insira o número do documento do Cliente Principal da Conta a ser criada:");
        String numberDocumentMain = sc.next();

        while(!bk.document_existent(numberDocumentMain)) {
            System.out.println("\nNúmero de Documento inserido não está registado. ");
            System.out.print("Insira outro Número de Documento: ");
            numberDocumentMain = sc.next();

        }
        //inserir clientes secundários na conta
        do{
            System.out.print("Quer associar mais clientes à conta (S ou N)? ");
            choice = sc.next().charAt(0);
            if (choice == 'S'){
                System.out.print("Insira o número do documento do Cliente Principal da Conta a ser criada:");
                String numberOther = sc.next();
                while(!bk.document_existent(numberDocumentMain)) {
                    System.out.println("\nNúmero de Documento inserido não está registado. ");
                    System.out.print("Insira outro Número de Documento: ");
                    numberOther = sc.next();
                }
                numberDocumentOthers.add(numberOther);

            }
        }while(choice == 'S');

        //depósito inicial
        System.out.print("Pretende fazer um depósito inicial (S ou N)? ");
        choice = sc.next().charAt(0);
        if (choice == 'S'){
            System.out.print("Insira o valor do depósito inicial: ");
            value = sc.nextDouble();
        }else{
            value=0;
        }
        System.out.println("A conta foi criada com sucesso, com o seguinte código de conta: " + bk.add_account(numberDocumentMain, numberDocumentOthers, value));

    }
    static void commandM(Bank bk, Scanner sc){
        System.out.print("Sabe o número da conta (S ou N)? ");
        char choice = sc.next().charAt(0);
        if (choice == 'S'){
            System.out.print("Número da conta: ");
            long accId = sc.nextLong();
            while(!bk.account_existent(accId)) {
                System.out.println("\nO número da conta inserido não corresponde a nenhuma conta já criada. ");
                System.out.print("Insira outro Número de Documento: ");
                accId = sc.nextLong();

            }

            //escolher o tipo de movimento
            System.out.print("Pretende fazer um Débito (D) ou um Crédito (C)? ");
            char choice2 = sc.next().charAt(0);

            System.out.print("Insira o valor do movimento: ");
            double value = sc.nextDouble();

            switch (choice2){
                case 'D':
                    if(bk.debit_account(accId, value)) {
                        System.out.println("O movimento foi executado com sucesso!");
                    }else{
                        System.out.println("O movimento não foi executado!");
                    }
                    break;
                case 'C':
                    bk.credit_account(accId, value);
                    System.out.println("O movimento foi executado com sucesso!");
                    break;
            }

        }else{ //caso não saiba o numero da conta, vai inserir o cliente e procurar as contas associadas ao cliente
            System.out.print("\nInsira o número do documento associado há sua conta: ");
            String numberDocument = sc.next();

            while(!bk.document_existent(numberDocument)) {
                System.out.println("\nNúmero de Documento inserido não está registado. ");
                System.out.print("Insira outro Número de Documento: ");
                numberDocument = sc.next();
            }
            //idAccounts tem todos os ids das contas associadas ao cliente
            List<Long> idAccounts = bk.idAccounts_Client(numberDocument);
            if(idAccounts.size() == 0){
                System.out.println("O cliente não tem contas associadas a ele.");
            }else{
                System.out.println("Os Ids das contas associadas ao cliente são os seguintes:");
                for(int i=0; i<idAccounts.size(); i++){
                    System.out.println("\t" + (i+1) + ") " + idAccounts.get(i));
                }
                System.out.println("Insira o numero da conta que deseja consultar o saldo: ");
                int number = sc.nextInt();

                //escolher o tipo de movimento
                System.out.print("Pretende fazer um Débito (D) ou um Crédito (C)? ");
                char choice2 = sc.next().charAt(0);

                System.out.print("Insira o valor do movimento: ");
                double value = sc.nextDouble();

                switch (choice2){
                    case 'D':
                        if(bk.debit_account(number, value)) {
                            System.out.println("O movimento foi executado com sucesso!");
                        }else{
                            System.out.println("O movimento não foi executado!");
                        }
                        break;
                    case 'C':
                        bk.credit_account(number, value);
                        System.out.println("O movimento foi executado com sucesso!");
                        break;
                }

            }
        }
    }
    static void commandSC(Bank bk, Scanner sc){
        System.out.print("Sabe o número da conta (S ou N)? ");
        char choice = sc.next().charAt(0);
        if (choice == 'S'){
            System.out.print("Número da conta: ");
            long accId = sc.nextLong();
            while(!bk.account_existent(accId)) {
                System.out.println("\nO número da conta inserido não corresponde a nenhuma conta já criada. ");
                System.out.print("Insira outro Número de Documento: ");
                accId = sc.nextLong();

            }
            //verifica o saldo da conta
            System.out.println("\nO saldo da conta " + accId + ": " + bk.balance_account(accId));

        }else{ //caso não saiba o numero da conta, vai inserir o cliente e procurar as contas associadas ao cliente
            System.out.print("\nInsira o número do documento associado há sua conta: ");
            String numberDocument = sc.next();

            while(!bk.document_existent(numberDocument)) {
                System.out.println("\nNúmero de Documento inserido não está registado. ");
                System.out.print("Insira outro Número de Documento: ");
                numberDocument = sc.next();
            }
            //idAccounts tem todos os ids das contas associadas ao cliente
            List<Long> idAccounts = bk.idAccounts_Client(numberDocument);
            if(idAccounts.size() == 0){
                System.out.println("O cliente não tem contas associadas a ele.");
            }else{
                System.out.println("Os Ids das contas associadas ao cliente são os seguintes:");
                for(int i=0; i<idAccounts.size(); i++){
                    System.out.println("\t" + (i+1) + ") " + idAccounts.get(i));
                }
                System.out.println("Insira o numero da conta que deseja consultar o saldo: ");
                int number = sc.nextInt();

                //verifica o saldo da conta
                System.out.println("\nO saldo da conta " + idAccounts.get(number-1) + ": " + bk.balance_account(idAccounts.get(number-1)));


            }
        }
    }
}
