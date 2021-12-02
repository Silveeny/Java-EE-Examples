package lab7.repository;

import lab7.entities.User;

public interface UserRepository {

    void save(User user);

    User get(String username);
}
