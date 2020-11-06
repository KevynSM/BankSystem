package D3.models;

public class Documents {
    private char typeDocument;
    private String numberDocument;

    Documents(char typeDocument, String numberDocument) {
        this.typeDocument = typeDocument;
        this.numberDocument = numberDocument;
    }

    public char getTypeDocument() {
        return this.typeDocument;
    }

    public String getNumberDocument() {
        return this.numberDocument;
    }

}
