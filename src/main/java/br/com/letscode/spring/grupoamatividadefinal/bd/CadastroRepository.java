package br.com.letscode.spring.grupoamatividadefinal.bd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

    @Query(value = "SELECT * FROM cadastro WHERE name = :name", nativeQuery = true)
    Cadastro cadastro(String name);

    List<Cadastro> findByNameStartingWith(String nameStart);

}
