package br.com.letscode.spring.grupoamatividadefinal.client;

import static java.lang.Boolean.valueOf;
import static java.lang.Integer.parseInt;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class ResultSearch {

    List<MusicMinimal> resultList;
    Integer total;
    Boolean response;

    @JsonCreator
    public ResultSearch(
        @JsonProperty("Search") List<MusicMinimal> resultList,
        @JsonProperty("totalResults") String total,
        @JsonProperty("Response") String response) {
        this(resultList, parseInt(total), valueOf(response));
    }

}
