package ru.test.jquery;

import java.io.Serializable;

/**
 *
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
class Name implements Serializable {
	private Long id;
	private String label;
	private String value;

	public Name(Long id, String label, String value) {
		this.id = id;
		this.label = label;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
