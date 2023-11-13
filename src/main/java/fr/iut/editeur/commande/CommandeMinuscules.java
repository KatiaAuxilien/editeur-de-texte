package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeMinuscules extends CommandeDocument {


    public CommandeMinuscules(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 3) {
            System.err.println("Format attendu :  minuscules;depart;fin");
            return;
        }
        int indexDepart = Integer.parseInt(parameters[1]);
        int indexFin = Integer.parseInt(parameters[2]);
        this.document.minuscules(indexDepart,indexFin);
        super.executer();
    }

    @Override
    public void getDescriptionCommande() {
        System.out.println("TTT");
    }

}
