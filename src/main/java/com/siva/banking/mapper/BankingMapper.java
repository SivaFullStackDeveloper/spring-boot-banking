package com.siva.banking.mapper;

import com.siva.banking.Entity.Banking;
import com.siva.banking.dto.BankingDto;

public class BankingMapper {
    public static Banking bankingMapper(BankingDto bankingDto){
        return new Banking(
                bankingDto.id(),
                bankingDto.accountHolderName(),
                bankingDto.balance()
        );
    }

    public static BankingDto bankingDtoMapper(Banking banking){
        return new BankingDto(
                banking.getId(),
                banking.getAccountHolderName(),
                banking.getBalance()
        );
    }
}
