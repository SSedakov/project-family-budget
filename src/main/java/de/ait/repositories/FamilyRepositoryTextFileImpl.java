package de.ait.repositories;

import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FamilyRepositoryTextFileImpl implements FamilyRepository {

    private String fileName;



    public FamilyRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public List<FamilyMember> createFamily(int familyId){
        List<FamilyMember> members = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);

             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();

            while (line != null) {
                FamilyMember member = parseLine(line);
                if ( member.getFamilyId() == familyId){
                    members.add(member);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return members;
    }
    //


    public FamilyMember parseLine(String line) {
        String[] parsed = line.split("\\|");
        int familyId = Integer.parseInt(parsed[0]);
        String firstName = parsed[1];
        String lastName = parsed[2];
        int age = Integer.parseInt(parsed[3]);
        String status = parsed[4];
        int salary = Integer.parseInt(parsed[5]);

        // incomeExpenses.add(new IncomeExpenses("Salary ",salary,familyId));

        return new FamilyMember(
                firstName, lastName, age, status, salary,  familyId
        );
    }

    /*
    @Override
    public List<IncomeExpenses> createList() {
        return incomeExpenses;
    }

    @Override
    public List<IncomeExpenses> addToList(String title, int sum) {
        totalBudget = totalBudget + sum;
        incomeExpenses.add(new IncomeExpenses(title, sum));
        return incomeExpenses;
    }

     */

}


