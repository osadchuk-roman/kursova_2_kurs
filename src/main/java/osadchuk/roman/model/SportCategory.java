package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "sport_category")
@EntityListeners(AuditingEntityListener.class)
public class SportCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    public SportCategory(String name) {
        this.name = name;
    }

    public SportCategory() {
    }

   /* public SportCategory(int id, String name)
    {

        this.id = id;
        this.name = name;
    }*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
