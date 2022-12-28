package main;

import configuration.JPAConfig;
import entity.BookEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepo = applicationContext.getBean("bookRepository", BookRepository.class);
    public static void main(String[] args) {

        createNewBook();
        List<BookEntity> listBook = (List<BookEntity>) bookRepo.findAll();
        List<BookEntity> listBookName = bookRepo.getBookNameStartWith("J");
        List<BookEntity> listBookPrice = bookRepo.getBookPriceMore(1);
        System.out.println(listBook.get(0).toString());
        System.out.println(listBookName.get(0).toString());
        System.out.println(listBookPrice.get(0).toString());
     //   bookRepo.deleteById(1);

    }
    public static void createNewBook(){
        BookEntity book = new BookEntity();
        book.setName("Java A->Z +");
        book.setAuthor("Roger 33");
        book.setPrice(2.5);
        book.setNumberOfPage(100);
        book.setPublishDate(LocalDate.parse("2016-08-25"));
        BookEntity result = bookRepo.save(book);
        if(result != null){
            System.out.println("A new book saved successfully, book ID = "+ book.getId());
        }
    }
}
