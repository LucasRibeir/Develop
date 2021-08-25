package api.rest.movie.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import api.rest.movie.entity.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}