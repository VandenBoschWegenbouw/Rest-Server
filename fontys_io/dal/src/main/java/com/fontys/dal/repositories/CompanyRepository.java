package com.fontys.dal.repositories;

import com.fontys.domain.models.Company;
import com.fontys.domain.models.HourRegistration;
import com.fontys.domain.models.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("CompanyRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "companies")
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

    //@Query(value = "SELECT h from hourregistration h where h.project.idProject = :id AND h.date BETWEEN :begin AND :end")
    @Query(value = "SELECT p from Project p where p.company.idCompany = :id")
    List<Project> readByCompany(@Param("id") Long id);

    @Query(value = "SELECT `company`.`id_company`,`company`.`name` FROM `company` JOIN `project` ON `project`.`company_id` = `company`.`id_company` WHERE project.is_finished = 0", nativeQuery = true)
    List<Company> readAllActiveCompanies();
}
//