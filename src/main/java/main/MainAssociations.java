package main;

import configuration.JPAConfig;
import entity.Book;
import entity.BookDetails;
import entity.BookEntity;
import entity.Category;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;
import repository.BookRepository2;
import repository.BookdetailsRepository;
import repository.CategoryRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class MainAssociations {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static CategoryRepository categoryRepository = applicationContext.getBean("categoryRepository",CategoryRepository.class);
    static BookdetailsRepository bookdetailsRepository = applicationContext.getBean("bookdetailsRepository", BookdetailsRepository.class);
    static BookRepository2 bookRepository2 = applicationContext.getBean("bookRepository2" , BookRepository2.class);



    public static void main(String[] args) {
//        Category c1 = new Category();
//        c1.setName("truyen buon");
//        c1.setDescription("dep oki ddinh ");
//
//        BookDetails bb = new BookDetails();
//        bb.setIsbn("hahahha");
//        bb.setPrice(300000);
//        bb.setNumberOfPage(90);
//
//        Book b1 = new Book();
//        b1.setName("Coong vien cac hoang tu");
//        b1.setAuthor("Hoang van tu");
//        b1.setCategory_id(c1);
//        b1.setBookDetails(bb);
//
//
//
//
//        categoryRepository.save(c1);
//        bookRepository2.save(b1);














//        if(b.isPresent()){
//            System.out.println("Tên nhân viên: " + b.get().getName());
//            if(b.get().getBookDetails()!=null){
//                System.out.println("gia : " + b.get().getBookDetails().getPrice());
//            }else{
//                System.out.println("Voo Gia " );
//            }
//
//        }





    }
}
