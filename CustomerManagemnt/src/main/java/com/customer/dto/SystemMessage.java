package com.customer.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String messageCode;
	private String messageDescription;

}
