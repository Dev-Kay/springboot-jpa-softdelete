package com.example.softdelete.repository;

import com.example.softdelete.entity.SoftDeleteEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface SoftDeleteRepository<T, ID> extends JpaRepository<T, ID> {

    default void delete(T entity) {
        ((SoftDeleteEntity) entity).setIsDeleted(Boolean.TRUE);
        save(entity);
    }

    default void deleteById(ID id) {
        this.delete(findById(id).orElseThrow());
    }

    @Query(value = "SELECT A.* FROM #{#entityName} A WHERE A.ID=?1", nativeQuery = true)
    Optional<T> findByIdIncludeDeleted(ID id);

    @Transactional
    @Query(value = "UPDATE #{#entityName} A SET A.DELETED=FALSE where A.id=?1", nativeQuery = true)
    @Modifying
    void restore(ID id);
}
