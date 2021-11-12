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

    @GetMapping("/search")
    public ResultSearch search(@RequestParam String title) {
            ResultSearch resultSearch = this.restRepository.search(title, 0, 10);
            return resultSearch;
    }

    @GetMapping("/artist/{id:[\\d]+}")
    public ArtistDetail artist(@PathVariable("id") String id) {
        return this.restRepository.artist(id);
    }

    @GetMapping("/track/{id:[\\d]+}")
    public TrackDetail track(@PathVariable("id") String id) {
        return this.restRepository.track(id);
    }
}
