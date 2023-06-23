package de.ait.repositories;

import de.ait.models.Family;
import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;

import java.util.List;

public interface FamilyRepository {
    List<FamilyMember> createFamilyMember(int familyId);
    Family createFamily(List<FamilyMember> memberList);
    void writeIncomeExpensesFile(List<IncomeExpenses> list);
}