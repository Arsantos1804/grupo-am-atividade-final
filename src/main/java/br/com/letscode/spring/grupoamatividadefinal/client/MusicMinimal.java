package br.com.letscode.spring.grupoamatividadefinal.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class MusicMinimal{

    int id;
    ArtistDetail artist;
    String title;
    String image;

    @JsonCreator
    public MusicMinimal(
            @JsonProperty("id") int id,
            @JsonProperty("artist") ArtistDetail artist,
            @JsonProperty("title") String title,
            @JsonProperty("md5_image") String image
            ) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.image = image;
    }
}
