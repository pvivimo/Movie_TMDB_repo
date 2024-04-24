package pv.sb_tmdb_mvc.model;

import java.util.List;

public class TMDBMovieCountryReleases {
	
	private int id;
	private List<TMDBCountryRelease> results;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<TMDBCountryRelease> getResults() {
		return results;
	}
	public void setResults(List<TMDBCountryRelease> results) {
		this.results = results;
	}
	
	

}
