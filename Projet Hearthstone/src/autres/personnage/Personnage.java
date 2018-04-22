package personnage;

public interface Personnage {
/**
 * Interface représentant un personnage dans Hearthstone, c'est soit un héros soit
 * un serviteur, un personnage peut prendre des dégats , mourir, attaquer --------A COMPLETER----------
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Cible
 * @see Serviteur
 * @see Heros
 */
	public abstract void Attaquer(Cible cible);
	public abstract void PrendreDegats(int x);
	public abstract void Mourir();
}

