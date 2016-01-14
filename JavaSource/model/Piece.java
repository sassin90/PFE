package model;

import java.io.Serializable;




import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table
@NamedQueries( {
    @NamedQuery( name = "Piece.populatePiece", query = "SELECT u FROM Piece u where u.id=3" )
}
)
public class Piece extends BaseEntity implements Serializable {

	 @Column
	private String piece;

	public String getPiece() {
		return piece;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	
	
	
}
