package com.formacionbdi.springboot.app.items.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.items.client.ProductoClienteFeign;
import com.formacionbdi.springboot.app.items.model.Item;
import com.formacionbdi.springboot.app.items.model.Producto;
import com.formacionbdi.springboot.app.items.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Primary
@Service
public class ItemServiceFeignImpl implements ItemService {

	private final ProductoClienteFeign productoClienteFeign;
	
	
	public List<Item> findAll() {
		List<Producto> productos = productoClienteFeign.findAllProducts();
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}
	
	public Item findById(Long id, Integer cantidad) {
		Producto producto = productoClienteFeign.findProductoById(id);
		return new Item(producto, cantidad);
	}
	
}
