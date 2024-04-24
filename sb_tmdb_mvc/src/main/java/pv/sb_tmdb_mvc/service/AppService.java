package pv.sb_tmdb_mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pv.sb_tmdb_mvc.dto.CountryReleaseDto;
import pv.sb_tmdb_mvc.dto.GenreDto;
import pv.sb_tmdb_mvc.dto.GenreListDto;
import pv.sb_tmdb_mvc.dto.MovieCountryReleasesDto;
import pv.sb_tmdb_mvc.dto.MovieDto;
import pv.sb_tmdb_mvc.dto.ReleaseDateAndTypeDto;
import pv.sb_tmdb_mvc.model.Genre;
import pv.sb_tmdb_mvc.model.Movie;
import pv.sb_tmdb_mvc.model.TMDBCountryRelease;
import pv.sb_tmdb_mvc.model.TMDBGenreResult;
import pv.sb_tmdb_mvc.model.TMDBMovieCountryReleases;
import pv.sb_tmdb_mvc.model.TMDBMovieResult;
import pv.sb_tmdb_mvc.model.TMDBReleaseDateAndType;

@Service
public class AppService {
	
	private static final String TMDB_API_KEY = "c1fa0cf3eda97ff6dbd2a15bf9e29f75";

	public MovieDto getMovieById(int movieId) {
		
		MovieDto movieDto = null;
		
		RestTemplate rt = new RestTemplate();
		Movie movie = rt.getForObject(
				"https://api.themoviedb.org/3/movie/" + 
				movieId + "?api_key=" + TMDB_API_KEY, 
				Movie.class);
		
		movieDto = convertMovieToMovieDto(movie);
				
		
		return movieDto;
	}

	private MovieDto convertMovieToMovieDto(Movie movie) {
		
		MovieDto movieDto = null;
		movieDto = new MovieDto(
					movie.getId(),
					movie.getOriginal_title(),
					movie.getOverview(), 
					movie.getGenre_ids()
					
				);
		
		return movieDto;
	}

	public MovieDto getMovieByTitle(String movieTitle) {

		MovieDto movieDto = null;
		
		RestTemplate rt = new RestTemplate();
		TMDBMovieResult movieResult = rt.getForObject(
				"https://api.themoviedb.org/3/search/movie?query=" + movieTitle + "&api_key=c1fa0cf3eda97ff6dbd2a15bf9e29f75", 
				TMDBMovieResult.class);
		
		List<Movie> movies = movieResult.getResults();
		if(movies.size() > 0) {
			
			Movie movie = movieResult.getResults().get(0);
			movieDto = convertMovieToMovieDto(movie);			
		}		
		
		return movieDto;
	}

	public GenreListDto getGenres() {

		GenreListDto genreListDto = null;
		
		RestTemplate rt = new RestTemplate();
		TMDBGenreResult genreResult = rt.getForObject("https://api.themoviedb.org/3/genre/movie/list?api_key=c1fa0cf3eda97ff6dbd2a15bf9e29f75", 
				TMDBGenreResult.class);
		 
		List<GenreDto> genreDtos = new ArrayList<>();
		List<Genre> genres = genreResult.getGenres();
		for(int index = 0; index < genres.size(); index++) {
			
			Genre currentGenre = genres.get(index);
			GenreDto genreDto = new GenreDto(
						currentGenre.getId(),
						currentGenre.getName()
				
					);
			genreDtos.add(genreDto);
		}
		genreListDto = new GenreListDto(genreDtos);
		
		return genreListDto;
	}

	public MovieCountryReleasesDto getMovieCountriesAndReleases(int movieId) {
		
		MovieCountryReleasesDto movieCountryReleasesDto = null;
		
		RestTemplate rt = new RestTemplate();		
		TMDBMovieCountryReleases mcr = rt.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "/release_dates?api_key=c1fa0cf3eda97ff6dbd2a15bf9e29f75",
		TMDBMovieCountryReleases.class);
		
		
		List<TMDBCountryRelease> tmdbCountryReleaseList = mcr.getResults();
		List<CountryReleaseDto> countryReleaseDtoList = new ArrayList<>();
		for(int index_tmdbCountryReleaseList = 0; index_tmdbCountryReleaseList < tmdbCountryReleaseList.size(); index_tmdbCountryReleaseList++) {
			
			TMDBCountryRelease currentTMDBCountryRelease = tmdbCountryReleaseList.get(index_tmdbCountryReleaseList);
			
			
			List<TMDBReleaseDateAndType> tmdbReleaseDateAndTypeList = currentTMDBCountryRelease.getRelease_dates();
			List<ReleaseDateAndTypeDto> releaseDateAndTypeDtoList = new ArrayList<>();
			for(int index_tmdbReleaseDateAndTypeList = 0; index_tmdbReleaseDateAndTypeList < tmdbReleaseDateAndTypeList.size(); index_tmdbReleaseDateAndTypeList++) {
				
				TMDBReleaseDateAndType tmdbReleaseDateAndType = tmdbReleaseDateAndTypeList.get(index_tmdbReleaseDateAndTypeList);
				
				/** ReleaseDate --> ReleaseDateDto */
				ReleaseDateAndTypeDto releaseDto = new ReleaseDateAndTypeDto(
							tmdbReleaseDateAndType.getRelease_date(),
							tmdbReleaseDateAndType.getType()
						);
				releaseDateAndTypeDtoList.add(releaseDto);
			}
			
			
			/** Country --> CountryDto */
			CountryReleaseDto countryReleaseDto = new CountryReleaseDto(
						currentTMDBCountryRelease.getIso_3166_1(),
						releaseDateAndTypeDtoList
					);
			countryReleaseDtoList.add(countryReleaseDto);
		}
		
		
		/** MovieCountryReleases --> MovieCountryReleasesDto */
		movieCountryReleasesDto = new MovieCountryReleasesDto(
					movieId,
					countryReleaseDtoList
				);
		
		return movieCountryReleasesDto;
	}

	
	

//	public UserDto getUserById(int userId) {
//
//		UserDto userDto = null;
//		
//		User user = db.getUserById(userId);
//		
//		List<MovieDto> movieDtos = new ArrayList<>();
//		
//		for(int index = 0; index < user.getSeenMovieIds().size(); index++) {
//			
//			RestTemplate rt = new RestTemplate();
//			Movie movie = rt.getForObject(
//					"https://api.themoviedb.org/3/movie/" + user.getSeenMovieIds().get(index) + "?api_key=c1fa0cf3eda97ff6dbd2a15bf9e29f75",
//					Movie.class);
//			
//			MovieDto movieDto = convertMovieToMovieDto(movie);
//			movieDtos.add(movieDto);
//			
//		}
//		
//		userDto = new UserDto(
//				user.getId(),
//				user.getName(),
//				user.getAge()
//				
//				)
//				
//				
//		return userDto;
//	}
//	
//		
//		public MovieDtoList getFristTenMovieByTitle(String mTitle) {
//	}
//	

}
