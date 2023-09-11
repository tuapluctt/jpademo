package repository;

import entity.BookDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookdetailsRepository extends CrudRepository<BookDetails,Integer> {
}
