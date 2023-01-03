package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User showUser(int id);
    void delete(int id);
    void edit(int id, User user);
    List<User> showUsers();
}
