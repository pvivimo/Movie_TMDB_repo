package pv.sb_tmdb_mvc.dto;

import java.util.List;

public class MovieDto {
	
	private int id;
	private String originalTitle;
	private String overview;
	private List<Integer> genreIds;
	
	public MovieDto(int id, String originalTitle, String overview, List<Integer> genreIds) {
		super();
		this.id = id;
		this.originalTitle = originalTitle;
		this.overview = overview;
		this.genreIds = genreIds;
	}

	public int getId() {
		return id;
	}
	
	public List<Integer> getGenreIds() {
		return genreIds;
	}

	public void setGenreIds(List<Integer> genreIds) {
		this.genreIds = genreIds;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getOriginalTitle() {
		return originalTitle;
	}
	
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	
	public String getOverview() {
		return overview;
	}
	
	public void setOverview(String overview) {
		this.overview = overview;
	}

	@Override
	public String toString() {
		return "MovieDto [id=" + id + ", originalTitle=" + originalTitle + ", overview=" + overview + ", genreIds="
				+ genreIds + "]";
	}

	
	
	 
	

}
