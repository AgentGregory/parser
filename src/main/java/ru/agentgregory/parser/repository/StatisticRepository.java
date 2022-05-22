package ru.agentgregory.parser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.agentgregory.parser.model.Statistic;

@Repository
public interface StatisticRepository extends CrudRepository<Statistic, Long> {
}
