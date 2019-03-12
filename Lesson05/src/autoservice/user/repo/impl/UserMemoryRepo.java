package autoservice.user.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import autoservice.user.domain.User;
import autoservice.user.repo.UserRepo;
import autoservice.user.search.UserSearchCondition;

import static autoservice.storage.Storage.users;

public class UserMemoryRepo implements UserRepo {

    private static final User[] EMPTY_USERS_ARR = new User[0];
    private int userIndex = -1;

    public void add(User user) {
        if (userIndex == users.length - 1) {
            User[] newArrUsers = new User[users.length * 2];
            System.arraycopy(users, 0, newArrUsers, 0, users.length);
            users = newArrUsers;
        }
        userIndex++;
        users[userIndex] = user;
    }

    public User findById(long id) {
        Integer foundIndex = findUserIndexById(id);

        if (foundIndex != null) {
            return users[foundIndex];
        }
        return null;
    }

    @Override
    public User[] search(UserSearchCondition searchCondition) {
        return EMPTY_USERS_ARR;
    }

    private Integer findUserIndexById(Long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    /*public void deleteUser(User user) {
        Integer foundIndex = findUserIndexByEntity(user);

        if (foundIndex != null) {
            deleteUserByIndex(foundIndex);
        }
    }*/

    /*private Integer findUserIndexByEntity(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(user)) {
                return i;
            }
        }
        return null;
    }*/

    private void deleteUserByIndex(int index) {
        ArrayUtils.removeElement(users, index);
        userIndex--;
    }

    public void deleteById(Long id) {
        Integer foundIndex = findUserIndexById(id);

        if (foundIndex != null) {
            deleteUserByIndex(foundIndex);
        }
    }

    public void printAll() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}
