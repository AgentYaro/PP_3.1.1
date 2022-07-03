package ru.yaro.crudapp.dao;

import ru.yaro.crudapp.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getAll();

    User getById(Long id);

    void delete(User user);

    void update(User user);

    void deleteById(long id);
}
