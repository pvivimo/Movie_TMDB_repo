package pv.sb_tmdb_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import pv.sb_tmdb_mvc.dto.GenreListDto;
import pv.sb_tmdb_mvc.dto.MovieCountryReleasesDto;
import pv.sb_tmdb_mvc.dto.MovieDto;
import pv.sb_tmdb_mvc.service.AppService;

@Controller
public class AppController {
	
	private AppService service;
	
	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/")
	public String index() {
		
		return "index.html";
	}
	
	@GetMapping("/movie/search")
	public String showMovieByTitle(
				Model model,
				@RequestParam("title") String movieTitle			
			) {
		
		MovieDto dto = service.getMovieByTitle(movieTitle);
		model.addAttribute("moviedto", dto);
		
		return "movie.html";
		
	}
	
	@GetMapping("/movie/{movieid}")
	public String showMovie(
				Model model,
				@PathVariable("movieid") int movieId			
			) {
		
		MovieDto dto = service.getMovieById(movieId);
		model.addAttribute("moviedto", dto);
		
		return "movie.html";
	}
		
	@GetMapping("/movie/genres")
	public String showGenresOfMovie(Model model) {
		
		GenreListDto genreListDto = service.getGenres();
		model.addAttribute("genrelistdto", genreListDto);
		
		return "genres.html";
	}
	
	
	@GetMapping("/movie/releases")
	public String showMovieCountriesAndReleases(
				Model model,
				@RequestParam("movieid") int movieId			
			) {
		
		MovieCountryReleasesDto movieCountryReleasesDto = service.getMovieCountriesAndReleases(movieId);
		model.addAttribute("moviecountryreleasesdto", movieCountryReleasesDto);
		
		return "releases.html";
	}
	
	
	
	
	
//	@GetMapping("/movie/usermovies")
//	public String showMoviesFromUser(
//				Model model,
//				@RequestParam("userid") int userId			
//			) {
//		
//		UserDto userDto = service.getUserById(userId);
//		model.addAttribute("userdto", userDto);
//		
//		return "movie.html";
//		
//	}
//	
	
	

}
