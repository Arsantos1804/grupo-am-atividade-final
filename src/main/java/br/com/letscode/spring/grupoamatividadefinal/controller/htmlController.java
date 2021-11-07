package br.com.letscode.spring.grupoamatividadefinal.controller;

import br.com.letscode.spring.grupoamatividadefinal.client.MusicMinimalRestRepository;
import br.com.letscode.spring.grupoamatividadefinal.client.ResultSearch;
import br.com.letscode.spring.grupoamatividadefinal.client.TrackDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class htmlController {

    private final MusicMinimalRestRepository resultSearch;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/searchMusic")
    public String search(@RequestParam("search") Optional<String> search, Model model) {
        search.ifPresent(s -> model.addAttribute("tracks", this.searchTrack(s)));
        return "search";
    }
    public List<TrackDetail> searchTrack(String title) {
        ResultSearch resultSearch = this.resultSearch.search(title);
        final List<TrackDetail> list = resultSearch.getResultList().stream()
                .map(minimal -> this.resultSearch.track(String.valueOf(minimal.getId())))
                .collect(Collectors.toList());
        return list;
    }
}
