package autoservice.user.service;

import autoservice.user.domain.User;
import autoservice.user.repo.impl.UserMemoryRepo;

public class UserMemoryService {

    private UserMemoryRepo userRepo = new UserMemoryRepo();

    public void addUser(User user) {
        userRepo.add(user);

    }

    public User findUserById(Long id) {
        return userRepo.findUserById(id);
    }

    public void deleteUser(User user) {
        userRepo.deleteUser(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteUser(id);
    }

    public void printUsers() {
        userRepo.printUsers();
    }
}
