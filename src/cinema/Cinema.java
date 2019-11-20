package cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema implements Venda {

	private List<Ingresso> ingressosVendidos;
	private String nome;
	private Integer qtdIngressos;

	public Cinema(String nome) {
		this.nome = nome;
		ingressosVendidos = new ArrayList<>();
		qtdIngressos = 20;
	}

	public List<Ingresso> getIngressosVendidos() {
		return ingressosVendidos;
	}

	public void setIngressosVendidos(List<Ingresso> ingressosVendidos) {
		this.ingressosVendidos = ingressosVendidos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdIngressos() {
		return qtdIngressos;
	}

	public void setQtdIngressos(Integer qtdIngressos) {
		this.qtdIngressos = qtdIngressos;
	}

	@Override
	public void venderIngresso(String opcao) {

		if (opcao.equalsIgnoreCase("m")) {// ingresso tipo meia
			Ingresso meia = new Meia(1020 - qtdIngressos);
			qtdIngressos--;
			ingressosVendidos.add(meia);
		} else {
			if (opcao.equalsIgnoreCase("n")) {// ingresso tipo normal
				Ingresso inteira = new Inteira(1020 - qtdIngressos);
				qtdIngressos--;
				ingressosVendidos.add(inteira);
			}
		}
	}

}
