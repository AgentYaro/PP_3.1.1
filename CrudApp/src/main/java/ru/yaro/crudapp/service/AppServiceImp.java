package ru.yaro.crudapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.yaro.crudapp.dao.RoleDao;
import ru.yaro.crudapp.dao.UserDao;
import ru.yaro.crudapp.models.Role;
import ru.yaro.crudapp.models.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
public class AppServiceImp implements AppService {
    private RoleDao roleDao;
    private UserDao userDao;

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public Set<Role> getAllRoles() {
        return roleDao.getAll();
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDao.getByName(name);
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public void addAllRoles(Set<Role> roles) {
        roleDao.addAllRoles(roles);
    }

    @Override
    public void setExistingRoles(User user) {
        Set<Role> roles = new HashSet<>(user.getRoles());
        user.removeRoles();
        for (Role role : roles) {
            user.addRole(getRoleByName(role.getName()));
        }
    }

    @Override
    public void fillRoles(String... roleNames) {
        for (String roleName : roleNames) {
            roleDao.addRole(new Role(roleName));
        }
    }

    @Override
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }
}
