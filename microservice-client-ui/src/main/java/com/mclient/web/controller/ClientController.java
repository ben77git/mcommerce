package com.mclient.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mclient.bean.ProductBean;
import com.mclient.proxies.MicroserviceProduitsProxy;

@Controller
@EnableFeignClients("com.mclient")
public class ClientController {
	
	@Autowired
	private MicroserviceProduitsProxy productProxy;
	
	@RequestMapping("/")
	public String accueil(Model model) {
		List<ProductBean> products = productProxy.listeDesProduits();
		model.addAttribute("products", products);

		System.out.println("LAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA products " + products == null ? "null" : products.size());
		return "Accueil";
	}
	
	@RequestMapping("/details-produit/{id}")
	public String detail(Model model, @PathVariable int id) {
		ProductBean product = productProxy.recupererUnProduit(id);
		model.addAttribute("product", product);

		System.out.println("LAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA product " + product == null ? "null" : product.getImage());
		return "detail";
	}

}
