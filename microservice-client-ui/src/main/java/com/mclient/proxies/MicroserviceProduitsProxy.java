package com.mclient.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mclient.bean.ProductBean;

@FeignClient(name = "microservice-produits", url = "localhost:9001", decode404 = true)
public interface MicroserviceProduitsProxy {
	
	@GetMapping(value = "/Produits")
	List<ProductBean> listeDesProduits();
	
	@GetMapping(value = "/Produits/{id}")
	ProductBean recupererUnProduit(@PathVariable("id") int id);

}