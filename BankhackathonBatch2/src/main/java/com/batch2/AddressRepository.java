package com.batch2;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer>,JpaRepository<Address, Integer> {
   @Query("select max(a.add_id) from Address a ")
   Integer getAddressId();
}

   