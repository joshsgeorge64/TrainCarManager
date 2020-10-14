/**
 * @author joshua.s.george@stonybrook.edu
 * ID: 112839378
 * Rec: 02
 * <p>
 * This class is the Product Load to be added to the Train cars
 */

public class ProductLoad {
    private String name;
    private double weight;
    private double value;
    private boolean isDangerous;

    /**
     * Creates ProductLoad object with supplied values
     *
     * @param name        The name of the product
     * @param weight      The weight of the load
     * @param value       The value of the product
     * @param isDangerous Whether or not the product is dangerous
     */
    public ProductLoad(String name, double weight, double value, boolean isDangerous) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.isDangerous = isDangerous;
    }

    /**
     * Get the name of the ProductLoad
     *
     * @return Name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the ProductLoad with the supplied name
     *
     * @param name Name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the weight of the load
     *
     * @return Weight of the load
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the load with the supplied value
     *
     * @param weight Weight of the load
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Get value of product
     *
     * @return value of ProductLoad
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of product with the supplied value
     *
     * @param value Value of the product
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Get the danger value of the product
     *
     * @return true if the product is dangerous, false if it is not
     */
    public boolean isDangerous() {
        return isDangerous;
    }

    /**
     * Set the danger value of the product
     *
     * @param dangerous danger value of the product
     */
    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }
}
