package com.projet.gestionBudget.model.ws.required.facade;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.gestionBudget.model.ws.required.vo.BudgetVo;

import io.swagger.annotations.ApiOperation;

@FeignClient("BUDGET-SERVICE")
public interface BudgetRestRequired {
	@RequestMapping(value = "/budgets/ref/{ref}",method = RequestMethod.GET)
	public BudgetVo findByRefBudget(@PathVariable String ref);
}
