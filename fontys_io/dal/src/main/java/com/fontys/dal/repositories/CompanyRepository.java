package com.fontys.dal.repositories;

import com.fontys.domain.models.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("CompanyRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "companies")
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
}
