package com.siva.banking.impl;

import com.siva.banking.Entity.Banking;
import com.siva.banking.dto.BankingDto;
import com.siva.banking.mapper.BankingMapper;
import com.siva.banking.repository.BankingRepository;
import com.siva.banking.service.BankingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankingImpl implements BankingService {
    private  BankingRepository bankingRepository;

    public BankingImpl(BankingRepository bankingRepository) {
        this.bankingRepository = bankingRepository;
    }

    @Override
    public BankingDto createAccount(BankingDto bankingDto) {
        Banking banking = BankingMapper.bankingMapper(bankingDto);
        Banking savedAccount =  bankingRepository.save(banking);
        return BankingMapper.bankingDtoMapper(savedAccount);
    }

    @Override
    public BankingDto getAccount(Long id) {
        Banking account =  bankingRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found" + id));
        return BankingMapper.bankingDtoMapper(account);
    }

    @Override
    public List<BankingDto> getAllAccounts() {
        List<Banking> account =  bankingRepository.findAll();
        return account.stream().map(BankingMapper::bankingDtoMapper).collect(Collectors.toList());
    }

    @Override
    public BankingDto updateAccount(BankingDto bankingDto, Long id) {
        Banking account =  bankingRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found" + id));
        account.setAccountHolderName(bankingDto.getAccountHolderName());
        account.setBalance(bankingDto.getBalance());
        Banking updated = bankingRepository.save(account);
        return BankingMapper.bankingDtoMapper(updated);
    }

    @Override
    public void deleteAccount(Long id) {
        Banking account =  bankingRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found" + id));
        bankingRepository.deleteById(account.getId());

    }

    @Override
    public BankingDto depositAmount(Long id,double amount) {
        Banking account =  bankingRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found" + id));
        double totalAmount = account.getBalance()+amount;
        account.setBalance(totalAmount);
        Banking updated = bankingRepository.save(account);
        return  BankingMapper.bankingDtoMapper(updated);
    }

    @Override
    public BankingDto withDrawAmount(Long id,double amount) {
        Banking account =  bankingRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found" + id));
        double totalAmount = account.getBalance()-amount;
        account.setBalance(totalAmount);
        Banking updated = bankingRepository.save(account);
        return  BankingMapper.bankingDtoMapper(updated);
    }
}
