package de.ait.services;

import de.ait.models.*;
import de.ait.repositories.FamilyRepository;

import java.util.List;

public class FamilyServiceImpl implements FamilyService {

    private FamilyRepository familyRepository;
    private FamilyMember familyMember;

    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public List<FamilyMember> getAllMembers(int familyId) {
        return familyRepository.createFamilyMember(familyId);
    }

    @Override
    public int getBalance(List<IncomeExpenses> incomeExpensesList) {
        int totalBalance = 0;
        for (IncomeExpenses incomeExpenses : incomeExpensesList) {

            totalBalance += incomeExpenses.getSum();
        }
        return totalBalance;
        }

    @Override
    public void writeIncomeExpensesFile(List<IncomeExpenses> list,List<FamilyMember> familyMemberList,Family family,int actualBalance) {
        familyRepository.writeIncomeExpensesFile(list,familyMemberList,family,actualBalance);
    }
}