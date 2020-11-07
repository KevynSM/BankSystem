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
            System.out.print("Insira um Comando: ");
            String comm = sc.next();
           // String[] comm2 = comm.split(" ", 8);

            switch (comm){
                case "RC":
                    commandRC(bk);
                    break;

                case "AC":
                    commandAC(bk);
                    break;

                case "NC":
                    commandNC(bk);
                    break;

                case "M":
                    commandM(bk);
                    break;

                case "SC":
                    commandSC(bk);
                    break;

                case "":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Comando inserido não foi reconhecido.");

            }

        }

    }

    static void commandRC(Bank bk) {
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
        do {
            if (bk.document_existent(numberDocument)) {
                System.out.println("Número de Documento já registado. ");
                System.out.println("Insira outro Número de Documento: ");
                numberDocument = sc.next();
            }
        }while(!bk.document_existent(numberDocument));
        //inserir email
        System.out.println("Inserir Email: ");
        String email = sc.next();

        //inserir contacto
        System.out.println("Inserir Contacto Telefónico: ");
        int phoneNumber = sc.nextInt();

        bk.add_client(name, birthDay, typeDocument, numberDocument, email, phoneNumber);
        System.out.println("Cliente Adicionado com sucesso!");
    }
    static void commandAC(Bank bk){

    }
    static void commandNC(Bank bk){

    }
    static void commandM(Bank bk){

    }
    static void commandSC(Bank bk){

    }
}
