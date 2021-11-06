package br.com.letscode.spring.grupoamatividadefinal.rest;

import br.com.letscode.spring.grupoamatividadefinal.client.ArtistDetail;
import br.com.letscode.spring.grupoamatividadefinal.client.MusicMinimalRestRepository;
import br.com.letscode.spring.grupoamatividadefinal.client.ResultSearch;
import br.com.letscode.spring.grupoamatividadefinal.client.TrackDetail;
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
            ResultSearch resultSearch = this.restRepository.search(title);
            return resultSearch;
    }

    //http://localhos:8080/artist/{id}
    @GetMapping("/artist/{id}")
    public ArtistDetail artist(@PathVariable("id") String id) {
        return this.restRepository.artist(id);
    }

    //http://localhos:8080/track/{id}
    @GetMapping("/track/{id}")
    public TrackDetail track(@PathVariable("id") String id) {
        return this.restRepository.track(id);
    }
}
