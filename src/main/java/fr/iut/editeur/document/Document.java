package fr.iut.editeur.document;
import java.lang.String;
public class Document {

    private String texte;

    /** Constructeur
     */
    public Document() {
        this.texte = "";
    }

    /**
     * Obtenir le texte contenu dans le document.
     * @return texte du document.
     */
    public String getTexte() {
        return texte;
    }

    /**
     * Définir le texte du document.
     * @param texte à ajouter.
     */
    public void setTexte(String texte) {
        this.texte = texte;
    }

    /**
     * Ajouter du texte à mon document.
     * @param texte à ajouter.
     */
    public void ajouter(String texte) {
        this.texte += texte;
    }

    /**
     * Effacer le texte d'un point a à un point b.
     * @param start position de début.
     * @param end position de fin.
     */
    public void effacer(int start, int end){
        remplacer(start,end,"");
    }
    public void remplacer(int start, int end, String remplacement) {
        String leftPart = texte.substring(0, start);
        String rightPart = texte.substring(end);
        texte = leftPart + remplacement + rightPart;
    }

    /**
     * Mettre le texte en majuscule d'un point A à un point B.
     * @param start point A
     * @param end point B
     */
    public void majuscules(int start, int end) {
        String texte = getTexte();
        String partieMaj = texte.substring(start,end);
        partieMaj = partieMaj.toUpperCase();
        remplacer(start,end,partieMaj);
    }

    /**
     *
     * @return Le document sous forme de chaine de caractère ?
     */
    @Override
    public String toString() {
        return this.texte;
    }
}
