package br.upf.victor.beans;

import java.io.Serializable;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "UsrseqID")
	@SequenceGenerator(name = "UsrseqID", sequenceName = "UsrseqID", allocationSize = 1, initialValue = 1)
	private Integer id;
	@Column(length = 60, nullable = false)
	private String nome;
	@Column(length = 20, nullable = false)
	private String login;
	@Column(length = 40, nullable = false)
	private String senha;
	
	public Usuario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
   
}
