package com.fontys.dal.repositories;

import com.fontys.domain.models.HourRegistration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("HourRegistrationRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "hourregistration")
public interface HourRegistrationRepository extends PagingAndSortingRepository<HourRegistration, Long> {

    @Query(value = "SELECT h from hourregistration h where h.user.idUser = :id AND h.date BETWEEN :begin AND :end")
    List<HourRegistration> findAllByDateAndUserId(@Param("begin") LocalDateTime begin, @Param("end") LocalDateTime end, @Param("id") Long id);

    @Query(value = "SELECT h from hourregistration h where h.project.idProject = :id AND h.date BETWEEN :begin AND :end")
    List<HourRegistration> findAllByDateAndProjectId(@Param("begin") LocalDateTime begin, @Param("end") LocalDateTime end, @Param("id") Long id);
}