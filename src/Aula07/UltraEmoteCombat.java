package Aula07;

public class UltraEmoteCombat {

	public static void main(String[] args) {
		
		Lutador lutadores[] = new Lutador[6];
		
		lutadores[0] = new Lutador("Pretty Boy", "Fran�a", 31, 1.75f, 68.9f, 11, 3);
		lutadores[1] = new Lutador("Putscript", "Brasil", 29, 1.68f, 57.8f, 14, 2);
		lutadores[2] = new Lutador("Snapshadow", "EUA", 35, 1.65f, 80.9f, 12, 2);
		lutadores[3] = new Lutador("Dean Code", "Australia", 28, 1.93f, 81.6f, 13, 0);
		lutadores[4] = new Lutador("UFOCobol", "Brasil", 37, 1.70f, 119.6f, 5, 4);
		lutadores[5] = new Lutador("Nerdaart", "EUA", 30, 1.81f, 105.7f, 12, 2);
		
		Luta marcandoLutas = new Luta(lutadores[0], lutadores[0]);
		marcandoLutas.lutar();
	}

}
