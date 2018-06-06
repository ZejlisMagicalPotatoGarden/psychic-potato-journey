package exceptions;

public class HearthstoneException extends Exception {
	
	/**
	 * Classe représentant une exception du jeu HearthStone, elle ne demande qu'un message
	 * 
	 * @author GRESSET Nathan
	 * @author GRINWALD Louis
	 */
	
	private static final long serialVersionUID = 1L;

	public HearthstoneException(String msg) {
		super(msg);
	}
	
}
