package br.com.letscode.spring.grupoamatividadefinal.bd;

import br.com.letscode.spring.grupoamatividadefinal.controller.CookieController;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CadastroRestController {

    private final CadastroRepository repository;
    CookieController cookie;

    @PostMapping("/registration-ok")
    public String registrationOk(@RequestParam("name") String name, @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 HttpServletResponse response,
                                 @CookieValue(value = "username", defaultValue = "logado") String username){
        repository.cadastro(name, email, password);
        cookie.setCookie(response, username);

        return "redirect:/index";
    }
    
    @PostMapping("/login-ok")
    public String loginOk(@RequestParam("email") String email,
                          @RequestParam("password") String password,
                          HttpServletResponse response,
                          @CookieValue(value = "username", defaultValue = "logado") String username){
        Optional<Cadastro> cadastro = repository.login(email, password);
        System.out.println("email" + email + "password" + password);
        cadastro.ifPresent(c -> System.out.println("email" + c.getEmail() + "password" + c.getPassword()));

        if (cadastro.isPresent()){
            cookie.setCookie(response, username);
            return "redirect:/index";
        }
        return "redirect:/login-error";
    }
}
