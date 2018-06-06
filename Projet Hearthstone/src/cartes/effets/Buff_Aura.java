package cartes.effets;

import partie.autres.personnage.Personnage;;

public class Buff_Aura extends Effet {
	/**
	 * Classe représentant l'effet Buff_Aura qui consiste à augmenter à la fois la vie et l'attaque des autres
	 * serviteurs sur le terrain
	 * il possède un bonus d'attaque, et un bonus de vie.
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 * 
	 * @see Effet
	 */

	private int bonusAttaque;
	private int bonusVie;
	private boolean utilise;
	
	public Buff_Aura(String description, String nom, int bonusAttaque, int bonusVie) {
		super(description, nom, "Aura");
		setBonusAttaque(bonusAttaque);
		setBonusVie(bonusVie);
		setUtilise(false);
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
	public boolean isUtilise() {
		return utilise;
	}
	public void setUtilise(boolean utilise) {
		this.utilise = utilise;
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
	public void activer(Personnage p) {
		if(p == null)
		{
			setUtilise(true);
		}
		else
		{
			if(isUtilise())
			{
				p.augmenterAttaque(-bonusAttaque);
				p.augmenterVie(-bonusVie);
			}
			else
			{
				p.augmenterVie(bonusVie);
				p.augmenterAttaque(bonusAttaque);
			}
		}
	}
	@Override
	public boolean isActivable() {
		return true;
	}
	@Override
	public boolean isCiblable(){
		return false;
	}

}
