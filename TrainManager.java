import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author joshua.s.george@stonybrook.edu
 * ID: 112839378
 * Rec: 02
 * <p>
 * This class is the Train manager. It provides the main method for the TrainLinkedList class.
 */

public class TrainManager {
    /**
     * The main method for this class. Provides menu for carrying out actions for the Train LinkedList
     * @param args Command-line args
     */

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String selection = "";
        TrainLinkedList trainLinkedList = new TrainLinkedList();
        while (!(selection.equalsIgnoreCase("Q"))) {
            System.out.println();
            printMenu();
            System.out.print("Enter a selection: ");
            selection = scan.next();
            if (selection.equalsIgnoreCase("F")) {
                try {
                    trainLinkedList.cursorForward();
                    System.out.println("Cursor moved forward");
                } catch (EmptyListException e) {
                    System.out.println(e);
                } catch (EndOfListException e) {
                    System.out.println(e);
                }
            } else if (selection.equalsIgnoreCase("B")) {
                try {
                    trainLinkedList.cursorBackward();
                    System.out.println("Cursor moved backward");
                } catch (EmptyListException e) {
                    System.out.println(e);
                } catch (EndOfListException e) {
                    System.out.println(e);
                }
            } else if (selection.equalsIgnoreCase("I")) {
                try {
                    System.out.print("Enter car length in meters: ");
                    double length = scan.nextDouble();
                    System.out.print("Enter car weight in tons: ");
                    double weight = scan.nextDouble();
                    TrainCar car = new TrainCar(weight, length);
                    trainLinkedList.insertAfterCursor(car);
                    System.out.println("New train car "  + length
                    + " meters and " + weight + " tons inserted into train");
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                } catch (Exception e) {
                    selection = "";
                    System.out.println("Please enter a valid input");
                }
            } else if (selection.equalsIgnoreCase("R")) {
                try {
                    TrainCar car = trainLinkedList.removeCursor();
                    System.out.println("Car successfully unlinked. The following load has been " +
                            "removed from the train: ");
                    System.out.println("        Name      Weight (t)     Value ($)   Dangerous\n" +
                            "    ===================================================");
                    String isDangerous;
                    if (car.getLoad().isDangerous())
                        isDangerous = "YES";
                    else
                        isDangerous = "NO";
                    System.out.println(String.format("        %-12s %-14.1f %-15.2f %-5s", car.getLoad().getName(),
                            car.getLoad().getWeight(), car.getLoad().getValue(), isDangerous));
                } catch (EmptyListException e) {
                    System.out.println(e);
                }
            } else if (selection.equalsIgnoreCase("L")) {
                try {
                    System.out.print("Enter product name: ");
                    String name = scan.next();
                    System.out.print("Enter product weight in tons: ");
                    double weight = scan.nextDouble();
                    System.out.print("Enter the product value ($): ");
                    double value = scan.nextDouble();
                    System.out.print("Is the product dangerous (y/n)? ");
                    String danger = scan.next();
                    boolean dangerValue;
                    if (danger.equalsIgnoreCase("Y"))
                        dangerValue = true;
                    else
                        dangerValue = false;
                    ProductLoad load = new ProductLoad(name, weight, value, dangerValue);
                    trainLinkedList.setCursorLoad(load);
                    System.out.println(weight + " tons of " + name + " added to current car");
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid input");
                    selection = "";
                } catch (NullPointerException e){
                    System.out.println("There are currently no cars in the list");
                } catch (IllegalArgumentException e) {
                    System.out.println(e);
                }

            } else if (selection.equalsIgnoreCase("S")) {
                System.out.print("Enter product name: ");
                String name = scan.next();
                try {
                    trainLinkedList.findProduct(name);
                } catch (EmptyListException e) {
                    System.out.println(e);
                }
            } else if (selection.equalsIgnoreCase("T")) {
                System.out.println(trainLinkedList);
            } else if (selection.equalsIgnoreCase("M")) {
                trainLinkedList.printManifest();
            } else if (selection.equalsIgnoreCase("D")) {
                trainLinkedList.removeDangerousCars();
            } else if (selection.equalsIgnoreCase("Q")) {
                System.out.println("Program terminating successfully...");
            } else {
                System.out.println("Please enter a valid selection!");
            }

        }

    }

    public static void printMenu() {
        System.out.println("(F) Cursor Forward\n" +
                "(B) Cursor Backward\n" +
                "(I) Insert Car After Cursor\n" +
                "(R) Remove Car At Cursor\n" +
                "(L) Set Product Load\n" +
                "(S) Search For Product\n" +
                "(T) Display Train\n" +
                "(M) Display Manifest\n" +
                "(D) Remove Dangerous Cars\n" +
                "(Q) Quit\n");
    }
}
