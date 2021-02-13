package amanda.projeto.rest.api.controller;

import amanda.projeto.rest.api.model.MovieModel;
import amanda.projeto.rest.api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping(path = "/api/movie/{id}")
    public ResponseEntity consultar(@PathVariable("id") Integer id){

        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/movie")
    public MovieModel salvar(@RequestBody MovieModel movie){
        return repository.save(movie);
    }

    @PutMapping(path = "/api/movie/{id}")
    public MovieModel atualizar(@PathVariable("id") Integer id, @RequestBody MovieModel movie){

        MovieModel savedMovie = repository.findById(id).get();
        savedMovie.setGenre(movie.getGenre());
        savedMovie.setName(movie.getName());
        savedMovie.setPoints(movie.getPoints());
        return repository.save(savedMovie);
    }

    @PatchMapping(path = "/api/movie/{id}")
    public MovieModel avaliar(@PathVariable("id") Integer id, @RequestParam("points") Integer points){
        MovieModel savedMovie = repository.findById(id).get();
        savedMovie.setPoints(points);
        return repository.save(savedMovie);
    }


    @DeleteMapping(path = "/api/movie/{id}")
    public void deletar(@PathVariable("id") Integer id){

        repository.deleteById(id);
    }

    @GetMapping(path = "/api/movie")
    public List<MovieModel> listar(){

        return repository.findAll();
    }


}
