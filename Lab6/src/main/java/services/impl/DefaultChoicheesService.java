package services.impl;

import beans.Student;
import dao.ChoicesDAO;
import services.AbstractChoichesService;

import javax.ejb.Stateless;

public class DefaultChoicheesService extends AbstractChoichesService {
    public DefaultChoicheesService(ChoicesDAO choicesDAOProvider) {
        super(choicesDAOProvider);
    }

    public DefaultChoicheesService() {
        super(null);
    }

    @Override
    public void save(Student student) {
        this.choicesDAO.persistChoice(student);
    }
}
