package br.com.letscode.spring.grupoamatividadefinal.bd;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="PLAYLIST")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String idMusic;

    @ManyToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro idCadastroPlaylist;
}
