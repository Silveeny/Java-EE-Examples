package services;

import beans.Student;
import daos.ChoicesDAO;

public abstract class AbstractChoichesService {
    protected ChoicesDAO choicesDAO;

    public AbstractChoichesService(ChoicesDAO choicesDAOProvider) {
        this.choicesDAO = choicesDAOProvider;
    }

    abstract public void save(Student student);
}
