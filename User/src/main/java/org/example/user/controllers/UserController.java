package org.example.user.controllers;

import java.util.List;

import org.example.user.dtos.*;
import org.example.user.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/port")
    public ResponseEntity<String> getState() {
        return ResponseEntity.ok("EndPoint on PORT 3000");
    }

    @GetMapping
    public ResponseEntity <List<UserRecordDTO>> getAllUsers() {

        List<UserRecordDTO> userList = userService.getAllUsers();

        return ResponseEntity.ok(userList);
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus(){
        return ResponseEntity.ok("Service is running");
    }

    @PostMapping
    public ResponseEntity<UserRecordDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        UserRecordDTO userRecordDTO =  userService.createUser(createUserDTO);
        return ResponseEntity.ok(userRecordDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRecordDTO> getUserById(@PathVariable(value = "id")String id){ //* Lista os usuários pelo respectivo ID */
        UserRecordDTO userRecord = userService.getUserById(id);

        if(userRecord == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userRecord);
    }

    @GetMapping("/byname/{name}")
    public ResponseEntity <List<UserRecordDTO>> getUserByName(@PathVariable(value = "name")String name){

        List<UserRecordDTO> username = userService.getUserByName(name);
        return ResponseEntity.ok(username);
    }

    @GetMapping("/bycity/{city}")
    public ResponseEntity <List<UserRecordDTO>> getUserByCity(@PathVariable(value = "city")String city){
        return null; //!! Alterar e retornar de acordo com a cidade
    }

    @PutMapping
    public ResponseEntity<UserRecordDTO> updateUser(@RequestBody UpdateUserDTO updateUserDTO){

        UserRecordDTO userRecordDTO = userService.updateUser(updateUserDTO);

        if (userRecordDTO == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userRecordDTO);
    }

    @PutMapping("/password") //* Atendendo mudanças de apenas um campos do usuário */
    public ResponseEntity<UserRecordDTO> updateUserPassword(@RequestBody UpdateUserPasswordDTO updateUserPasswordDTO){

        UserRecordDTO userRecordDTO = userService.updatePassword(updateUserPasswordDTO);

        if (userRecordDTO == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userRecordDTO);
    }

    @PutMapping("/credit_card")
    public ResponseEntity<UserRecordDTO> updateCreditCard(@RequestBody UpdateUserCreditCardDTO updateUserCreditCardDTO) {

        UserRecordDTO userRecordDTO = userService.updateCreditCard(updateUserCreditCardDTO);
        if (userRecordDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userRecordDTO);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Object> deleteUser(@RequestBody DeleteUserDTO deleteUserDTO){
        userService.deleteUser(deleteUserDTO);
        return ResponseEntity.ok("User has been deleted");
    }
}
