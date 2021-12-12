package Aula07;

import java.util.Random;

public class Luta {
	
	private Lutador desafiado;
	private Lutador desafiante;
	private boolean aprovada;
	
	public Luta(Lutador desafiado, Lutador desafiante){
		
		setAprovada(false);
		setDesafiado(desafiado);
		setDesafiante(desafiante);
		marcarLuta(desafiado, desafiante);
		
	}

	public Lutador getDesafiado() {
		return desafiado;
	}

	public void setDesafiado(Lutador desafiado) {
		this.desafiado = desafiado;
	}

	public Lutador getDesafiante() {
		return desafiante;
	}

	public void setDesafiante(Lutador desafiante) {
		this.desafiante = desafiante;
	}

	public boolean isAprovada() {
		return aprovada;
	}

	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}

	private void marcarLuta(Lutador desafiado, Lutador desafiante) {
		if(this.desafiado.isNome() != this.desafiante.isNome()) {
			this.setAprovada(true);
			this.setDesafiado(this.getDesafiado());
			this.setDesafiante(this.getDesafiante());
		}
		else {
			this.setDesafiado(null);
			this.setDesafiante(null);
		}
	}
	
	public void lutar() {
		
		//verifica se a luta está aprovada
		
		if(this.isAprovada()) {
			
			this.getDesafiado().apresentar();
			try { Thread.sleep (3000); } catch (InterruptedException ex) {}
			
			this.getDesafiante().apresentar();
			try { Thread.sleep (3000); } catch (InterruptedException ex) {}
			
			Random random = new Random();
			
			boolean desafiadoTurn = false, desafianteTurn = true;
		
			int dadoDano, dadoEsquiva;
			int vidaDesafiado = this.getDesafiado().getCondicionamento();
			int vidaDesafiante = this.getDesafiante().getCondicionamento();
			int criticoDanoTemporarioDesafiante = (int) (this.getDesafiante().getDano() + 10);
			int criticoDanoTemporarioDesafiado = (int) (this.getDesafiado().getDano() + 10);
			//lutaComeçou	
			while(true) {
				
				dadoDano = random.nextInt(50);
				dadoEsquiva = random.nextInt(100);
				
				//turnoDesafiante
				if(desafianteTurn == true && vidaDesafiante > 0) {
					
					if(dadoDano < this.getDesafiante().getDano()) { //DanoCritico

						System.out.println( this.getDesafiante().isNome() +" deu um critico dano (" + criticoDanoTemporarioDesafiante + ")");
						vidaDesafiado -= this.getDesafiante().getDano() + 10;
						desafianteTurn = false;
						desafiadoTurn = true;
						try { Thread.sleep (1000); } catch (InterruptedException ex) {}
					}
					else if(dadoEsquiva < this.getDesafiado().getAgilidade()) {//EsquivaLuta
						
						System.out.println(this.getDesafiante().isNome() + " errou o ataque");
						desafianteTurn = false;
						desafiadoTurn = true;
						try { Thread.sleep (1000); } catch (InterruptedException ex) {}
					}
					else {
						System.out.println(this.getDesafiante().isNome() + " deu um dano("+ (int)this.getDesafiante().getDano() + ")");
						vidaDesafiado -= this.getDesafiante().getDano();
						desafianteTurn = false;
						desafiadoTurn = true;
						try { Thread.sleep (1000); } catch (InterruptedException ex) {}
					}
					
				}
				
				dadoDano = random.nextInt(50);
				dadoEsquiva = random.nextInt(100);
				
				//TurnoDesafiado
				if(desafiadoTurn == true && vidaDesafiado > 0) {
					if(dadoDano < this.getDesafiado().getDano()) {//DanoCritico
						
						System.out.println(this.getDesafiado().isNome() + " deu um critico dano (" + criticoDanoTemporarioDesafiado + ")\r\n");
						vidaDesafiante -= this.getDesafiado().getDano() + 10;
						desafianteTurn = true;
						desafiadoTurn = false;
						try { Thread.sleep (1000); } catch (InterruptedException ex) {}
					}
					else if(dadoEsquiva < this.getDesafiante().getAgilidade()) {
						
						System.out.println(this.getDesafiado().isNome() + " errou o ataque\r\n");
						desafianteTurn = true;
						desafiadoTurn = false;
						try { Thread.sleep (1000); } catch (InterruptedException ex) {}
					}
					else{
						
						System.out.println(this.getDesafiado().isNome() + " deu um dano (" + (int)this.getDesafiado().getDano() + ")\r\n");
						vidaDesafiante -= this.getDesafiado().getDano();
						desafianteTurn = true;
						desafiadoTurn = false;
						try { Thread.sleep (1000); } catch (InterruptedException ex) {}
					}
					
				}
				
				if(vidaDesafiado < 0 || vidaDesafiante < 0) {
					break;
				}
			}
			
			if(vidaDesafiante <= 0) {
				System.out.println(" ");
				System.out.println(this.getDesafiante().isNome() + " NOUCAUTEADO!!");
				System.out.println(this.getDesafiado().isNome() + " GANHOU!!!");
				this.getDesafiado().ganharLuta();
				System.out.println(" ");
				this.getDesafiado().status();
			}
			else if(vidaDesafiado <= 0) {
				System.out.println(" ");
				System.out.println(this.getDesafiado().isNome() + " NOUCAUTEADO!!");
				System.out.println(this.getDesafiante().isNome() + " GANHOU!!!");
				this.getDesafiante().ganharLuta();
				System.out.println(" ");
				this.getDesafiante().status();
			}
		}
		else {
			System.out.println("Você precisa escolher pessoas diferentes para lutar");
		}
	}
}
