package br.com.letscode.spring.grupoamatividadefinal.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class TrackDetail {
    int id;
    String name;
    String duration;
    String preview;
    String image;
    ArtistDetail artist;

    @JsonCreator
    public TrackDetail(
            @JsonProperty("id") int id,
            @JsonProperty("title") String name,
            @JsonProperty("duration") String duration,
            @JsonProperty("preview") String preview,
            @JsonProperty("md5_image") String image,
            @JsonProperty("artist") ArtistDetail artist
             ){
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.preview = preview;
        this.image = image;
        this.artist = artist;
    }
}
