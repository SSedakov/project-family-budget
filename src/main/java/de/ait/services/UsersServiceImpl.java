package de.ait.services;

import de.ait.models.*;
import de.ait.repositories.UsersRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;




    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<String> getNames() {
        List<FamilyMember> users = usersRepository.findAll();
        List<String> names = new ArrayList<>();

        for (FamilyMember user : users) {
            names.add(user.getFirstName());
        }

        return names;
    }




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


}

