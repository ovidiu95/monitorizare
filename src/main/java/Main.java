import controller.Controller;
import entity.AppUser;
import repository.TaskRepo;
import repository.UserRepo;
import ui.LoginFrame;

/**
 * Created by Ovi on 23-May-16.
 */
public class Main {

    public static void main(String[] args) {
        UserRepo userRepo = new UserRepo();
        TaskRepo taskRepo = new TaskRepo();
        Controller controller = new Controller(taskRepo, userRepo);
        new LoginFrame(controller);
    }

}
