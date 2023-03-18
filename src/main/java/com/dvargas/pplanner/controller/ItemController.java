package com.dvargas.pplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dvargas.pplanner.exception.ResourceNotFoundException;
import com.dvargas.pplanner.model.Item;
import com.dvargas.pplanner.repository.ItemRepository;

@RestController 
@RequestMapping("/api/items") 
public class ItemController {      
	
	@Autowired     
	private ItemRepository itemRepository;
	
	@GetMapping("/")     
	public List<Item> getAllItems() {         
		return itemRepository.findAll();     
	}
	
	@PostMapping("/")     
	public Item createItem(@RequestBody Item item) {         
		return itemRepository.save(item);
	}
	
	@GetMapping("/{id}") 
	public Item getItemById(@PathVariable String id) { 
		return itemRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Item", "id", id)); 
	}
	
	@PutMapping("/{id}") 
	public Item updateItem(@PathVariable String id, @RequestBody Item itemDetails) { 
			Item item = 
				itemRepository.findById(id).orElseThrow(
					() -> new ResourceNotFoundException("Item", "id", id)
				); 
			item.setName(itemDetails.getName()); 
			item.setDescription(itemDetails.getDescription()); 
			item.setQuantity(itemDetails.getQuantity()); 
			item.setExpirationDate(itemDetails.getExpirationDate()); 
			return itemRepository.save(item); 
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<?> deleteItem(@PathVariable String id) { 
		Item item = 
			itemRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Item", "id", id)
			); 
		itemRepository.delete(item); 
		return ResponseEntity.ok().build(); 
	}
}
