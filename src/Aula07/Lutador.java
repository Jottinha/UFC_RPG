package Aula07;

public class Lutador {
	
	private String nome;
	private String nacionalidade;
	private int idade;
	private float altura;
	private float peso;
	private int agilidade;
	private float dano;
	private int condicionamento;
	private int vitorias;
	private int derrotas;

	public Lutador(String nome, String nacionalidade, int idade, float altura, float peso, int vitorias, int derrotas) {
		
		setNome(nome);
		setNacionalidade(nacionalidade);
		setIdade(idade);
		setAltura(altura);
		setPeso(peso);
		setVitorias(vitorias);
		setDerrotas(derrotas);
	}
	
	public int getAgilidade() {
		return agilidade;
	}

	private void setAgilidade(float altura) {
		
		if(altura > 1.60 && altura < 1.70) {
			this.agilidade = 60;
		}
		else if(altura > 1.70 && altura < 1.80) {
			this.agilidade = 40;
		}
		else if(altura > 1.80 && altura < 1.90) {
			this.agilidade = 30;
		}
		else if(altura > 1.90) {
			this.agilidade = 20;
		}
	}

	public float getDano() {
		return dano;
	}

	public void setDano(float peso) {
		
		if(peso > 56 && peso < 70) {
			this.dano = (float) (10 * 1.2);
		}
		else if(peso > 70 && peso < 80) {
			this.dano = (float) (10 * 1.4);
		}
		else if(peso > 80 && peso < 90) {
			this.dano = (float) (10 * 1.6);
		}
		else if(peso > 90) {
			this.dano = 10 * 2;
		}
	}

	public int getCondicionamento() {
		return condicionamento;
	}

	public void setCondicionamento(float idade) {
		if(idade < 25 && idade > 18) {
			this.condicionamento = 150;
		}
		else if(idade > 25 && idade <= 35) {
			this.condicionamento = 125;
		}
		else if(idade > 35 && idade < 45) {
			this.condicionamento = 110;
		}
		else if(idade > 45) {
			this.condicionamento = 100;
		}
	}

	public String isNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String isNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
		this.setCondicionamento(idade);;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
		this.setAgilidade(this.getAltura());
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
		this.setDano(peso);
	}

	public int getVitorias() {
		return vitorias;
	}

	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	
	public void apresentar() {
		
		System.out.println("Nome: " + this.isNome());
		System.out.println("Nacionalidade: " + this.isNacionalidade());
		System.out.println(this.getIdade() + " Anos");
		System.out.println(this.getIdade() + " Altura");
		System.out.println("Pesando: " + this.getPeso());
		System.out.println("Condicionamento: " + this.getCondicionamento());
		System.out.println("Força: " + this.getDano());
		System.out.println("Agilidade: " + this.getAgilidade());
		System.out.println("Ganhou: " + this.getVitorias());
		System.out.println("Perdeu: " + this.getDerrotas());
		System.out.println("----------------------------\r\n");
	}
	
	public void status() {
		
		System.out.println("Nome: " + this.isNome());
		System.out.println("Ganhou: " + this.getVitorias());
		System.out.println("Perdeu: " + this.getDerrotas());
	}

	public void ganharLuta() {
		
		this.setVitorias(this.getVitorias() + 1);
	}
	
	public void pederLuta() {
		
		this.setDerrotas(this.getDerrotas() + 1);
	}
	
}