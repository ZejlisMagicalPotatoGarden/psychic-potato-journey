package partie.autres.personnage;

import partie.autres.cible.Cible;

public interface Personnage {
/**
 * Interface représentant un personnage dans Hearthstone, c'est soit un héros soit
 * un serviteur, un personnage peut prendre des dégats , mourir, gagner de la vie ou de l'attaque
 * --------A COMPLETER----------
 * 
 * @author GRESSET Nathan
 * @author GRINWALD Louis
 * 
 * @see Cible
 * @see Serviteur
 * @see Heros
 */
	public abstract void prendreDegats(int x);
	public abstract void mourir();
	public abstract void augmenterAttaque(int bonusAttaque);
	public abstract void augmenterVie(int bonusVie);	
}

