package lab2.persistence;

import lab2.utils.Triplet;

import java.util.List;

/**
 * Un DataStorage persisteaza o lista de triplete, fie intr-un fisier sau alta sursa externa,
 * si face retrive la lista de triplete
 */
public interface DataStorage {
    void persistTriple(Triplet<String, String, String> t);
    List<Triplet<String, String, String>> retrieveTriple();
}
