package com.formacionbdi.springboot.app.items.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {

	private Long id;
	private String nombre;
	private Double precio;
	private Date createAt;
	
}
