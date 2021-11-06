package br.com.letscode.spring.grupoamatividadefinal.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Value;

@Value
public class ResultSearch {

    List<MusicMinimal> resultList;
    int total;
    String next;
    String prev;

    @JsonCreator
    public ResultSearch(
        @JsonProperty("data") List<MusicMinimal> resultList,
        @JsonProperty("total") String total,
        @JsonProperty("prev") String prev,
        @JsonProperty("next") String next
        ){
        this.resultList = resultList;
        this.total = Integer.parseInt(total);
        this.prev = prev;
        this.next = next;
    }
}
