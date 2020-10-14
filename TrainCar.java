/**
 * @author joshua.s.george@stonybrook.edu
 * ID: 112839378
 * Rec: 02
 * <p>
 * This class is the Train car to be added to the TrainCarNodes
 */

public class TrainCar {
    private double carWeight;
    private double carLength;
    private ProductLoad load;

    /**
     * Creates a TrainCar Object with the supplied values
     *
     * @param carWeight Weight of the car
     * @param carLength Length of the car
     *
     *                  <dl>
     *                                   <dt><b>Postconditions:</b></dt>
     *                                   <dd>ProductLoad is empty</dd>
     *                  </dl>
     */
    public TrainCar(double carWeight, double carLength) {
        this.carWeight = carWeight;
        this.carLength = carLength;
        load = new ProductLoad("Empty", 0, 0, false);
    }

    /**
     * Get the weight of the car
     *
     * @return Weight of the car
     */
    public double getCarWeight() {
        return carWeight;
    }

    /**
     * Get the length of the car
     *
     * @return Length of the car
     */
    public double getCarLength() {
        return carLength;
    }

    /**
     * Get the ProductLoad object on the car
     *
     * @return ProductLoad object found on the car
     */
    public ProductLoad getLoad() {
        return load;
    }

    /**
     * Set the ProductLoad of the car
     *
     * @param load ProductLoad to be set on car
     *
     *             <dl>
     *                         <dt><b>Preconditions:</b></dt>
     *                         <dd>ProductLoad is not null</dd>
     *             </dl>
     */
    public void setProductLoad(ProductLoad load) {
        this.load = load;
    }

}
