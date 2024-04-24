package pv.sb_tmdb_mvc.dto;

import java.util.List;

public class MovieCountryReleasesDto {
	
	private int id;
	private List<CountryReleaseDto> countryReleases;
	
	
	public MovieCountryReleasesDto(int id, List<CountryReleaseDto> countryReleases) {
		super();
		this.id = id;
		this.countryReleases = countryReleases;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<CountryReleaseDto> getCountryReleases() {
		return countryReleases;
	}


	public void setCountryReleases(List<CountryReleaseDto> countryReleases) {
		this.countryReleases = countryReleases;
	}


	@Override
	public String toString() {
		return "MovieCountryReleasesDto [id=" + id + ", countryReleases=" + countryReleases + "]";
	}
	
	

}
