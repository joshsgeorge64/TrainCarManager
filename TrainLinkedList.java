/**
 * @author joshua.s.george@stonybrook.edu
 * ID: 112839378
 * Rec: 02
 * <p>
 * This class is the Train Linked List consisting of TrainCarNodes to be inserted, removed, etc.
 */

public class TrainLinkedList {
    private TrainCarNode head;
    private TrainCarNode tail;
    private TrainCarNode cursor;
    private int numTrains;
    private double totalLength;
    private double totalValue;
    private double totalWeight;

    /**
     * Creates a Train LinkedList with no TrainCarNodes in it
     *
     * <dl>
     *     <dt><b>Postconditions:</b></dt>
     *     <dd> This TrainLinkedList has been intitalized to an empty linked list
     *     head, tail, cursor are all set to null.</dd>
     * </dl>
     */
    public TrainLinkedList() {
        head = null;
        tail = null;
        cursor = null;
        numTrains = 0;
        totalLength = 0;
        totalValue = 0;
        totalWeight = 0;
    }

    /**
     * Returns a reference to the TrainCar at the node currently referenced by the cursor
     *
     * @return The reference to the TrainCar at the node currently referenced by the cursor
     *
     * <dl>
     *     <dt><b>Preconditions:</b></dt>
     *     <dd>The list is not empty</dd>
     * </dl>
     */
    public TrainCar getCursorData() {
        return cursor.getCar();
    }

    /**
     * Places car in the node currently referenced by the cursor
     *
     * @param car Car object to be added to TrainLinkedList
     *            <dl>
     *            <dt><b>Preconditions:</b></dt>
     *            <dd>The list is not empty</dd>
     *            <dt><b>Postconditions:</b></dt>
     *            <dd>The cursor node now contains a reference to car as its data</dd>
     *            </dl>
     */
    public void setCursorData(TrainCar car) {
        cursor.setCar(car);
    }

    /**
     * Gets total value of the load on the train
     *
     * @return total value of train
     */
    public double getValue() {
        return totalValue;
    }

    /**
     * Gets total weight of train
     *
     * @return total weight of train
     */
    public double getWeight() {
        return totalWeight;
    }

    /**
     * Gets total length of train
     *
     * @return total weight of train
     */
    public double getLength() {
        return totalLength;
    }

    /**
     * Sets load of car referenced by current cursor node
     *
     * @param load ProductLoad object to be added
     * @throws IllegalArgumentException Thrown if invalid weight or value is inputed
     *
     *                                  <dl>
     *                                      <dt><b>Postconditions:</b></dt>
     *                                      <dd>Load is added to car referenced by cursor</dd>
     *                                  </dl>
     */
    public void setCursorLoad(ProductLoad load) throws IllegalArgumentException {
        if (load.getWeight() < 0)
            throw new IllegalArgumentException("Please enter a valid weight!");
        if (load.getValue() < 0)
            throw new IllegalArgumentException("Please enter a valid value!");

        cursor.getCar().setProductLoad(load);
        totalWeight += load.getWeight();
        totalValue += load.getValue();
    }

    /**
     * Moves the cursor to point at the next TrainCarNode
     *
     * @throws EmptyListException Thrown if there are no cars in the train
     * @throws EndOfListException Thrown if cursor is trying to access past head or tail of list
     *
     *                            <dl>
     *                                <dt><b>Preconditions:</b></dt>
     *                                <dd>The list is not empty or cursor is not referencing tail of list</dd>
     *                                <dt><b>Postconditions:</b></dt>
     *                                <dd>The cursor has advanced to the next TrainCarNode or has remained at the tail of the list</dd>
     *                            </dl>
     */
    public void cursorForward() throws EmptyListException, EndOfListException {
        if (cursor == null) {
            throw new EmptyListException("List is empty");
        } else if (cursor == tail) {
            throw new EndOfListException("No next car, cannot move cursor forward");
        } else {
            cursor = cursor.getNext();
        }
    }

    /**
     * Moves the cursor to point at the previous TrainCarNode
     *
     * @throws EmptyListException Thrown if there are no cars in the train
     * @throws EndOfListException Thrown if cursor is trying to access past head or tail of list
     *
     *                            <dl>
     *                                <dt><b>Preconditions:</b></dt>
     *                                <dd>The list is not empty or cursor is not referencing head of list</dd>
     *                                <dt><b>Postconditions:</b></dt>
     *                                <dd>The cursor has been moved back to the previous TrainCarNode or has remained at the head of the list</dd>
     *                            </dl>
     */
    public void cursorBackward() throws EmptyListException, EndOfListException {
        if (cursor == null) {
            throw new EmptyListException("List is empty");
        } else if (cursor == head) {
            throw new EndOfListException("No previous car, cannot move cursor backward");
        } else {
            cursor = cursor.getPrev();
        }
    }

    /**
     * Inserts car into train after the cursor position
     *
     * @param newCar TrainCar object to be added to list
     * @throws IllegalArgumentException Thrown if invalid length or weight is inputted
     *
     *                                  <dl>
     *                                      <dt><b>Preconditions:</b></dt>
     *                                      <dd>The TrainCar object has been instantiated</dd>
     *                                      <dt><b>Postconditions:</b></dt>
     *                                      <dd>The new TrainCAr train has been inserted in the train after the position of the cursor</dd>
     *                                      <dd>All TrainCar objects previously on the train, and order has been preserved</dd>
     *                                      <dd>The cursor now points to the inserted car</dd>
     *                                  </dl>
     */
    public void insertAfterCursor(TrainCar newCar) throws IllegalArgumentException {
        TrainCarNode newNode = new TrainCarNode(newCar);
        if (newCar == null)
            throw new IllegalArgumentException("This car is not valid");
        if (newCar.getCarWeight() < 0)
            throw new IllegalArgumentException("Please enter a valid weight greater than 0");
        if (newCar.getCarLength() < 0)
            throw new IllegalArgumentException("Please enter a valid length greater than 0");
        if (cursor == null) {
            head = newNode;
            tail = newNode;
        } else if (cursor.getNext() == null) {
            newNode.setPrev(cursor);
            cursor.setNext(newNode);
            tail = newNode;
        } else {
            newNode.setPrev(cursor);
            newNode.setNext(cursor.getNext());
            newNode.getNext().setPrev(newNode);
            cursor.setNext(newNode);
        }
        cursor = newNode;
        numTrains++;
        totalWeight += newNode.getCar().getCarWeight();
        totalLength += newNode.getCar().getCarLength();
    }

    /**
     * Removes the TrainCarNode referenced by the cursor and returns the TrainCar contained within the node
     *
     * @return The TrainCarNode that was referenced by the cursor
     * @throws EmptyListException Thrown if the list is empty
     *
     *                            <dl>
     *                                <dt><b>Preconditions:</b></dt>
     *                                <dd>The cursor is not null</dd>
     *                                <dt><b>Postconditions:</b></dt>
     *                                <dd>The TrianCArNode referenced by the cursor has been removed from the train</dd>
     *                                <dd>The cursor now references the next node, or the previous node if no next node exists</dd>
     *                            </dl>
     */
    public TrainCar removeCursor() throws EmptyListException {
        TrainCar car;
        if (cursor == null) {
            throw new EmptyListException("The list is empty");
        } else if (cursor.getNext() == null && cursor.getPrev() == null) {
            car = cursor.getCar();
            head = null;
            tail = null;
            cursor = null;
        } else if (cursor.getNext() == null) {
            car = cursor.getCar();
            cursor = cursor.getPrev();
            cursor.setNext(null);
            tail = cursor;
        } else if (cursor.getPrev() == null) {
            car = cursor.getCar();
            cursor = cursor.getNext();
            cursor.setPrev(null);
            head = cursor;
        } else {
            car = cursor.getCar();
            cursor.getNext().setPrev(cursor.getPrev());
            cursor.getPrev().setNext(cursor.getNext());
            cursor = cursor.getNext();
        }
        numTrains--;
        totalLength -= car.getCarLength();
        totalWeight -= (car.getCarWeight() + car.getLoad().getWeight());
        totalValue -= car.getLoad().getValue();
        return car;
    }

    /**
     * Prints a neatly formatted table of the train, cars and there respective values
     */
    public void printManifest() {
        System.out.println("    CAR:                               LOAD:\n" +
                "      Num   Length (m)    Weight (t)  |    Name      Weight (t)     Value ($)   Dangerous\n" +
                "    ==================================+===================================================");
        if (head != null) {
            int i = 1;
            TrainCarNode temp = head;
            if (cursor.equals(temp))
                System.out.println("-->    " + i + "  " + head);
            else
                System.out.println("       " + i + "  " + head);
            while (temp.getNext() != null) {
                i++;
                temp = temp.getNext();
                if (cursor.equals(temp))
                    System.out.println("-->    " + i + "  " + temp);
                else
                    System.out.println("       " + i + "  " + temp);
            }
        }
    }

    /**
     * Determines number of TrainCar objects currently on the train
     *
     * @return the number of TrainCar objects on this train
     */
    public int size() {
        return numTrains;
    }

    /**
     * Determines if there is a TrainCar object with a dangerous load on the train
     *
     * @return True if there is a dangerous load, False if not
     */
    public boolean isDangerous() {
        TrainCarNode temp = head;
        boolean isDangerous = false;
        if (temp.getCar().getLoad().isDangerous())
            isDangerous = true;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getCar().getLoad().isDangerous())
                isDangerous = true;
        }
        return isDangerous;
    }

    /**
     * Searches the list for all ProductLoad objects with the indicated name and sums together their weight and value (Also keeps track of
     * whether the product is dangerous or not), then prints a single ProductLoad record to the console.
     *
     * @param name the name of the ProductLoad to find on train
     * @throws EmptyListException Thrown if there are no cars on the train
     */
    public void findProduct(String name) throws EmptyListException {
        TrainCarNode temp = head;
        double loadlWeight = 0;
        double loadValue = 0;
        boolean isDangerous = false;
        int numFound = 0;
        if (numTrains == 0)
            throw new EmptyListException("There are currently no cars on the train");
        if (temp.getCar().getLoad().getName().equalsIgnoreCase(name)) {
            loadlWeight += temp.getCar().getLoad().getWeight();
            loadValue += temp.getCar().getLoad().getValue();
            isDangerous = temp.getCar().getLoad().isDangerous();
            numFound++;
        }
        while (temp.getNext() != null) {
            temp = temp.getNext();
            if (temp.getCar().getLoad().getName().equalsIgnoreCase(name)) {
                loadlWeight += temp.getCar().getLoad().getWeight();
                loadValue += temp.getCar().getLoad().getValue();
                isDangerous = temp.getCar().getLoad().isDangerous();
                numFound++;
            }
        }

        if (numFound == 0) {
            System.out.println("No record of '" + name + "' found on the train");
        } else {
            System.out.println("The following products were found on " + numFound + " cars: ");
            System.out.println("        Name      Weight (t)     Value ($)   Dangerous\n" +
                    "    ===================================================");
            if (isDangerous)
                System.out.println(String.format("        %-12s %-14.1f %-15.2f %-5s", name,
                        loadlWeight, loadValue, "YES"));
            else
                System.out.println(String.format("        %-12s %-14.1f %-15.2f %-5s", name,
                        loadlWeight, loadValue, "NO"));
        }

    }

    /**
     * Removes all dangerous cars from the train
     * <dl>
     *     <dt><b>Postconditions:</b></dt>
     *     <dd>All dangerous cars have been removed</dd>
     *     <dd>The order of the train has been preserved</dd>
     * </dl>
     */
    public void removeDangerousCars() {
        cursor = head;
        if (numTrains == 0) {
            System.out.println("There are no cars on the train");
            return;
        }

        while (cursor != null) {
            if (cursor.getCar().getLoad().isDangerous()) {
                try {
                    removeCursor();
                } catch (EmptyListException e) {
                    System.out.println(e);
                }

            } else if (numTrains != 1) {
                if (cursor == tail) {
                    System.out.println("Dangerous cars removed");
                    return;
                }
                try {
                    cursorForward();
                } catch (EmptyListException e) {
                    System.out.println(e);
                    return;
                } catch (EndOfListException e) {
                    System.out.println(e);
                    return;
                }
            } else {
                cursor = head;
                System.out.println("Dangerous cars have been removed");
                return;
            }
        }
        cursor = head;
        System.out.println("Dangerous cars have been removed");
    }

    /**
     * Returns a neatly formatted String representations of the train
     *
     * @return String representation of the train
     */
    public String toString() {
        if (numTrains == 0)
            return "There are currently no cars on the train";
        if (isDangerous())
            return String.format("Train: %d cars, %.1f meters, %.1f tons, $%.2f value, DANGEROUS", numTrains,
                    totalLength, totalWeight, totalValue);
        else
            return String.format("Train: %d cars, %.1f meters, %.1f tons, $%.2f value, NOT DANGEROUS", numTrains,
                    totalLength, totalWeight, totalValue);
    }

}
