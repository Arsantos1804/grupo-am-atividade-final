package br.com.letscode.spring.grupoamatividadefinal.controller;

import br.com.letscode.spring.grupoamatividadefinal.client.MusicMinimalRestRepository;
import br.com.letscode.spring.grupoamatividadefinal.client.ResultSearch;
import br.com.letscode.spring.grupoamatividadefinal.client.TrackDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class htmlController {

    private final MusicMinimalRestRepository resultSearch;

    @GetMapping
    public String index(@CookieValue(value = "username", defaultValue = "logout") String username) {
        if ( username.equals( "logout" ) ) return "redirect:/login";
        return "index";
    }

    @GetMapping("/index")
    public String home(@CookieValue(value = "username", defaultValue = "logout") String username) {
        if ( username.equals( "logout" ) ) return "redirect:/login";
        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/searchMusic")
    public String search(@RequestParam("search") Optional<String> search,
                         Model model,
                         @CookieValue(value = "username", defaultValue = "logout") String username,
                         @RequestParam(value = "index", defaultValue = "0") int index) {
        if ( username.equals( "logout" ) ) return "redirect:/login";

        search.ifPresent(s -> model.addAttribute("tracks", this.searchTrack(s, index)));
        model.addAttribute("index", index);
        model.addAttribute("search", search.get());
        return "search";
    }

    public List<TrackDetail> searchTrack(String title, int index) {
        ResultSearch resultSearch = this.resultSearch.search(title, index, 10);
        final List<TrackDetail> list = resultSearch.getResultList().stream()
                .map(minimal -> this.resultSearch.track(String.valueOf(minimal.getId())))
                .collect(Collectors.toList());
        return list;
    }

    @GetMapping("/trackMusic")
    public String trackMusic(@RequestParam("track") String search, Model model,
                         @CookieValue(value = "username", defaultValue = "logout") String username) {
        if ( username.equals( "logout" ) ) return "redirect:/login";

        model.addAttribute("track", this.resultSearch.track(search));
        return "track";
    }
}