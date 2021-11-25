package services.impl;

import beans.Student;
import daos.ChoicesDAO;
import services.AbstractChoichesService;

public class DefaultChoicheesService extends AbstractChoichesService {
    public DefaultChoicheesService(ChoicesDAO choicesDAOProvider) {
        super(choicesDAOProvider);
    }

    @Override
    public void save(Student student) {
        this.choicesDAO.persistChoice(student);
    }
}
