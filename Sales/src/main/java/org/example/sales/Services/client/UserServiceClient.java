package org.example.sales.Services.client;

import java.util.List;

import org.example.sales.dtos.externals.users.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name =  "users-service")
public interface UserServiceClient {

    @GetMapping("/users")
    List<UserDTO> getAllUsers();
}
