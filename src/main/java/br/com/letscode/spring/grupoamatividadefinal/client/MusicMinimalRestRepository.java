package br.com.letscode.spring.grupoamatividadefinal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "musicMinimalRest", url = "${omdbapi.url}")
public interface MusicMinimalRestRepository {

    @GetMapping
    ResultSearch search(@RequestParam("s") String musicTitle);

    @GetMapping
    MusicDetail detail(@RequestParam("i") String imdbId);
}
