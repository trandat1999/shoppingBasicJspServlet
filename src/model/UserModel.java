package model;

public class UserModel {
	private long id;
	private String username;
	private String password;
	private String email;
	private String position;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public UserModel(long id, String username, String password, String email, String position) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.position = position;
	}

	public UserModel(String username, String password, String email, String position) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.position = position;
	}

	public UserModel() {
		super();
	}

}
