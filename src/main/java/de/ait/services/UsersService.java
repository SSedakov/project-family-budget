package de.ait.services;

import de.ait.models.*;

import java.util.List;

public interface UsersService {
    List<String> getNames();
    int addBudget(List<FamilyMember> family);

    public void writeTransactionsToFile
            (List<Income> incomes, List<Expense> expenses, List<Accumulation> accumulations);
}
