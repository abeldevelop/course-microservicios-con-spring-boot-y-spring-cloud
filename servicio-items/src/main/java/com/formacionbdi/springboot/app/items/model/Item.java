package com.formacionbdi.springboot.app.items.model;

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
public class Item {

	private Producto producto;
	private Integer cantidad;
	
	public Double getTotal() {
		return this.producto.getPrecio() * cantidad.doubleValue();
	}
}
