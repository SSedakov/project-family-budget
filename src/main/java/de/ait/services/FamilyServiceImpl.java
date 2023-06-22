package de.ait.services;

import de.ait.models.*;
import de.ait.repositories.FamilyRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FamilyServiceImpl implements FamilyService {

    private FamilyRepository familyRepository;
    private FamilyMember familyMember;




    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }



    @Override
    public List<FamilyMember> getAllMembers(int familyId) {
        return familyRepository.createFamily(familyId);
    }

    @Override
    public int getBalance(List<IncomeExpenses> incomeExpensesList) {
        int totalBalance = 0;
        for (IncomeExpenses incomeExpenses : incomeExpensesList) {

            totalBalance += incomeExpenses.getSum();
        }
        return totalBalance;
        }
    }



/*
    @Override
    public void writeTransactionsToFile
            (List<Income> incomes, List<Expense> expenses, List<Accumulation> accumulations) {
        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("transactions.txt"))){
            writer.write("Поступления денежных средств:\n");
            for (Income income : incomes){
                writer.write("Назначение: " + income.getPurpose()
                        + ", Сумма: " + income.getSum()
                        + ", Дата: " + income.getDate()
                        + ", ID: " + income.getId() + "\n");
            }
            writer.write("Списания денежных средств:\n");
            for (Expense expense : expenses){
                writer.write("Назначение: " + expense.getPurpose()
                        + ", Сумма: " + expense.getSum()
                        + ", Дата: " + expense.getDate()
                        + ", ID: " + expense.getId() + "\n");
            }
            writer.write("Накопление денежных средств:\n");
            for (Accumulation accumulation : accumulations){
                writer.write("Назначение: " + accumulation.getPurpose()
                        + ", Сумма: " + accumulation.getSum()
                        + ", Дата: " + accumulation.getDate()
                        + ", ID: " + accumulation.getId() + "\n");
            }
            writer.close();
        } catch (IOException e){
            System.out.println("Ошибка при записи транзакций в файл: " + e.getMessage());
        }
    }
*/


