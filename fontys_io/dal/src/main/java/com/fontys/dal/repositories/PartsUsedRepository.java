package com.fontys.dal.repositories;

import com.fontys.domain.models.PartsUsed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("PartsUsedRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "partsused")
public interface PartsUsedRepository extends PagingAndSortingRepository<PartsUsed, Long> {


    @Query(value = "SELECT p from partsused p where p.dateUsed BETWEEN :begin AND :end")
    List<PartsUsed> findAllByDate(@Param("begin") LocalDateTime begin, @Param("end") LocalDateTime end);
}
