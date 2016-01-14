package dao;

import javax.ejb.Stateless;




import model.Piece;

@Stateless( name = "PieceDAO" )
public class PieceDAO extends GenericDAO<Piece> {

	public PieceDAO() {
		super(Piece.class);
		// TODO Auto-generated constructor stub
	}
	
}
