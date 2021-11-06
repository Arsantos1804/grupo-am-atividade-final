package br.com.letscode.spring.grupoamatividadefinal.rest;

import br.com.letscode.spring.grupoamatividadefinal.client.MusicDetail;
import br.com.letscode.spring.grupoamatividadefinal.client.MusicMinimalRestRepository;
import br.com.letscode.spring.grupoamatividadefinal.client.ResultSearch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchRestController {

    private final MusicMinimalRestRepository restRepository;

    public SearchRestController(MusicMinimalRestRepository restRepository) {
        this.restRepository = restRepository;
    }

    // http://localhos:8080/search?title=
    @GetMapping("/search")
    public ResultSearch search(@RequestParam String title) {
            final ResultSearch resultSearch = this.restRepository.search(title);
            return resultSearch;

    }

    @GetMapping("/music/{id}")
    public MusicDetail detail(@PathVariable String id) {
        return this.restRepository.detail(id);
    }

}
