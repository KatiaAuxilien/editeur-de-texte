package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeRemplacer extends CommandeDocument {

    public CommandeRemplacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 4) {
            System.err.println("Format attendu : remplacer;depart;fin;chaine");
            return;
        }
        int indexDepart = Integer.parseInt(parameters[1]); //On donne en paramètre un string, donc on doit convertir string en int.
        int indexFin = Integer.parseInt(parameters[2]);
        String texte = parameters[3];
        this.document.remplacer(indexDepart,indexFin,texte);
        super.executer();
    }

    @Override
    public void getDescriptionCommande() {
        System.out.println("Remplacer : remplacer le texte par un autre d'un point de départ à un point de fin dans le document.");
    }
}
