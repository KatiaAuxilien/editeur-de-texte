package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeInserer extends CommandeDocument {

    public CommandeInserer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 3) {
            System.err.println("Format attendu : inserer;depart;chaine");
            return;
        }
        int indexDepart = Integer.parseInt(parameters[1]); //On donne en paramètre un string, donc on doit convertir string en int.
        String texte = parameters[2];
        this.document.remplacer(indexDepart,indexDepart,texte);
        super.executer();
    }

}
