package br.com.letscode.spring.grupoamatividadefinal.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Value;

@Value
public class MusicMinimal {

    String imdbId;
    String title;
    String year;

    @JsonCreator
    public MusicMinimal(String imdbId, String title, String year) {
        this.imdbId = imdbId;
        this.title = title;
        this.year = year;
    }

}
