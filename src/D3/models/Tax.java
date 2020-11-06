package D3.models;

/** Represents a Tax in a Bank.
 * @author Diurno - Grupo 3.
 * @author Daniel Almeida.
 * @author João Conduto.
 * @author Kevyn Marins.
 * @author Tiago Leitão.
 */
public class Tax {
    private double value = 0.49;

    /** Creates a new tax object
     *
     */
    public Tax() {}

    /** Returns the value of the tax.
     *
     * @return the value of the tax.
     */
    public double getValue() {
        return this.value;
    }

    /** Sets a new tax value
     *
     * @param value The new tax value.
     */
    public void setValue(double value) {
        this.value = value;
    }
}
