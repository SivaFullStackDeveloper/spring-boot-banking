package com.siva.banking.repository;
import com.siva.banking.Entity.Banking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingRepository extends JpaRepository<Banking,Long> {
}
