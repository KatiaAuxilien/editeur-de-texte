package fr.iut.editeur.commande;

import fr.iut.editeur.document.Document;

public class CommandeEffacer extends CommandeDocument {

    public CommandeEffacer(Document document, String[] parameters) {
        super(document, parameters);
    }

    @Override
    public void executer() {
        if(parameters.length < 3) {
            System.err.println("Format attendu : effacer;depart;fin");
            return;
        }
        int indexDepart = Integer.parseInt(parameters[1]); //On donne en paramètre un string, donc on doit convertir string en int.
        int indexFin = Integer.parseInt(parameters[2]);
        String texte = "";
        this.document.remplacer(indexDepart,indexFin,texte);
        super.executer();
    }

    @Override
    public void getDescriptionCommande() {
        System.out.println("Effacer : efface le texte d'un point de départ à un point de fin dans le document.");
    }
}
