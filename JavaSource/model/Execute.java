package model;

import java.io.Serializable;




import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table
@NamedQueries( {
    @NamedQuery( name = "Execute.ExecuteFindTime", query = "SELECT u FROM Execute u " )
}

)
public class Execute extends BaseEntity implements Serializable {

	 @Column
	private String temps;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "exe_id", nullable = false)
	    private Machine machine ;
	
	 @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "piece_id", nullable = false)
	    private Piece piece ;
	 
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public String getTemps() {
		return temps;
	}

	public void setTemps(String temps) {
		this.temps=temps;
	}
	
	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine= machine;
	}

	
	
	
}
