package amanda.projeto.rest.api.repository;

import amanda.projeto.rest.api.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Integer> {

}
