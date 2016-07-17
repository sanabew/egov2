
package main.webapp.java.beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import gov.esprit.service.citoyen.CitoyenServiceRemote;
import gov.esprit.domain.Citoyen;



@ManagedBean(name = "authcitoyen")
@SessionScoped
public class AuthenticationCitoyenBean {
	
	@EJB
	private CitoyenServiceRemote userServiceLocal;

	private Citoyen person;
	private Boolean loggedIn;
	
	
	public AuthenticationCitoyenBean() {
	}
	
	@PostConstruct
	public void initModel(){
		setLoggedIn(false);
		person = new Citoyen();
	}
	
	public String doSignIn(){
		String navigateTo = null;
		Citoyen found = userServiceLocal.authentificate(person.getLogin(), person.getMotDePasse());
		if (found!=null) {
			loggedIn = true;
			person = found;
			//if (found instanceof Admin) {
				navigateTo = "templates/default/citoyen/login/main?faces-redirect=true";
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
		navigateTo = "index?faces-redirect=true";
		return navigateTo;
	}

	public Citoyen getPerson() {
		return person;
	}

	public void setUser(Citoyen person) {
		this.person = person;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
}
