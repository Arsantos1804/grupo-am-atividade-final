package br.com.letscode.spring.grupoamatividadefinal.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class MusicDetail {

    String nomeArtista;
    String nomeMusica;
    String album;
    Integer idMusica;
    String type;

    @JsonCreator
    public MusicDetail(String title, String nomeArtista, String nomeMusica, String album
                       @JsonProperty("deezerRating") Integer idMusica, @JsonProperty("imdbVotes"),
                       String type) {

        // ver json com Almir

        this.nomeArtista = nomeArtista;
        this.nomeMusica = nomeMusica;
        this.album = album;
        this.idMusica = idMusica;
        this.type = type;
    }
}
