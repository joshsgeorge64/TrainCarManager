/**
 * @author joshua.s.george@stonybrook.edu
 * ID: 112839378
 * Rec: 02
 * <p>
 * This is the TrainCarNode class to act as nodes in the TrainLinkedList
 */

public class TrainCarNode {
    private TrainCarNode prev;
    private TrainCarNode next;
    private TrainCar car;

    /**
     * Creates an empty TrainCar Node object
     */
    public TrainCarNode() {
        prev = null;
        next = null;
    }

    /**
     * Creates a TrainCarNode with the given TrainCar
     *
     * @param car TrainCar object to be set in TrainCarNode
     *            <dl>
     *            <dt><b>Postconditions:</b></dt>
     *            <dd>TrainCar object is created with car</dd>
     *            </dl>
     */
    public TrainCarNode(TrainCar car) {
        prev = null;
        next = null;
        this.car = car;
    }

    /**
     * Returns the TrainCarNode being referenced by prev
     *
     * @return TrainCarNode being referenced by prev
     */
    public TrainCarNode getPrev() {
        return prev;
    }

    /**
     * Sets TrainCarNode to be referenced by prev
     *
     * @param prev TrainCarNode to be set at prev
     */
    public void setPrev(TrainCarNode prev) {
        this.prev = prev;
    }

    /**
     * Returns the TrainCarNode being referenced by next
     *
     * @return TrainCarNode being referenced by next
     */
    public TrainCarNode getNext() {
        return next;
    }

    /**
     * Sets TrainCarNode to be referenced by next
     *
     * @param next TrainCarNode to be set at next
     *             <dl>
     *                     <dt><b>Postconditions:</b></dt>
     *                     <dd>next is set to next</dd>
     *             </dl>
     */
    public void setNext(TrainCarNode next) {
        this.next = next;
    }

    /**
     * Returns TrainCar object in this TrainCarNode
     *
     * @return TrainCar found in this TrainCarNode
     */
    public TrainCar getCar() {
        return car;
    }

    /**
     * Sets TrainCar to be added to the TrainCarNode
     *
     * @param car TrainCar to be added
     *
     *            <dl>
     *                       <dt><b>Postconditions:</b></dt>
     *                       <dd>TrainCar is set to car</dd>
     *            </dl>
     */
    public void setCar(TrainCar car) {
        this.car = car;
    }

    public String toString() {
        String danger;
        if (car.getLoad().isDangerous())
            danger = "YES";
        else
            danger = "NO";
        return String.format("   %-14.1f %-14.1f %-14s %-14.1f %-14.2f %-5s", car.getCarLength(), car.getCarWeight(),
                car.getLoad().getName(), car.getLoad().getWeight(), car.getLoad().getValue(), danger);
    }

    /**
     * Checks if two TrainCarNode objects are equal
     *
     * @param o Object to compare to
     * @return True if the objects are equal, false if not.
     */
    public boolean equals(Object o) {
        if (o instanceof TrainCarNode) {
            TrainCarNode t = (TrainCarNode) o;
            if (t.getCar().getCarLength() == car.getCarLength()
                    && t.getCar().getCarWeight() == car.getCarWeight())
                return true;
        }
        return false;
    }
}
