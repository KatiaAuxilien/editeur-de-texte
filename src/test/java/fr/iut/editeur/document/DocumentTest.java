package fr.iut.editeur.document;

import junit.framework.TestCase;

public class DocumentTest extends TestCase {

    private Document docTest;
    protected void setUp() throws Exception{
        super.setUp();
        docTest = new Document();
        docTest.ajouter("abc");
    }

    public void testDocument(){
        assertNotNull("L'instance n'est pas créée",docTest);
    }
    public void testGetText() throws Exception {
       assertEquals("Le contenu est incorrect.","abc",docTest.getTexteDocument());
    }
    public void testSetText() throws Exception {
        docTest.setTexteDocument("efgh");
        assertEquals("Le contenu est incorrect.","efgh",docTest.getTexteDocument());
    }

    public void testEffacer() throws Exception{
        docTest.effacer(0,1);
        assertEquals("Le contenu effacé est incorrect","bc",docTest.getTexteDocument());
    }

    public void testAjouter() throws Exception{
        docTest.ajouter("de");
        assertEquals("Le contenu ajouté est incorrect.","abcde",docTest.getTexteDocument());
    }

    public void testRemplacer() throws Exception{
        docTest.remplacer(0,1,"z");
        assertEquals("Le contenu ajouté est incorrect.","zbc",docTest.getTexteDocument());

    }


}