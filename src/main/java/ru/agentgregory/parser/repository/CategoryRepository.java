package ru.agentgregory.parser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.agentgregory.parser.model.Category;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    boolean existsById(String name);

    Optional<Category> findByName(String name);
}
