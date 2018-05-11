package cartes.effets;

import partie.autres.cible.Cible;;

public class Buff extends Effet {

	private int bonusAttaque;
	private int bonusVie;
	
	public Buff(String description, String nom, String type, int bonusAttaque, int bonusVie) {
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
		Buff other = (Buff) obj;
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
