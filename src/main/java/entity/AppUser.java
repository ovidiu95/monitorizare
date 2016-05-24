package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ovi on 22-May-16.
 */

@Entity
@Table(name = "appuser", catalog = "monitorizare")
public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    private boolean isAdmin;

    private boolean isPresent;

    private String arriveHour;

    @OneToMany
    private List<Task> tasks;

    public Long getId() {
        return id;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getArriveHour() {
        return arriveHour;
    }

    public void setArriveHour(String arriveHour) {
        this.arriveHour = arriveHour;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
