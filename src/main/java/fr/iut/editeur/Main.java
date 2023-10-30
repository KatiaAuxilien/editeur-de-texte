package fr.iut.editeur;

import fr.iut.editeur.commande.Commande;
import fr.iut.editeur.commande.invoker.CommandeInvoker;
import fr.iut.editeur.document.Document;
import fr.iut.editeur.commande.factory.CommandeFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Document document = new Document();
        CommandeInvoker invoker = CommandeInvoker.getInstance();
        CommandeFactory factory = CommandeFactory.getInstance();
        while(true) {
            String input = scanner.nextLine();
            String[] parameters = input.split(";");
            String nomCommande = parameters[0];
            Commande commande = factory.createCommand(nomCommande, document, parameters);
            if(commande != null) {
                invoker.executer(commande);
            }
            else {
                System.err.println("Cette commande n'existe pas!");
            }
        }
    }
}