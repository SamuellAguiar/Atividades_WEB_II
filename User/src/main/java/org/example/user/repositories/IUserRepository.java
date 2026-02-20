package org.example.user.repositories;

import org.example.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserModel, UUID> { //* Extende de JpaRepository construindo o modelo UserModel com prikey UUID */

    List<UserModel> findByName(String name);
    List<UserModel> findByCity(String city);

    List<UserModel> findAllByNameContainingIgnoreCase(String name); //* Permite consultas ao banco de dados com multiplos argumentos */

    //!! Implementar um retorno com a cidade
}
