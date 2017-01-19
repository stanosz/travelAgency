package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import core.MockCore;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * A session scoped bean must be serializable.
	 */
	private static final long serialVersionUID = 6955508471291131930L;

	private String login;
	private String password;
	private boolean connected = false;

	public String verify() {
		String results;
		if (MockCore.exist(login)) {
			if (MockCore.isValid(login, password)) {
				results = "valid";
				connected = true;
			} else {
				results = "invalid";
			}
		} else {
			results = "no-such-user";
		}

		return results;
	}

	public LoginBean() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
