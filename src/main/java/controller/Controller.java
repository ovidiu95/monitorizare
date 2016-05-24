package controller;

import entity.AppUser;
import repository.TaskRepo;
import repository.UserRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ovi on 24-May-16.
 */
public class Controller {

    TaskRepo taskRepo;
    UserRepo userRepo;

    public Controller(TaskRepo taskRepo, UserRepo userRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
    }

    public List<AppUser> getPresentsEmployes() {
        List<AppUser> presentsEmploye = new ArrayList<AppUser>();
        for (AppUser user : userRepo.getAll()) {
            if (!user.isAdmin() && user.isPresent())
                presentsEmploye.add(user);
        }
        return presentsEmploye;
    }

    public AppUser login(String username, String pass) throws Exception {
        AppUser user = userRepo.getByUsername(username);
        if (user == null) throw new Exception("Username does not exist!");
        if (!user.getPassword().equals(pass)) throw new Exception("Wrong password!");
        return user;
    }
}
