package cartes.effets;

import partie.autres.personnage.Personnage;;

public class Buff_Aura extends Effet {
	/**
	 * Classe représentant l'effet Buff qui consiste à augmenter à la fois la vie et l'attaque, il possède un bonus d'attaque,
	 * et un bonus de vie.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see effets
	 */

	private int bonusAttaque;
	private int bonusVie;
	
	public Buff_Aura(String description, String nom, String type, int bonusAttaque, int bonusVie) {
		super(description, nom, type);
		setBonusAttaque(bonusAttaque);
		setBonusVie(bonusVie);
	}

	public int getBonusAttaque() {
		return bonusAttaque;
	}
	public void setBonusAttaque(int bonusAttaque) {
		this.bonusAttaque = bonusAttaque;
	}
	public int getBonusVie() {
		return bonusVie;
	}
	public void setBonusVie(int bonusVie) {
		this.bonusVie = bonusVie;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buff_Aura other = (Buff_Aura) obj;
		if (bonusAttaque != other.bonusAttaque)
			return false;
		if (bonusVie != other.bonusVie)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Effet_buff [bonusAttaque=" + bonusAttaque + ", bonusVie=" + bonusVie + "]";
	}



	@Override
	public void activer(Personnage p) {
		p.augmenterVie(bonusVie);
		p.augmenterAttaque(bonusAttaque);
	}
	@Override
	public boolean isActivable() {
		return true;
	}
	@Override
	public boolean isCiblable(){
		return true;
	}

}
