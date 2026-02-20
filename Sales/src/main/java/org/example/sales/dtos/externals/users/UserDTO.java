package org.example.sales.dtos.externals.users;

import java.util.UUID;

public record UserDTO(UUID id, String name, String email) {}
