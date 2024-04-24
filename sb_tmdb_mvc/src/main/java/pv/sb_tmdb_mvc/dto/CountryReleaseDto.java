package pv.sb_tmdb_mvc.dto;

import java.util.List;

public class CountryReleaseDto {
	
	private String countryCode;
	private List<ReleaseDateAndTypeDto> releaseDatesAndTypes;
	
	
	public CountryReleaseDto(String countryCode, List<ReleaseDateAndTypeDto> releaseDatesAndTypes) {
		super();
		this.countryCode = countryCode;
		this.releaseDatesAndTypes = releaseDatesAndTypes;
	}


	public String getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public List<ReleaseDateAndTypeDto> getReleaseDatesAndTypes() {
		return releaseDatesAndTypes;
	}


	public void setReleaseDatesAndTypes(List<ReleaseDateAndTypeDto> releaseDatesAndTypes) {
		this.releaseDatesAndTypes = releaseDatesAndTypes;
	}


	@Override
	public String toString() {
		return "CountryReleaseDto [countryCode=" + countryCode + ", releaseDatesAndTypes=" + releaseDatesAndTypes + "]";
	}
	
	

}
