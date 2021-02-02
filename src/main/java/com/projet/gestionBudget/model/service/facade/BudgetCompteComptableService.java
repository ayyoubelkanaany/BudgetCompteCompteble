package com.projet.gestionBudget.model.service.facade;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.projet.gestionBudget.bean.BudgetCompteComptable;

public interface BudgetCompteComptableService {
	public List<BudgetCompteComptable> findByMontant(int montant);
	
	public int save(BudgetCompteComptable budget);
	
	public List<BudgetCompteComptable> findAll();
	
	public BudgetCompteComptable findById(Long id);
	public BudgetCompteComptable findByRefBudgetCompteComptable(String refBudgetCompteComptable);
	public List<BudgetCompteComptable> findByRefBudget(String refBudget);
	public List<BudgetCompteComptable> findByRefCompteComptable(String refCompteComptable);
	@Transactional
	public void  deleteById(Long id);
	public int deleteByRefBudgetCompteComptable(String refBudgetCompteComptable);
}
