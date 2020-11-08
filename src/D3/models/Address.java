package D3.models;

/** Represents an Address of a Client in a Bank.
 * @author Diurno - Grupo 3.
 * @author Daniel Almeida.
 * @author João Conduto.
 * @author Kevyn Marins.
 * @author Tiago Leitão.
 */
public class Address {
    private String street;
    private String postalCode;
    private String city;
    private String country;

    /** Create a Address object.
     *
     * @param street The Street of the Client`s address.
     * @param postalCode The postal code of the Client`s address.
     * @param city The city of the Client`s address.
     * @param country The country of the Client`s address.
     */
    Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    /** Returns the street of the Client`s address.
     *
     * @return the street of the Client`s address.
     */
    public String getStreet() {
        return this.street;
    }

    /** Returns the postal code of the Client`s address.
     *
     * @return the postal code of the Client`s address.
     */
    public String getPostalCode() {
        return this.postalCode;
    }

    /** Returns the city of the Client`s address.
     *
     * @return the city of the Client`s address.
     */
    public String getCity() {
        return this.city;
    }

    /** Returns the country of the Client`s address.
     *
     * @return the country of the Client`s address.
     */
    public String getCountry() {
        return this.country;
    }
}
