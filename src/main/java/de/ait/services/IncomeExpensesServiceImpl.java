package de.ait.services;

import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IncomeExpensesServiceImpl implements IncomeExpensesService {

    public boolean possibleBuy(int sum) {
        /*
       int totalSum = familyRepository.formBudget();
        if (sum > totalSum) {
            System.out.println("Покупка не возможна, считай бюджет");
            return false;
        }
        System.out.println("Покупай");
         */
        return true;
    }

    @Override
    public int addAsideMoney(int x, List<IncomeExpenses> y) {
        int accum = 0;
        for (int i = 0; i < y.size(); i++) {
            accum = accum + y.get(i).getSum();
        }
        return accum / 100 * x;  //накопления, надо обязательно здесь пополнить переменную накоплений!!!!!!
    }

    @Override
    public List<IncomeExpenses> formBudget(List<FamilyMember> list) {
        List<IncomeExpenses> incomeExpenses = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            incomeExpenses.add(new IncomeExpenses(list.get(i).getStatus()+" salary", list.get(i).getSalary(), list.get(i).getFamilyId()));
        }
        return incomeExpenses;

    }
}




