package com.formacionbdi.springboot.app.items.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.items.model.Producto;

@FeignClient(name = "servicio-productos", url = "localhost:8001")
public interface ProductoClienteFeign {

	@GetMapping("/listar")
	public List<Producto> findAllProducts();
	
	@GetMapping("/ver/{id}")
	public Producto findProductoById(@PathVariable Long id);
	
}
