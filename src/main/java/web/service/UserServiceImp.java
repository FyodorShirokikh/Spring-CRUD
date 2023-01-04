package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.dao.UserDao;

import java.util.List;
@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }
    @Override
    public User showUser(int id) {
        return userDao.showUser(id);
    }
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
    @Override
    public void edit(int id, User user) {
        userDao.edit(id, user);
    }
    @Override
    public List<User> showUsers() {
        return userDao.showUsers();
    }
}
