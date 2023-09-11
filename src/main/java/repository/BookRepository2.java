package repository;

import entity.Book;
import entity.BookDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository2 extends CrudRepository<Book,Integer> {
}
