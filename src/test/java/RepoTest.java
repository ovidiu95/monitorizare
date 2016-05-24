import entity.AppUser;
import entity.Task;
import org.junit.Test;
import repository.TaskRepo;
import repository.UserRepo;

/**
 * Created by Ovi on 23-May-16.
 */
public class RepoTest {

    @Test
    public void addUser() {
        UserRepo userRepo = new UserRepo();
        AppUser user = new AppUser();
        user.setAdmin(true);
        user.setName("The Boss");
        user.setName("name");
        user.setPassword("admin");
        userRepo.save(user);
    }

    @Test
    public void addTask() {
        UserRepo userRepo = new UserRepo();
        TaskRepo taskRepo = new TaskRepo();
        AppUser user = userRepo.getByUsername("angajat2");
        Task task = new Task();
        task.setDescription("angajat2 task2");
        task.setEmployee(user);
        taskRepo.save(task);

    }

}
