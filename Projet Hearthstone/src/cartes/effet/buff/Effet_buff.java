package cartes.effet.buff;

import cartes.effet.effet.Effet;
import partie.autres.cible.Cible;;

public class Effet_buff extends Effet {

	private int bonusAttaque;
	private int bonusVie;
	
	public Effet_buff(String description, String nom, String type, int bonusAttaque, int bonusVie) {
		super(description, nom, type);
		this.bonusAttaque = bonusAttaque;
		this.bonusVie = bonusVie;
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
		Effet_buff other = (Effet_buff) obj;
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
	public void activer(Cible c) {
		c.augmenterVie(bonusVie);
		c.augmenterAttaque(bonusAttaque);
	}
	@Override
	public boolean isActivable(Cible c) {
		return !(c == null);
	}
	@Override
	public boolean isCiblable(){
		return true;
	}

}
