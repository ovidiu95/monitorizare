package entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ovi on 22-May-16.
 */

@Entity
@Table(name = "task", catalog = "monitorizare")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    private AppUser employee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppUser getEmployee() {
        return employee;
    }

    public void setEmployee(AppUser employee) {
        this.employee = employee;
    }
}
