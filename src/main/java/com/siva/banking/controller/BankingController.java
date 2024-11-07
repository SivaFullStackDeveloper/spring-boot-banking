package com.siva.banking.controller;

import com.siva.banking.dto.BankingDto;
import com.siva.banking.service.BankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankingController {
    private  BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping("/createAccount")
    public ResponseEntity<BankingDto> createAccount(@RequestBody BankingDto bankingDto) {
        BankingDto savedBanking = bankingService.createAccount(bankingDto);
        return new ResponseEntity<>(savedBanking, HttpStatus.CREATED);
    }


    @GetMapping("/getAccount/{myId}")
    public ResponseEntity<BankingDto> getAccount(@PathVariable Long myId) {
        BankingDto savedBanking = bankingService.getAccount(myId);
        return new ResponseEntity<>(savedBanking, HttpStatus.CREATED);
    }
    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<BankingDto>> getAllAccounts() {
        List<BankingDto> savedBanking = bankingService.getAllAccounts();
        return new ResponseEntity<>(savedBanking, HttpStatus.OK);
    }

    @PutMapping("/updateAccount/{id}")
    public ResponseEntity<BankingDto> updateAccount(@RequestBody BankingDto bankingDto,Long id) {
        BankingDto savedBanking = bankingService.updateAccount(bankingDto,id);
        return new ResponseEntity<>(savedBanking, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(Long id) {
        bankingService.deleteAccount(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }

    @PutMapping("/withdraw/{id}")
    public ResponseEntity<BankingDto> withdraw(@RequestBody double amount,@PathVariable Long id) {
        BankingDto savedBanking = bankingService.withDrawAmount(id,amount);
        return new ResponseEntity<>(savedBanking, HttpStatus.OK);
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<BankingDto> deposit(@RequestBody double amount,@PathVariable Long id) {
        BankingDto savedBanking = bankingService.depositAmount(id,amount);
        return new ResponseEntity<>(savedBanking, HttpStatus.OK);
    }
}
