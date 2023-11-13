package fr.iut.editeur.commande.factory;

import fr.iut.editeur.commande.*;
import fr.iut.editeur.document.Document;

public class CommandeFactory {

    private static CommandeFactory instance;

    public static CommandeFactory getInstance() {
        if(instance == null) {
            instance = new CommandeFactory();
        }
        return instance;
    }

    private CommandeFactory() {}

    public Commande createCommand(String name, Document document, String[] parameters) {
        switch (name) {
            case "ajouter" : return new CommandeAjouter(document, parameters);
            case "remplacer" : return new CommandeRemplacer(document, parameters);
            case "majuscules" : return new CommandeMajuscules(document, parameters);
            case "effacer" : return new CommandeEffacer(document,parameters);
            case "clear" : return new CommandeClear(document,parameters);
            case "insert" : return new CommandeInserer(document,parameters);
            case "minuscules" : return new CommandeMinuscules(document, parameters);
            case "description" : return new CommandeDescription(document,parameters);
            default: return null;
        }
    }

}
