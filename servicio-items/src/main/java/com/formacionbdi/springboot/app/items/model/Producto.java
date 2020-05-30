package com.formacionbdi.springboot.app.items.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {

	private Long id;
	private String nombre;
	private Double precio;
	private Date createAt;
	
}
