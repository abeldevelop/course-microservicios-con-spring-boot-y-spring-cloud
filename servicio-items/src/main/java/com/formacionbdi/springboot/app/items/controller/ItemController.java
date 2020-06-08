package com.formacionbdi.springboot.app.items.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.items.model.Item;
import com.formacionbdi.springboot.app.items.model.Producto;
import com.formacionbdi.springboot.app.items.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ItemController {

	private final ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> findAllItems() {
		return itemService.findAll();
	}
	
//	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
	public Item metodoAlternativo(Long id, Integer cantidad) {
		return Item.builder()
				.producto(Producto.builder().id(id).nombre("Camara Sony").precio(500.00).build())
				.cantidad(cantidad)
				.build();
	}
}
