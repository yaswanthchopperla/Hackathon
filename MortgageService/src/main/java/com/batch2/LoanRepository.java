package com.batch2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer>{
   @Query("select i from Items i where i.score=?1")
   Items getItem(double score);
   @Query("select i.amount from Items i where i.item_id=?1")
   double getApprovedAmountByItemId(int id);
   
   @Query("select i.loanamount from Loan i where i.id=?1")
   double getAppliedAmountByLoanId(int id); 
}
