package com.fontys.dal.repositories;

import com.fontys.domain.models.AmountType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("AmountTypeRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "amounttype")
public interface AmountTypeRepository extends PagingAndSortingRepository<AmountType, Long> {
}
