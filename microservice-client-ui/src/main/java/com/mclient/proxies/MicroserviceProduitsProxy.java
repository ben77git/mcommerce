package com.mclient.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mclient.bean.ProductBean;

/*
 * EN configurant la seurite du ZUUL on obtient une erreur 401 - autorisation refusee :
 * feign.FeignException: status 401 reading MicroserviceProduitsProxy#listeDesProduits()
	at feign.FeignException.errorStatus(FeignException.java:78) ~[feign-core-10.1.0.jar:na]
 * 
 */

//@FeignClient(name = "microservice-produits", url = "localhost:9001", decode404 = true)
// passe mnt par Eureka
//@FeignClient(name = "microservice-produits")
// passe mnt par ZUUL
@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-produits")
public interface MicroserviceProduitsProxy {
	
	// via EUreka
	//@GetMapping(value = "/Produits")
	// via ZUul
	@GetMapping(value = "/microservice-produits/Produits")
	List<ProductBean> listeDesProduits();

	// via Eureka
	//@GetMapping(value = "/Produits/{id}")
	// via ZUul
	@GetMapping(value = "/microservice-produits/Produits/{id}")
	ProductBean recupererUnProduit(@PathVariable("id") int id);

}
