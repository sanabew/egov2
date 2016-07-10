
package main.webapp.java.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import gov.esprit.service.person.PersonServiceRemote;
import gov.esprit.domain.Person;

@ManagedBean
@RequestScoped
public class PersonCrudBean {
	
	@EJB
	private PersonServiceRemote personServiceRemote;
	
	private Integer id;
	private String name;
	private List<Person> persons;
	private String lastName;
	private String fonction;
	private String login;
	private String motDePasse;

	public PersonCrudBean() {
	}
	@PostConstruct
	public void initModel(){
		persons = personServiceRemote.findAll();
	}
	
	public String doAdd(){
		String navigateTo = null;
		Person person = new Person(name, lastName, fonction, login, motDePasse);
		personServiceRemote.addUser(person);
		navigateTo = "/admin/list?faces-redirect=true";
		return navigateTo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
	
	

}
