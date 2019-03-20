package autoservice.user.repo.impl;

import autoservice.common.solutions.utils.ArrayUtils;
import autoservice.user.domain.User;
import autoservice.user.repo.UserRepo;
import autoservice.user.search.UserSearchCondition;

import java.util.Collections;
import java.util.List;

import static autoservice.storage.Storage.usersArray;

public class UserMemoryArrayRepo implements UserRepo {

    private static final User[] EMPTY_USERS_ARR = new User[0];
    private int userIndex = -1;

    public void add(User user) {
        if (userIndex == usersArray.length - 1) {
            User[] newArrUsers = new User[usersArray.length * 2];
            System.arraycopy(usersArray, 0, newArrUsers, 0, usersArray.length);
            usersArray = newArrUsers;
        }
        userIndex++;
        usersArray[userIndex] = user;
    }

    public User findById(long id) {
        Integer foundIndex = findUserIndexById(id);

        if (foundIndex != null) {
            return usersArray[foundIndex];
        }
        return null;
    }

    @Override
    public List<User> search(UserSearchCondition searchCondition) {
        return Collections.emptyList();
    }

    private Integer findUserIndexById(Long id) {
        for (int i = 0; i < usersArray.length; i++) {
            if (usersArray[i] != null && usersArray[i].getId().equals(id)) {
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
        for (int i = 0; i < usersArray.length; i++) {
            if (usersArray[i].equals(user)) {
                return i;
            }
        }
        return null;
    }*/

    private void deleteUserByIndex(int index) {
        ArrayUtils.removeElement(usersArray, index);
        userIndex--;
    }

    public void deleteById(Long id) {
        Integer foundIndex = findUserIndexById(id);

        if (foundIndex != null) {
            deleteUserByIndex(foundIndex);
        }
    }

    public void printAll() {
        for (User user : usersArray) {
            System.out.println(user);
        }
    }
}
