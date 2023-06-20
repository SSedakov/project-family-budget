package de.ait.services;

import de.ait.models.*;

import java.util.List;

public interface UsersService {
    List<String> getNames();


    public void writeTransactionsToFile
            (List<Income> incomes, List<Expense> expenses, List<Accumulation> accumulations);
}
