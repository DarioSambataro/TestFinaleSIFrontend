package it.project.model;

import java.util.List;

import it.project.model.Ruolo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "utenti")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String firstname;
	
	@Column(name = "cognome")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_città", referencedColumnName = "id")
	private Città città;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable
	(  
	   name = "utenti_ruolo", joinColumns = @JoinColumn(name = "FK_U", referencedColumnName = "id"),
	   inverseJoinColumns = @JoinColumn(name = "FK_R", referencedColumnName = "id")
	)
	private List<Ruolo> listaRuoli;
	
	public List<Ruolo> getListaRuoli() {
		return listaRuoli;
	}

	public void setListaRuoli(List<Ruolo> listaRuoli) {
		this.listaRuoli = listaRuoli;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Città getCittà() {
		return città;
	}

	public void setCittà(Città idCittà) {
		this.città = idCittà;
	}
	
}
