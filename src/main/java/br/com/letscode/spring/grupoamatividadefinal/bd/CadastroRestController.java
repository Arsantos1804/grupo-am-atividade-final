package br.com.letscode.spring.grupoamatividadefinal.bd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@RequestMapping("categories")
@RestController
public class CadastroRestController {

    private final CadastroRepository repository;

    @GetMapping("/teste")
    public Cadastro cadastro(){
        return repository.cadastro("Almir");
    }

    public CadastroRestController(CadastroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/count")
    public Long count() {
        return this.repository.count();
    }

}
