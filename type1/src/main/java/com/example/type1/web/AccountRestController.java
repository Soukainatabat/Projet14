package com.example.type1.web;

import com.example.type1.entities.BankAccount;
import com.example.type1.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    @GetMapping("/bankAccount")
    public List<BankAccount> bankAccount(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccount/{id}")
    public BankAccount bankAccontID( @PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account not found")));

    }
    /*@PostMapping("/bankAccounts")
       public BankAccountResponseDTO save(@RequestBody BankAccountRepository requestDTO){
          return acc
    }*/
    @DeleteMapping("/bankAccounts/{id}")
    public void Delete(@PathVariable String id){
        bankAccountRepository.deleteById(id);

    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@RequestBody BankAccount bankAccount , @PathVariable String id ){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow();
        if (bankAccount.getBalance()!=null )account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCurrency()!=null )account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType()!=null )account.setType(bankAccount.getType());
        if (bankAccount.getCreatedAt()!=null )account.setCreatedAt(new Date());
        return bankAccountRepository.save(account);
    }
}
