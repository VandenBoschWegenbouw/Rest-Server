package com.fontys.dal.repositories;

import com.fontys.domain.models.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("ProjectRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "projects")
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
