package br.upf.victor.beans;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Produto
 *
 */
@Entity

public class Produto implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "ProseqID")
	@SequenceGenerator(name = "ProseqID", sequenceName = "ProseqID", allocationSize = 1, initialValue = 1)
	private Integer id;
	@NotNull
	@Length(min=5, max=60)
	private String nome;
	@NotNull
	private Integer quantidade;
	@NotNull
	private Integer preco;
	@ManyToOne(optional = false)
	private Empresa Empresa;
	private static final long serialVersionUID = 1L;

	public Produto() {
		super();
	}   
	public Produto(Integer id, String nome, Integer quantidade, Integer preco, br.upf.victor.beans.Empresa empresa) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		Empresa = empresa;
	}
	public Produto(Integer id) {
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
	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}   
	public Integer getPreco() {
		return this.preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}   
	public Empresa getEmpresa() {
		return this.Empresa;
	}

	public void setEmpresa(Empresa Empresa) {
		this.Empresa = Empresa;
	}
   
}
