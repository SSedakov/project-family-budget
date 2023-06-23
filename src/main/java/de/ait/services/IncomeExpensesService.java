package de.ait.services;

import de.ait.models.Family;
import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;

import java.util.List;

public interface IncomeExpensesService {
    List<IncomeExpenses> formBudget(List<FamilyMember> list);
    boolean possibleBuy(List<IncomeExpenses> incomeExpensesList,int sum);

    int addAsideMoney (int x, List<IncomeExpenses> y, Family family);
}

