package D3.views;

import D3.controllers.Bank;
import D3.models.Tax;
import D3.models.Account;
import D3.models.Client;


import java.sql.Date;
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
                    System.out.println("Comando inserido não foi reconhecido.");

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

        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber);
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

                break;
            case 3:
                System.out.print("Novo Email: ");
                String email = sc.next();
                bk.alter_client_email(numberDocument,email);
                break;
            case 4:
                System.out.print("Novo Contacto Telefónico: ");
                int phoneNumber = sc.nextInt();
                bk.alter_client_phoneNumber(numberDocument,phoneNumber);
                break;
        }

    }
    static void commandNC(Bank bk, Scanner sc){

    }
    static void commandM(Bank bk, Scanner sc){

    }
    static void commandSC(Bank bk, Scanner sc){

    }
}
