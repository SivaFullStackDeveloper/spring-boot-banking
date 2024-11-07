package com.siva.banking.service;

import com.siva.banking.dto.BankingDto;


import java.util.List;


public interface BankingService {
    BankingDto createAccount(BankingDto bankingDto);
    BankingDto getAccount(Long id);
    List<BankingDto> getAllAccounts();
    BankingDto updateAccount(BankingDto bankingDto,Long id);
    void deleteAccount(Long id);
    BankingDto withDrawAmount(Long id,double amount);
    BankingDto depositAmount(Long id,double amount);
}
