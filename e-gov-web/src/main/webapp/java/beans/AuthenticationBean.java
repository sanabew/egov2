
package main.webapp.java.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import gov.esprit.service.person.PersonServiceRemote;
import gov.esprit.domain.Person;


@ManagedBean(name = "auth")
@SessionScoped
public class AuthenticationBean {
	
	@EJB
	private PersonServiceRemote userServiceLocal;

	private Person person;
	private Boolean loggedIn;
	
	
	public AuthenticationBean() {
	}
	
	@PostConstruct
	public void initModel(){
		setLoggedIn(false);
		person = new Person();
	}
	
	public String doSignIn(){
		String navigateTo = null;
		Person found = userServiceLocal.authentificate(person.getLogin(), person.getMotDePasse());
		if (found!=null) {
			loggedIn = true;
			person = found;
			//if (found instanceof Admin) {
				navigateTo = "/admin/manage?faces-redirect=true";
			/*}else if(found instanceof Member){
				navigateTo = "/member/welcome?faces-redirect=true";
			}*/
			
		} 
		return navigateTo;
	}
	
	public String doLogout(){
		String navigateTo = null;
		FacesContext
			.getCurrentInstance()
			.getExternalContext().
			getSessionMap()
			.clear();
		navigateTo = "/admin/login?faces-redirect=true";
		return navigateTo;
	}

	public Person getPerson() {
		return person;
	}

	public void setUser(Person person) {
		this.person = person;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
}
