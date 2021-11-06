package br.com.letscode.spring.grupoamatividadefinal.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ArtistDetail {
    int id;
    String name;
    String picture;

    @JsonCreator
    public ArtistDetail(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("picture_big") String picture
        ){
        this.id = id;
        this.name = name;
        this.picture = picture;
    }
}
