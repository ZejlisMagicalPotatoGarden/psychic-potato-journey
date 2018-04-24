package partie.joueur.plateau;

import java.util.ArrayList;

import cartes.serviteur.Serviteur;

public class Plateau {

	public final static int NB_SERVITEURS_MAX = 7;
	
	private ArrayList<Serviteur> serviteurs;

	public Plateau() {
		this.serviteurs = new ArrayList<Serviteur>();
	}
	
	
	public ArrayList<Serviteur> getServiteurs() {
		return serviteurs;
	}
	public void setServiteurs(ArrayList<Serviteur> serviteurs) {
		this.serviteurs = serviteurs;
	}


	@Override
	public String toString() {
		return "Plateau [serviteurs=" + serviteurs + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plateau other = (Plateau) obj;
		if (serviteurs == null) {
			if (other.serviteurs != null)
				return false;
		} else if (!serviteurs.equals(other.serviteurs))
			return false;
		return true;
	}
	
	public void addServiteur(Serviteur s){
		this.serviteurs.add(s);
	}
	public void removeServiteur(Serviteur s){
		this.serviteurs.remove(this.serviteurs.indexOf(s));
	}
	public boolean isPlein(){
		return(this.serviteurs.size() >= NB_SERVITEURS_MAX);
	}
}
