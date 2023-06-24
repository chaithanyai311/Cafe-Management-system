package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.model.Cartitem;
import com.shopping.service.CartitemService;

@CrossOrigin("*")
@RestController
public class CartitemController {

	@Autowired
	private CartitemService cartitemService;
	
	@GetMapping(value = "/cartitems")
	public List<Cartitem> getCartitems() {
		return cartitemService.viewAllCartitems();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deletecartitem/{id}")
	public void deleteCartitem(@PathVariable int id) {
		cartitemService.deleteCartitem(id);
	}
}
