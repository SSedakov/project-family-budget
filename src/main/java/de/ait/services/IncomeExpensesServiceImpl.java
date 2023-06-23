package de.ait.services;

import de.ait.models.Family;
import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;
import de.ait.repositories.FamilyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IncomeExpensesServiceImpl implements IncomeExpensesService {
    private FamilyRepository familyRepository;
    private FamilyService familyService = new FamilyServiceImpl(familyRepository);
    private Family family;

    public boolean possibleBuy(List<IncomeExpenses> incomeExpensesList, int sum) {

        int result = familyService.getBalance(incomeExpensesList);
        if (sum > result) {
            return false;
        }

        return true;
    }

    @Override
    public int addAsideMoney(int x, List<IncomeExpenses> y, Family family) {
        int accum = 0;
        for (int i = 0; i < y.size(); i++) {
            accum = accum + y.get(i).getSum();
        }
        family.setAsideMoney(accum / 100 * x);
        return accum / 100 * x;  //накопления, надо обязательно здесь пополнить переменную накоплений!!!!!!
    }

    @Override
    public List<IncomeExpenses> formBudget(List<FamilyMember> list) {
        List<IncomeExpenses> incomeExpenses = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            incomeExpenses.add(new IncomeExpenses(list.get(i).getStatus() + " salary", list.get(i).getSalary(), list.get(i).getFamilyId()));
        }
        return incomeExpenses;

    }
}




