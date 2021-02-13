package amanda.projeto.rest.api.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;

@Entity(name = "movie")
public class MovieModel {

    @Id
    public Integer id;

    public Integer points;

    @Column(nullable = false, length = 50)
    public String name;

    @Column(nullable = false, length = 30)
    public String genre;

    //______________________________________________________________


    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
