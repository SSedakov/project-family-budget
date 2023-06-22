package de.ait.services;

import de.ait.models.Family;
import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;

import java.util.List;

public interface FamilyService {
    List<FamilyMember> getAllMembers(int familyId);
    int getBalance(List<IncomeExpenses> incomeExpensesList);



}