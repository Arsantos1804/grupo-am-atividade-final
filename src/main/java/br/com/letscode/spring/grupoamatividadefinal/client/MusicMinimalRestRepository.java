package br.com.letscode.spring.grupoamatividadefinal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "musicMinimalRest", url = "${deezerapi.url}")
public interface MusicMinimalRestRepository {

    @GetMapping("/search")
    ResultSearch search(@RequestParam("q") String search);

    @GetMapping("/artist/{id}")
    ArtistDetail artist(@PathVariable("id") String id);

    @GetMapping("/track/{id}")
    TrackDetail track(@PathVariable("id") String id);
}
