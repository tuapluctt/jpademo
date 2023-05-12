package repository;

import entity.AccountEntity;
import entity.CategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {
    @Query(value = "",nativeQuery = true)
    void updateAccLook();

    @Query("delete account u where u.balance = 0")
    void deleteAccByBalanc();
}
