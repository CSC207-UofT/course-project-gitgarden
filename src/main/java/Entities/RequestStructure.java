package Entities;
import java.util.ArrayList;

interface RequestStructure {

    public void add(RequestStructure request);

    public void remove(RequestStructure request);

    public ArrayList<Request> temp();

    public void show();

    public void search(Offer offer);
}
