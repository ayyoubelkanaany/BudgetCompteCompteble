package com.projet.gestionBudget.model.ws.required.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.gestionBudget.model.ws.required.vo.CompteComptableVo;


@FeignClient("COMPTECOMPTABLE-SERVICE")
public interface CompteComptebleRestRequired {
	@RequestMapping(value = "/CompteComptable/refCompteComptable/{refCompteComptable}",method= RequestMethod.GET)
	public CompteComptableVo findByRefCompteComptable(@PathVariable String refCompteComptable);
}
