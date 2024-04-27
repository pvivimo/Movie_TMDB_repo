package pv.sb_tmdb_mvc.dto;

import java.util.List;

public class UserDto {
	
	private int id;
	private String name;
	private int age;
	
	private List<MovieDto> seenMoveis;

	public UserDto(int id, String name, int age, List<MovieDto> seenMoveis) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.seenMoveis = seenMoveis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<MovieDto> getSeenMoveis() {
		return seenMoveis;
	}

	public void setSeenMoveis(List<MovieDto> seenMoveis) {
		this.seenMoveis = seenMoveis;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", age=" + age + ", seenMoveis=" + seenMoveis + "]";
	}
	
	
	
	
	

}
