package org.example.user.domain.usecase;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class UpdateUserPasswordUseCase {

    private String emailModel;
    private String emailPassed;
    private String oldPasswordModel;
    private String oldPasswordPassed;

    public void validate(){
        validateEmail();
        validateOldPassword();
    }

    public void validateEmail(){
        if (!emailModel.equals(emailPassed)){
            throw new RuntimeException("Invalid email");
        }
    }

    private void validateOldPassword(){
        if (!oldPasswordModel.equals(oldPasswordPassed)){
            throw new RuntimeException("Invalid password");
        }
    }
}
