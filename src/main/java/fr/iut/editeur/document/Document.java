package fr.iut.editeur.document;
import java.lang.String;
public class Document {

    private String texte;

    public Document() {
        this.texte = "";
    }
	
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void ajouter(String texte) {
        this.texte += texte;
    }

    public void effacer(int start, int end){
        remplacer(start,end,"");
    }
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
    }

    public void majuscules(int start, int end) {
        String texte = getTexte();
        String partieMaj = texte.substring(start,end);
        partieMaj = partieMaj.toUpperCase();
        remplacer(start,end,partieMaj);
    }

    public void minuscules(int start, int end) {
        String texte = getTexte();
        String partieMaj = texte.substring(start,end);
        partieMaj = partieMaj.toLowerCase();
        remplacer(start,end,partieMaj);
    }

    @Override
    public String toString() {
        return this.texte;
    }
}
