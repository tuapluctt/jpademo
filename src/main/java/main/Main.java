package main;

import configuration.JPAConfig;
import entity.BookEntity;
import entity.BookDetailsEntity;
import entity.CategoryEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;
import repository.CategoryRepository;
import sun.lwawt.macosx.CSystemTray;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class Main {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepo = applicationContext.getBean("bookRepository", BookRepository.class);
    static CategoryRepository categoryRepository = applicationContext.getBean("categoryRepository", CategoryRepository.class);
    public static void main(String[] args) {

       // createNewBookEntityWithNewCategory();
       //findAllUsingQuery();

        // Sample for FetchType.
        findAllCategory();

        // Sample for FetchType.LAZY
        //findAllBookFromCategory();
      //  findAllBook();
      //  updateBook(3);
    //    createNewBookEntity();
    }

   private static CategoryEntity createNewCategory(){
        CategoryEntity categoryEnity = new CategoryEntity();
        categoryEnity.setName("IT");
        categoryEnity.setDescription("IT books");
        return categoryEnity;
   }

   private static BookEntity createNewBook(){
       BookDetailsEntity bookDetailsEntity =  new BookDetailsEntity();
       bookDetailsEntity.setIsbn("ISIBF12129220");
       bookDetailsEntity.setNumberOfPage(23);
       bookDetailsEntity.setPrice(65);
       bookDetailsEntity.setPublishDate(LocalDate.now());

       // New book
       BookEntity bookEntity = new BookEntity();

       bookEntity.setName("Java A - Z");
       bookEntity.setAuthor("Roger");
       bookEntity.setBookDetails(bookDetailsEntity);
       bookDetailsEntity.setBook(bookEntity);
       return bookEntity;
   }
    private static void createNewBookEntity(){
        CategoryEntity category = new CategoryEntity();
        category.setId(2);
        BookEntity bookEntity = createNewBook();
        // Set category
        bookEntity.setCategory(category);
        BookEntity result = bookRepo.save(bookEntity);
        if(result != null){
            System.out.println("A new book saved successfully, book ID = "+ bookEntity.getId());
        }
    }
   private static void createNewBookEntityWithNewCategory(){
        CategoryEntity category = createNewCategory();
        categoryRepository.save(category);

        BookEntity bookEntity = createNewBook();
        // Set category
       bookEntity.setCategory(category);
       BookEntity result = bookRepo.save(bookEntity);
       if(result != null){
           System.out.println("A new book saved successfully, book ID = "+ bookEntity.getId());
       }
   }
   private static void findAllUsingQuery(){
       List<BookEntity> bookEntityList = (List<BookEntity>) bookRepo.findAll();
       if(bookEntityList != null){
           for (BookEntity book : bookEntityList) {
               System.out.println(book.toString());
           }
       }
   }
   private static void findAllCategory(){
        List<CategoryEntity> categoryEntityList = (List<CategoryEntity>) categoryRepository.findAll();
       if(categoryEntityList != null){
           for (CategoryEntity category : categoryEntityList) {
               System.out.println(category.toString());
           }
       }
   }

    private static void findAllBook(){
        List<BookEntity> bookEntityList = (List<BookEntity>) bookRepo.findAll();
        if(bookEntityList != null){
            for (BookEntity book : bookEntityList) {
                System.out.println(book.toString());
            }
        }
    }

    public static void updateBook(int id){
        Optional<BookEntity> bookEntityOptional = bookRepo.findById(id);
        if(bookEntityOptional != null){
            // bookOld is book get from DB
            BookEntity bookOld = bookEntityOptional.get();
            // Update book name
            bookOld.setName("Spring Book 4");

            // Get bookDetail from book entity
            BookDetailsEntity bookDetailsEntityOld = bookOld.getBookDetails();
            // Set publishDate = now()
            bookDetailsEntityOld.setPublishDate(LocalDate.now());
            bookDetailsEntityOld.setPrice(90);

            // Set bookDetailNew into Database
            bookOld.setBookDetails(bookDetailsEntityOld);

            // update
            BookEntity rerult = bookRepo.save(bookOld);
            if (rerult != null){
                System.out.println("Book Id: "+ id + " was updated successful!");
            }
            System.out.println(rerult.toString());

        }else {
            System.out.println("Book Id: "+ id + "not found!");
        }
    }

   // Sample for FetchType.LAZY
    private static void findAllBookFromCategory(){
        List<CategoryEntity> categoryEntityList = (List<CategoryEntity>) categoryRepository.findAll();
        if(categoryEntityList != null){
            for (CategoryEntity category : categoryEntityList) {
                List<BookEntity> bookEntityList = category.getBookEntityList();
                if(bookEntityList != null){
                    for (BookEntity book: bookEntityList) {
                        System.out.println("Book of Category:");
                        System.out.println(book.toString());
                    }
                }else{
                    System.out.println("Not found Book of Category:");
                }
            }
        }
    }
}
