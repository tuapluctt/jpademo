package main;

import configuration.JPAConfig;
import entity.BookEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.AccountRepository;
import repository.BookRepository;
import service.AccountService;

import java.awt.print.Book;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

public class MainBook {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository = applicationContext.getBean("bookRepository", BookRepository.class);

    public static void Insert(){
        BookEntity b2 = new BookEntity();
        b2.setAuthor("HoangVanTu");
        b2.setCategory("TruyenBuon");
        b2.setName("Cac Ban Nhu qoac qoac");
        b2.setIsbn("ahihi");
        b2.setNumberOfPage(100);
        b2.setPrice(50);
        b2.setPublishDate(Date.valueOf("2020-09-08"));

        BookEntity resuBook = bookRepository.save(b2);
    }

    public static void selectAll(){
        List<BookEntity> list =(List<BookEntity>) bookRepository.findAll();
        list.forEach((book)->{
            System.out.println(book.toString());
        });

    }

    public static void update(){
       Optional<BookEntity> resuBook = bookRepository.findById(1);

       if (resuBook.isPresent()){
           BookEntity book = resuBook.get();
           book.setName("cay vai chuong get() ");

           bookRepository.save(book);
           System.out.println(resuBook.toString());
       }
    }

    public static void delete(){
        bookRepository.deleteById(1);
    }

    public static void findByauthor(){
        String author = "HoangVanTu";

        List<BookEntity> list =(List<BookEntity>)  bookRepository.findByAuthor(author);
        list.forEach((book)->{
            System.out.println(book.toString());
        });
    }

    public static void findByNameNotIn(){
        String author = "java";

        List<BookEntity> list =(List<BookEntity>)  bookRepository.findByNameNot(author);
        list.forEach((book)->{
            System.out.println(book.toString());
        });
    }

    public static void findByPublishDateBefore(){
        Date date = new Date(System.currentTimeMillis());
        List<BookEntity> list =(List<BookEntity>)  bookRepository.findByPublishDateBefore(date);
        list.forEach((book)->{
            System.out.println(book.toString());
        });
    }

    public static void updatePrice(){
        List<BookEntity> listBook = bookRepository.findByPriceGreaterThan(100);

        listBook.forEach((book)->{
            book.setPrice(90);
        });

        bookRepository.saveAll(listBook);
    }

    public static void deleteByNameAndAuthor(){
        List<BookEntity> listBook = bookRepository.deleteByNameAndAuthor("java","Jonh");

        if(listBook!=null){
            bookRepository.deleteAll(listBook);
        }

    }



    public static void main(String[] args) {
//        Insert();
//        selectAll();
//        update();
//        delete();

//       findByauthor();
//        findByNameNotIn();
//        findByPublishDateBefore();
//        updatePrice();
        deleteByNameAndAuthor();
    }
}
