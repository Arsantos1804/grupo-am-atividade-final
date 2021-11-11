package br.com.letscode.spring.grupoamatividadefinal.bd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@RequestMapping("categories")
@Controller
public class CadastroRestController {

    private final CadastroRepository repository;

    @PostMapping("/registration-ok")
    public String registrationOk(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password){
        System.out.println("Nome" + name + "email" + email + "password" + password);
        repository.cadastro(name, email, password);
        return "redirect:/home";
    }
    
    @PostMapping("/login-ok")
    public String loginOk(@RequestParam("email") String email, @RequestParam("password") String password){
        Cadastro cadastro = repository.login(email, password);
        System.out.println("email" + email + "password" + password);
        System.out.println("email" + cadastro.getEmail() + "password" + cadastro.getPassword());
        if (cadastro != null){
            return "redirect:/home";
        }
        return "redirect:/login-error";
    }

   /* @GetMapping("/teste")
    public Cadastro cadastro(){
        return repository.cadastro("Almir");
    }*/

    public CadastroRestController(CadastroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/count")
    public Long count() {
        return this.repository.count();
    }

}
