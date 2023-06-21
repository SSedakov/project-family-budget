package de.ait.repositories;

import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;

import java.util.List;

public interface UsersRepository {
    List<FamilyMember> createFamily();
   List<IncomeExpenses> createList();
    List<IncomeExpenses> addToList(String title,int sum);
    int  formBudget();
}
