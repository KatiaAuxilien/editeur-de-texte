package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeClear extends CommandeDocument {


    public CommandeClear(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 1) {
            System.err.println("Format attendu : effacer;");
            return;
        }
        int indexDebut = 0;
        int indexFin = this.document.getTexte().length();
        String texte = "";
        this.document.remplacer(indexDebut,indexFin,texte);
        super.executer();
    }

}
