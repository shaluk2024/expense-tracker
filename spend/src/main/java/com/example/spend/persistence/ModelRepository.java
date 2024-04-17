package com.example.spend.persistence;

import common.Model;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Contract for data access operations on a domain entity.
 *
 * @param <T> A type of domain entity.
 */
@NoRepositoryBean
public interface ModelRepository<T extends Model>
    extends JpaRepository<T, Long>, PagingAndSortingRepository<T, Long> {
    /**
     * Finds all entities of the specified type, sorting them in a given order.
     *
     * @param sort The sort order to apply to the entities.
     *
     * @return A list of entities, sorted in the given order.
     */
    List<T> findAll(Sort sort);
}
