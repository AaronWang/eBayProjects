package org.persistence;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: test
 *
 */
@Entity
public class test implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private static final long serialVersionUID = 1L;

	public test() {
		super();
	}

}
