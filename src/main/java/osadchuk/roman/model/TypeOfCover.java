package osadchuk.roman.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "type_of_cover")
@EntityListeners(AuditingEntityListener.class)
public class TypeOfCover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    public TypeOfCover(String name) {
        this.name = name;
    }

    /*public TypeOfCover(int id, String name) {
        this.id = id;
        this.name = name;
    }*/

    public TypeOfCover() {
    }

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
