package Client;

public class Driver {
    /**
     * The main method. Runs the program.
     * @param args Arguments (not used in our program)
     */
    public static void main(String[] args) {
        Facade instantiater = new Instantiater();
        instantiater.build();
    }
}
