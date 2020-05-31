package com.formacionbdi.springboot.app.items.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.items.model.Item;
import com.formacionbdi.springboot.app.items.model.Producto;
import com.formacionbdi.springboot.app.items.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

	private final RestTemplate restTemplate;
	
	
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(restTemplate.getForObject("http://localhost:8001/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}
	
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathParams = new HashMap<>();
		pathParams.put("id", id.toString());
		Producto producto = restTemplate.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathParams);
		return new Item(producto, cantidad);
	}
	
}
