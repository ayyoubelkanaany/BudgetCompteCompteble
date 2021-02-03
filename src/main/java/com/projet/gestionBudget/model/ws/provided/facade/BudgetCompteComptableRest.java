package com.projet.gestionBudget.model.ws.provided.facade;

import java.util.List;
import com.projet.gestionBudget.model.ws.provided.vo.BudgetCompteComptableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.gestionBudget.bean.BudgetCompteComptable;
import com.projet.gestionBudget.model.service.facade.BudgetCompteComptableService;
import com.projet.gestionBudget.model.ws.provided.converter.BudgetCompteComptableConverter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette class permet de gerer les traiements relative au BudgetCompteComptable à savoir Save, FindAll, ...etc.")
@RestController
@RequestMapping("/budgetcomptecomptable")
public class BudgetCompteComptableRest {
	@Autowired
	private BudgetCompteComptableConverter budgetCompteComptableConverter;
	
	@Autowired
	private BudgetCompteComptableService budgetCompteComptableService;
	
	@DeleteMapping("/refBudgetCompteComptable/{refBudgetCompteComptable}")
	public int deleteByRefBudgetCompteComptable(@PathVariable String refBudgetCompteComptable) {
		return budgetCompteComptableService.deleteByRefBudgetCompteComptable(refBudgetCompteComptable);
	}
	@GetMapping("/refBudgetCompteComptable/{refBudgetCompteComptable}")
	public BudgetCompteComptableVo findByRefBudgetCompteComptable(@PathVariable String refBudgetCompteComptable) {
		return budgetCompteComptableConverter.toVo(budgetCompteComptableService.findByRefBudgetCompteComptable(refBudgetCompteComptable));
	}
	@GetMapping("/refBudget/{refBudget}")
	public List<BudgetCompteComptableVo> findByRefBudget(@PathVariable String refBudget) {
		return  budgetCompteComptableConverter.toVos(budgetCompteComptableService.findByRefBudget(refBudget));
	}
	@GetMapping("/refCompteComptable/{refCompteComptable}")
	public List<BudgetCompteComptableVo> findByRefCompteComptable(@PathVariable String refCompteComptable) {
		return  budgetCompteComptableConverter.toVos(budgetCompteComptableService.findByRefCompteComptable(refCompteComptable));
	}

	
	@GetMapping("/Montant/{montant}")
	@ApiOperation("Cette methode permet de trouver l'ensemble des BudgetCompteComptables par montant")
	public List<BudgetCompteComptableVo> findByMontant(@PathVariable int montant) {
		List<BudgetCompteComptable> budgetCompteComptables = budgetCompteComptableService.findByMontant(montant);
		return budgetCompteComptableConverter.toVos(budgetCompteComptables);
	}
	
	@PostMapping("/")
	@ApiOperation("Cette methode permet d'inserer un nouveau BudgetCompteComptable")
	public int save(@RequestBody BudgetCompteComptableVo budgetCompteComptableVo) {
		return budgetCompteComptableService.save(budgetCompteComptableConverter.toBean(budgetCompteComptableVo));
	}
	
	@GetMapping("/")
	@ApiOperation("Cette methode permet d'afficher l'enssemble des BudgetCompteComptables")
	public List<BudgetCompteComptableVo> findAll() {
		List<BudgetCompteComptable> budgetCompteComptables = budgetCompteComptableService.findAll();
		return budgetCompteComptableConverter.toVos(budgetCompteComptables);
	}
	
	@GetMapping("/id/{id}")
	@ApiOperation("Cette methode permet de trouver un BudgetCompteComptables par id")
	public BudgetCompteComptableVo findById(@PathVariable Long id) {
		BudgetCompteComptable budgetCompteComptable = budgetCompteComptableService.findById(id);
		return budgetCompteComptableConverter.toVo(budgetCompteComptable);
	}
	
	@DeleteMapping("id/{id}")
	@ApiOperation("Cette methode permet de supprimer un BudgetCompteComptables par id")
	public void deleteById(@PathVariable Long id) {
		budgetCompteComptableService.deleteById(id);
	}
}
