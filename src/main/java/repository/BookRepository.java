package repository;

import entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByNameNot(String author);
    List<BookEntity> findByPublishDateBefore(Date currentDate);
    List<BookEntity> findByPriceGreaterThan(double price);
    List<BookEntity> deleteByNameAndAuthor(String name, String author);
}
