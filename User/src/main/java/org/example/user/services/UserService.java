package org.example.user.services;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.example.user.Enums.EnumUserType;
import org.example.user.converters.UserConverter;
import org.example.user.domain.UserDomain;
import org.example.user.domain.usecase.CreateUserUsecase;
import org.example.user.domain.usecase.UpdateUserPasswordUseCase;
import org.example.user.dtos.*;
import org.example.user.models.CreditCardNetworkModel;
import org.example.user.models.UserModel;
import org.example.user.repositories.ICreditCardNetworkRepository;
import org.example.user.repositories.IUserRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserService {

    private final IUserRepository userRepository;
    private final ICreditCardNetworkRepository creditCardRepository;

    // GET
    public List<UserRecordDTO> getAllUsers(){
        List<UserModel> userModelList = userRepository.findAll();

        return userModelList.stream().map(UserConverter::toUserRecordDTO).toList();
    }

    // POST
    public UserRecordDTO createUser(CreateUserDTO createUserDTO){
        UserDomain userDomain = UserConverter.toUserDomain(createUserDTO);

        CreateUserUsecase createUserUsecase = new CreateUserUsecase(userDomain);createUserUsecase.validate();

        UserModel userModel = UserConverter.touUserModel(userDomain);

        userModel.setUserType(EnumUserType.CUSTOMER);

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    // GET byId
    public UserRecordDTO getUserById(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<UserModel>optionalUserModel = userRepository.findById(uuid);

        if (optionalUserModel.isEmpty()){
            return null;
        }

        UserModel userModel = optionalUserModel.get();
        return UserConverter.toUserRecordDTO(userModel);
    }

    // GET byUserName
    public List<UserRecordDTO> getUserByName(String name){
        List<UserModel> userModel = userRepository.findAllByNameContainingIgnoreCase(name);

        return userModel.stream().map(UserConverter::toUserRecordDTO).toList();
    }

    // PUT
    public UserRecordDTO updateUser(UpdateUserDTO updateUserDTO) {
        UserDomain userDomain = UserConverter.toUserDomain(updateUserDTO);

        Optional<UserModel> optionalUserDTO = userRepository.findById(updateUserDTO.getId());

        if (optionalUserDTO.isEmpty()){
            return null;
        }

        UserModel userModel = UserConverter.touUserModel(userDomain);

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    // PUT
    public UserRecordDTO updatePassword(UpdateUserPasswordDTO updateUserPasswordDTO) {

        Optional<UserModel> optionalUserPasswordDTO = userRepository.findById(updateUserPasswordDTO.getId());

        UserModel userModel = optionalUserPasswordDTO.get();

        if (optionalUserPasswordDTO.isEmpty()){
            return null;
        }

        UpdateUserPasswordUseCase useCase = new UpdateUserPasswordUseCase(userModel.getEmail(), updateUserPasswordDTO.getEmail(), userModel.getPassword(), updateUserPasswordDTO.getOldPassword());
        useCase.validate();

        userModel.setPassword(updateUserPasswordDTO.getNewPassword());

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    // PUT
    public UserRecordDTO updateCreditCard(UpdateUserCreditCardDTO updateUserCreditCardDTO) {
        Optional<UserModel> optionalUserModel = userRepository.findById(updateUserCreditCardDTO.getId());


        if (optionalUserModel.isEmpty()){
            return null;
        }

        Optional<CreditCardNetworkModel> optCreditCard = creditCardRepository.findById(updateUserCreditCardDTO.getCreditCardId());

        if (optCreditCard.isEmpty()) {
            return null;
        }


        UserModel userModel = optionalUserModel.get();
        CreditCardNetworkModel creditCardNetworkModel = optCreditCard.get();

        userModel.setCreditCardNumber(updateUserCreditCardDTO.getCreditCardNumber());

        userModel.setCreditCardNetworkModel(creditCardNetworkModel);

        return UserConverter.toUserRecordDTO(userRepository.save(userModel));
    }

    // DELETE
    public void deleteUser(DeleteUserDTO deleteUserDTO) {
        Optional<UserModel> optionalUserModel = userRepository.findById(deleteUserDTO.id());

        if (optionalUserModel.isEmpty()){
            throw new RuntimeException("User not found");
        }

        userRepository.delete(optionalUserModel.get());
    }
}
