package br.com.letscode.spring.grupoamatividadefinal.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Cadastro (name, email, password) VALUES (:name, :email, :password)", nativeQuery = true)
    void cadastro(String name, String email, String password);

    @Query(value = "SELECT * FROM Cadastro where email= :email and password= :password", nativeQuery = true)
    Cadastro login(String email, String password);
}
