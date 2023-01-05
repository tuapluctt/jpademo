package entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;


public class BookBackupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private int id;
    @Column (name="name")
    @NotNull
    private String name;

    @Column (name="author")
    @Pattern(regexp="[^0-9]*")
    private String author;
    @Column (name="category")
    private String category;
    @Column (name="isbn")
    private String isbn;

    @Column (name="price")
    @Min(10)
    private double price;

    @Column (name="numberOfPage")
    @Size(min = 1, max = 20000)
    private int numberOfPage;

    @Column (name="publishDate")
    @Past
    private LocalDate publishDate;

    public BookBackupEntity() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "BookEntity{ id = "+id + ", name = "+ name +"}";
    }
}
