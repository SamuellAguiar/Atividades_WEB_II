package org.example.user.domain.usecase;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.user.domain.UserDomain;

@AllArgsConstructor
@RequiredArgsConstructor
public class CreateUserUsecase {

    UserDomain userDomain;

    public void validate(){
        //*  Regras de negócio da aplicação
        validateName();

    }

    private void validateName(){
        if(this.userDomain.getName() == null){
            throw new RuntimeException("Onde está o nome?");
        }
    }
}
