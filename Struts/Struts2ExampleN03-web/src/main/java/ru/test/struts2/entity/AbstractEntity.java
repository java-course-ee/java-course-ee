package ru.test.struts2.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author APronchakov <artem.pronchakov@gmail.com>
 */
public interface AbstractEntity {
	public Long getId();

	public void setId(Long id);
	
	

}
