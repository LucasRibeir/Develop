package api.rest.movie.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="movie")

public class Movie implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=50)
	@NotEmpty(message="o nome nao pode ser Vazio")
	@NotNull(message="o nome nao pode ser nulo")
	private String name;

	@Column(length=50)
    private String title;

	private String releseDate;
	@Column(length=50)
    private String genre;
	
	@Column(length=50)
    private String overview;
	
	@Column(length=50)
	private String image;
	
	@Column(length=50)
	private String Rating;
	
	private List<Movie> movies;

	public List<Movie> getMovies() {

		return movies;

	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;

	}

	public Long getId() {
		return id;

	}

	public void setId(Long id) {
		this.id = id;

	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;

	}

	public String getTitle() {
		return title;

	}

	public void setTitle(String title) {
		this.title = title;

	}

	public String getReleseDate() {
		return releseDate;

	}

	public void setReleseDate(String releseDate) {
		this.releseDate = releseDate;

	}

	public String getGenre() {
		return genre;

	}

	public void setGenre(String genre) {
		this.genre = genre;

	}

	public String getOverview() {
		return overview;

	}

	public void setOverview(String overview) {
		this.overview = overview;

	}

	public String getImage() {
		return image;

	}

	public void setCover(String image) {
		this.image = image;

	}

	public String getRating() {
		return Rating;

	}

	public void setRating(String rating) {
		Rating = rating;

	}

	public static long getSerialversionuid() {
		return serialVersionUID;

	}

	public Movie() {super();

	//TODO Auto-generated constructor stub

	}

	public Movie(Long id,

			@NotEmpty(message = "o nome nao pode ser Vazio") @NotNull(message = "o nome nao pode ser nulo") String name,
			String title, String releseDate, String genre, String overview, String image, String rating) {

		super();

		this.id = id;
		this.name = name;
		this.title = title;
		this.releseDate = releseDate;
		this.genre = genre;
		this.overview = overview;
		this.image = image;
		Rating = rating;

	}

}