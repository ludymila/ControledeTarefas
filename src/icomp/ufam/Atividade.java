package icomp.ufam;

import java.io.Serializable;

public class Atividade implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	int prioridade;
	String descricao;
	String dataEntrega;
	String dataRealizacao;
	String disciplina;
	String nota;

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getDataRealizacao() {
		return dataRealizacao;
	}

	public void setDataRealizacao(String dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Atividade(long id, int prioridade, String descricao,
			String dataEntrega, String dataRealizacao, String disciplina,
			String nota) {
		super();
		this.prioridade = prioridade;
		this.descricao = descricao;
		this.dataEntrega = dataEntrega;
		this.dataRealizacao = dataRealizacao;
		this.disciplina = disciplina;
		this.nota = nota;
		this.id = id;
	}
	
	public Atividade() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
