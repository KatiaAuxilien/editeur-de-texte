package fr.iut.editeur.document;
import fr.iut.editeur.commande.*;

import java.lang.String;
public class Document {

    private String texteDocument;

    public Document() {
        this.texteDocument = "";
    }

    /**
     * Obtenir le texte contenu dans le document.
     * @return texte string du document.
     */
    public String getTexteDocument() {
        return texteDocument;
    }

    /**
     * Définir le texte contenu dans le document.
     * @param texteDocument Texte de définition.
     */
    public void setTexteDocument(String texteDocument) {
        this.texteDocument = texteDocument;
    }

    /**
     * Ajouter du texte à la suite.
     * @param texte String texte à ajouter.
     */
    public void ajouter(String texte) {
        this.texteDocument += texte;
    }

    /**
     * Effacer le contenu d'un point A à un point B (partant de 0).
     * @param start en int point A
     * @param end en int point B
     */
    public void effacer(int start, int end){
        remplacer(start,end,"");
    }

    /**
     * Remplacer le contenu  d'un point A à un point B (partant de 0).
     * @param start en int point A.
     * @param end en int point B.
     * @param remplacement String texte de remplacement.
     */
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texteDocument.substring(0, start);
        String rightPart = texteDocument.substring(end);
        texteDocument = leftPart + remplacement + rightPart;
    }

    /**
     * Mettre en majuscules le texte d'un point A à un point B (partant de 0).
     * @param start en int point A.
     * @param end en int point B.
     */
    public void majuscules(int start, int end) {
        String texte = getTexteDocument();
        String partieMaj = texte.substring(start,end);
        partieMaj = partieMaj.toUpperCase();
        remplacer(start,end,partieMaj);
    }

    /**
     * Afficher la description de la commande précisée en argument.
     * @param commande String commande dont on veut connaitre la description.
     * @param parameters
     * @param document
     */
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

    /**
     * Mettre en minuscules le texte d'un point A à un point B (partant de 0).
     * @param start en int point A.
     * @param end en int point B.
     */
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
