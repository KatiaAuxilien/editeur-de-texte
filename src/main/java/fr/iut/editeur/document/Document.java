package fr.iut.editeur.document;
import fr.iut.editeur.commande.*;

import java.lang.String;
public class Document {

    private String texteDocument;

    public Document() {
        this.texteDocument = "";
    }
	
    public String getTexteDocument() {
        return texteDocument;
    }

    public void setTexteDocument(String texteDocument) {
        this.texteDocument = texteDocument;
    }

    public void ajouter(String texte) {
        this.texteDocument += texte;
    }

    public void effacer(int start, int end){
        remplacer(start,end,"");
    }
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texteDocument.substring(0, start);
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + remplacement + rightPart;
    }

    public void majuscules(int start, int end) {
        String texte = getTexteDocument();
        String partieMaj = texte.substring(start,end);
        partieMaj = partieMaj.toUpperCase();
        remplacer(start,end,partieMaj);
    }

    public void description(String commande, String[] parameters,Document document){
        switch (commande) {
            case "ajouter" : (new CommandeAjouter(document, parameters)).getDescriptionCommande(); return;
            case "remplacer" : (new CommandeRemplacer(document, parameters)).getDescriptionCommande(); return;
            case "majuscules" : (new CommandeMajuscules(document, parameters)).getDescriptionCommande(); return;
            case "effacer" : (new CommandeEffacer(document,parameters)).getDescriptionCommande(); return;
            case "clear" : (new CommandeClear(document,parameters)).getDescriptionCommande(); return;
            case "insert" :(new CommandeInserer(document,parameters)).getDescriptionCommande(); return;
            case "description" : (new CommandeDescription(document,parameters)).getDescriptionCommande(); return;
            default: System.out.println("Commande Inexistante"); return;
        }
    }

    public void minuscules(int start, int end) {
        String texte = getTexteDocument();
        String partieMaj = texte.substring(start,end);
        partieMaj = partieMaj.toLowerCase();
        remplacer(start,end,partieMaj);
    }

    @Override
    public String toString() {
        return this.texteDocument;
    }
}
