package pv.sb_tmdb_mvc.dto;

public class ReleaseDateAndTypeDto {
	
	private String releaseDate;
	private int type;
	
	
	public ReleaseDateAndTypeDto(String releaseDate, int type) {
		super();
		this.releaseDate = releaseDate;
		this.type = type;
	}


	public String getReleaseDate() {
		return releaseDate.substring(0,10);
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "ReleaseDateAndTypeDto [releaseDate=" + releaseDate + ", type=" + type + "]";
	}
	
	

}
