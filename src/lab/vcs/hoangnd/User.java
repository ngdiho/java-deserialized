package lab.vcs.hoangnd;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private int birth;
	private String phone;
	private String command;

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
