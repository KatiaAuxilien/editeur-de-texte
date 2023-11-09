package fr.iut.editeur.commande;

import fr.iut.editeur.commande.factory.CommandeFactory;
import fr.iut.editeur.document.Document;

public class CommandeDescription extends CommandeDocument{


    public CommandeDescription(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 2) {
            System.err.println("Format attendu : description;commande");
            return;
        }
        this.document.description(parameters[1],parameters,document);

    }
    @Override
    public void getDescriptionCommande() {
        System.out.println("Description : Affiche la description de la commande précisée en argument.");
    }
}
