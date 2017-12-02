package br.upf.victor.beans;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Empresa
 *
 */
@Entity

public class Empresa implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "EmpseqID")
	@SequenceGenerator(sequenceName = "EmpseqID", allocationSize = 1, initialValue = 1, name = "EmpseqID")
	private Integer id;
	@Length(min=5, max=60)
	private String nome;
	@Length(max=60)
	private String endereco;
	private String telefone;
	private String cnpj;
	private static final long serialVersionUID = 1L;

	public Empresa() {
		super();
	}   
	public Empresa(Integer id, String nome, String endereco, String telefone, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cnpj = cnpj;
	}
	public Empresa(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	
	   
	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}   
	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}   
	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
   
}
