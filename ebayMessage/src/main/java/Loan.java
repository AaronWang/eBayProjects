import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "LOAN")
public class Loan implements java.io.Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

//	@ManyToOne
//	@JoinColumn(name = "BOOK_ID")
//	private Book book;

	// @ManyToOne
	// @JoinColumn(name = "PERSON_ID")
	// private Person person;

	// @Column(name = "DUE_DATE")
	// @Temporal(javax.persistence.TemporalType.DATE)
	// private Date dueDate;

	public Loan() {
		// No-argument Constructor
	}
	// Other constructor(s)
	// Accessor, Mutator and other methods
}
