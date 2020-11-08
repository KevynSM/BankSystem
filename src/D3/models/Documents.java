package D3.models;


/** Represents a Document of a Client in a Bank.
 * @author Diurno - Grupo 3.
 * @author Daniel Almeida.
 * @author João Conduto.
 * @author Kevyn Marins.
 * @author Tiago Leitão.
 */
public class Documents {
    private char typeDocument;
    private String numberDocument;

    /** Creates a document object with the given parameters.
     *
     * @param typeDocument A letter that represents the type of the document
     * @param numberDocument The number of the document.
     */
    Documents(char typeDocument, String numberDocument) {
        this.typeDocument = typeDocument;
        this.numberDocument = numberDocument;
    }

    /** Returns the type of the document.
     *
     * @return the type of the document.
     */
    public char getTypeDocument() {
        return this.typeDocument;
    }

    /** Returns the number of the document.
     *
     * @return the number of the document.
     */
    public String getNumberDocument() {
        return this.numberDocument;
    }

}
