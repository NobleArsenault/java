package com.project.belter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.belter.models.User;

@Repository 												
public interface UserRepository extends CrudRepository<User,Long>{
	User findByEmail(String email);
}
