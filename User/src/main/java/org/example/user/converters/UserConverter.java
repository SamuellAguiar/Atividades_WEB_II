package org.example.user.converters;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.user.domain.UserDomain;
import org.example.user.dtos.CreateUserDTO;
import org.example.user.dtos.UpdateUserDTO;
import org.example.user.dtos.UserRecordDTO;
import org.example.user.models.UserModel;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserConverter {

    public static UserRecordDTO toUserRecordDTO(UserModel userModel){
        return new UserRecordDTO(userModel.getId(), userModel.getName(), userModel.getEmail(), userModel.getCreditCardNetworkModel());
    }

    public static UserModel touUserModel(UserDomain userDomain){
        return UserModel.builder().id(userDomain.getId()).name(userDomain.getName()).creditCardNumber(userDomain.getCreditCardNumber()).email(userDomain.getEmail()).password(userDomain.getPassword()).city(userDomain.getCity()).creditCardNetworkModel(null).build();
    }

    public static UserDomain toUserDomain(CreateUserDTO createUserDTO){
        return UserDomain.builder().name(createUserDTO.getName()).creditCardNumber(createUserDTO.getCreditCardNumber()).email(createUserDTO.getEmail()).password(createUserDTO.getPassword()).city(createUserDTO.getCity()).build();
    }

    public static UserDomain toUserDomain(UpdateUserDTO updateUserDTO) {
        return UserDomain.builder().id(updateUserDTO.getId()).creditCardNumber(updateUserDTO.getCreditCardNumber()).build();
    }


}
