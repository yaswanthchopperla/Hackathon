package com.batch2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRegisterRepository extends JpaRepository<Login, Integer>{

	
	
	@Query("select l.login_id from Login l where username = ?1 and password = ?2 ")
	Integer approveLogin(String username, String password);
	
	

}
