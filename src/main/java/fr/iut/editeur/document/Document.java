package fr.iut.editeur.document;
import java.lang.String;
public class Document {

    private String contentDocument;

    public Document() {
        this.contentDocument = "";
    }
	
    public String getContentDocument() {
        return contentDocument;
    }

    public void setContentDocument(String contentDocument) {
        this.contentDocument = contentDocument;
    }

    public void ajouter(String texte) {
        this.contentDocument += texte;
    }

    public void effacer(int start, int end){
        remplacer(start,end,"");
    }
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = contentDocument.substring(0, start);
        String rightPart = contentDocument.substring(end);
        contentDocument = leftPart + remplacement + rightPart;
    }

    public void majuscules(int start, int end) {
        String texte = getContentDocument();
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

    @Override
    public String toString() {
        return this.contentDocument;
    }
}
