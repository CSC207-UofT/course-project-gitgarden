package Entities;
import java.util.ArrayList;

interface RequestStructure {

    /**
     * Add a new request as counteroffer of the current request.
     *
     * @param request THe new request to be added.
     */
    public void add(RequestStructure request);

    /**
     * Remove the given request in counteroffer of the current request.
     *
     * @param request THe request need to be removed.
     */
    public void remove(RequestStructure request);

    /**
     * Return all counteroffers of the current request.
     *
     * @return The arraylist of requests representing the counteroffers of the current request.
     */
    public ArrayList<RequestStructure> counteroffers();

    /**
     * Return all offers that are extensions of the current request.
     *
     * @return The arraylist of offers representing offers that are extensions of the current request.
     */
    public ArrayList<Offer> offers();

    /**
     * Return the branch that are extension of the current request that ends with the given offer.
     *
     * @param offer The final offer that we want to find.
     * @return The arraylist of Requests and Offers that representing branch extends to the given offer.
     */
    public ArrayList<RequestStructure> search(Offer offer);

    /**
     * Print a representation of the structure of the current request.
     */
    public void show();

}
