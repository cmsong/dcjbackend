package com.revature.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users,Integer>{
	
	List<Users> findByUsername(String username);
	Users findByUsernameAndPassword(String username, String password);

}