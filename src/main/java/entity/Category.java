package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description ;
    private String name;

    @OneToMany( fetch = FetchType.LAZY, mappedBy = "category_id")
    private List<Book> bookList ;


    public Category(int id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
    }
    public Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
