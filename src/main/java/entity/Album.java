package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private String price;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "plays")
    private String plays;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Track> tracks = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Artist> artists = new ArrayList<>();

    public Album(String title, String price, String releaseDate, String plays) {
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
        this.plays = plays;
    }
}
