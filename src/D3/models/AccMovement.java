package D3.models;

/** Represents an Account Movement in a Bank.
 * @author Diurno - Grupo 3.
 * @author Daniel Almeida.
 * @author João Conduto.
 * @author Kevyn Marins.
 * @author Tiago Leitão.
 */
public class AccMovement {
    private String date;
    private double value;
    private double taxValue;
    private char typeMovement;

    /** Create a new Account Movement with the given parameters
     *
     * @param date The date of the Account Movement
     * @param value The value used in the Account movement.
     * @param taxValue The tax value used in the Account Movement.
     * @param typeMovement The type of the Account Movement.
     */
    AccMovement(String date, double value, double taxValue, char typeMovement) {
        this.date = date;
        this.value = value;
        this.taxValue = taxValue;
        this.typeMovement = typeMovement;
    }

    /** Returns the date of the Account Movement.
     *
     * @return the date of the Account Movement.
     */
    public String getDate() {
        return this.date;
    }

    /** Returns the value used of the Account Movement.
     *
     * @return the value used of the Account Movement.
     */
    public double getValue() {
        return this.value;
    }

    /** Returns the tax value of the Account Movement.
     *
     * @return the tax value of the Account Movement.
     */
    public double getTax(){
        return this.taxValue;
    }

    /** Returns the type of movement of the Account Movement.
     *
     * @return the type of movement of the Account Movement.
     */
    public char getTypeMovement(){
        return this.typeMovement;
    }

}
