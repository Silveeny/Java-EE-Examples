package lab2.persistence.impl;

import lab2.persistence.DataStorage;
import lab2.utils.Triplet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataStorage implements DataStorage {

    public static final String FILE_PATH = "D:\\11 - Syncthing\\Java Tehnologies\\Lab2\\src\\main\\resources\\triples.txt";

    private List<Triplet<String, String, String>> entries = new ArrayList<Triplet<String, String, String>>();

    public FileDataStorage() {
        try {
            doDeserialize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void doSerialize() throws IOException {
        File f = new File(FILE_PATH);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.entries);
        oos.close();
    }

    public void doDeserialize() throws IOException, ClassNotFoundException {
        File f = new File(FILE_PATH);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        this.entries = (List<Triplet<String, String, String>>) ois.readObject();
        System.out.println(entries);
        ois.close();
    }

    @Override
    public void persistTriple(Triplet<String, String, String> t) {
        this.entries.add(t);
        try {
            this.doSerialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Triplet<String, String, String>> retrieveTriple() {
        try {
            doDeserialize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return this.entries;
    }
}
