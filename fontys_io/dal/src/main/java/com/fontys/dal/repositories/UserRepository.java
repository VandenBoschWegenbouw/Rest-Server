package com.fontys.dal.repositories;

import com.fontys.domain.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
@RepositoryRestResource(collectionResourceRel = "results", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.password = :password")
    User getUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("SELECT true FROM User WHERE username = :username")
    Boolean findUsername(@Param("username") String username);

}
