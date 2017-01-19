package beans;


import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String data = "1";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}