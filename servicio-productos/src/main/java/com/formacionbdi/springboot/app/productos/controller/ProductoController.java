package com.formacionbdi.springboot.app.productos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;
import com.formacionbdi.springboot.app.productos.service.ProductoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProductoController {

	private final ProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> findAllProducts() {
		return productoService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto findProductoById(@PathVariable Long id) {
//		try {
//			Thread.sleep(2000l);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		return productoService.findById(id);
	}
	
}
