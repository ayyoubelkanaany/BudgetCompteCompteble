package com.projet.gestionBudget.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.gestionBudget.bean.BudgetCompteComptable;
import com.projet.gestionBudget.model.dao.BudgetCompteComptableRepository;
import com.projet.gestionBudget.model.service.facade.BudgetCompteComptableService;
import com.projet.gestionBudget.model.ws.required.facade.BudgetRestRequired;
import com.projet.gestionBudget.model.ws.required.facade.CompteComptebleRestRequired;
import com.projet.gestionBudget.model.ws.required.vo.BudgetVo;
import com.projet.gestionBudget.model.ws.required.vo.CompteComptableVo;

@Service
public class BudgetCompteComptableServiceImpl implements BudgetCompteComptableService{
	@Autowired
	private BudgetCompteComptableRepository budgetCompteComptableRepository;
    @Autowired
    private BudgetRestRequired budgetRestRequired;
    @Autowired
    private CompteComptebleRestRequired compteComptebleRestRequired;
	@Override
	public List<BudgetCompteComptable> findByMontant(int montant) {
		return budgetCompteComptableRepository.findByMontant(montant);
	}

	@Override
	public int save(BudgetCompteComptable BudgetCompteComptable) {
		BudgetVo loadedBudgetVo = null;
		CompteComptableVo loadedComptableVo=null;
		BudgetCompteComptable loadedBudgetCompteComptable=null;
		 if(BudgetCompteComptable.getRefBudgetCompteComptable()==null) {
	        	return -1;
	      }
		 else {
			 loadedBudgetCompteComptable = findByRefBudgetCompteComptable(BudgetCompteComptable.getRefBudgetCompteComptable());
		 }
        if(BudgetCompteComptable.getRefBudget()==null) {
        	return -2;
        }
        else {
        	loadedBudgetVo = this.budgetRestRequired.findByRefBudget(BudgetCompteComptable.getRefBudget());
        }
       
       
        if(BudgetCompteComptable.getRefCompteComptable()==null) {
        	return -3;
        }
        else {
        	loadedComptableVo = this.compteComptebleRestRequired.findByRefCompteComptable(BudgetCompteComptable.getRefCompteComptable());
        }
        if(loadedBudgetVo == null) {
        	return -4;
        }
        if(loadedComptableVo == null) {
        	return -5;
        }
        if(loadedBudgetCompteComptable != null) {
        	return -6;
        }
		budgetCompteComptableRepository.save(BudgetCompteComptable);
		return 1;
	}

	@Override
	public List<BudgetCompteComptable> findAll() {
		return budgetCompteComptableRepository.findAll();
	}

	@Override
	public BudgetCompteComptable findById(Long id) {
		if(budgetCompteComptableRepository.findById(id).isPresent()) {
			return budgetCompteComptableRepository.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	@Transactional
	@Override
	public void deleteById(Long id) {
		BudgetCompteComptable leadedBudgetCompteComptable = null;
		if(id!=null) {
			leadedBudgetCompteComptable = findById(id);
		}
		if(leadedBudgetCompteComptable!=null)
		budgetCompteComptableRepository.deleteById(id);
	}

	@Override
	public BudgetCompteComptable findByRefBudgetCompteComptable(String refBudgetCompteComptable) {
		return this.budgetCompteComptableRepository.findByRefBudgetCompteComptable(refBudgetCompteComptable);
	}

	@Override
	public List<BudgetCompteComptable> findByRefBudget(String refBudget) {
	
		return this.budgetCompteComptableRepository.findByRefBudget(refBudget);
	}

	@Override
	public List<BudgetCompteComptable> findByRefCompteComptable(String refCompteComptable) {
		
		return this.budgetCompteComptableRepository.findByRefCompteComptable(refCompteComptable);
	}
	
    @Transactional
	@Override
	public int deleteByRefBudgetCompteComptable(String refBudgetCompteComptable) {
		if(refBudgetCompteComptable!=null) {
			return this.budgetCompteComptableRepository.deleteByRefBudgetCompteComptable(refBudgetCompteComptable);
		}
		return 0;
	}

}
