package com.formacionbdi.springboot.app.items.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacionbdi.springboot.app.items.model.Item;
import com.formacionbdi.springboot.app.items.service.ItemService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

	private final RestTemplate restTemplate;
	
	
	public List<Item> findAll() {
		return null;
	}
	
	public Item findById(Long id, Integer cantidad) {
		return null;
	}
	
}
