package entity;

import javax.persistence.*;

@Entity
public class BookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private String isbn;
    private int numberOfPage;
    private double price;

    @OneToOne(mappedBy = "bookDetails")
    private Book book_id;

    public BookDetails(){

    }

    public BookDetails(int id, String isbn, int numberOfPage, double price) {
        this.id = id;
        this.isbn = isbn;
        this.numberOfPage = numberOfPage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
