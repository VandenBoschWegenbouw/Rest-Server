package com.fontys.dal.repositories;

import com.fontys.domain.models.PartType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("PartTypeRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "parttype")
public interface PartTypeRepository extends PagingAndSortingRepository<PartType, Long> {
}
