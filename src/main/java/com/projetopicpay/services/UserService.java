package com.projetopicpay.services;

import com.projetopicpay.domain.user.User;
import com.projetopicpay.domain.user.UserType;
import com.projetopicpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {

        if (UserType.MERCHANT.equals(sender.getUserType())){
            throw new Exception("Usuário do tipo lojista não autoriazado a realizar transações.");
        }

        if (sender.getBalance().compareTo(amount) < 0 ){
            throw new Exception("Saldo Insuficiente.");
        }
    }

    public User findUserById(Long id) throws Exception {
       return this.repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    public void saveUser(User user){
        this.repository.save(user);
    }
}
