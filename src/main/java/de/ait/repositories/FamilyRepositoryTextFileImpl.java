package de.ait.repositories;

import de.ait.models.Family;
import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyRepositoryTextFileImpl implements FamilyRepository {

    private String fileName;




    public FamilyRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public List<FamilyMember> createFamilyMember(int familyId){
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



        return new FamilyMember(
                firstName, lastName, age, status, salary,  familyId
        );
    }
    @Override
    public Family createFamily(List<FamilyMember> memberList) {

        int balance = 0;
        int asideMoney = 0;
        int familyId = 0;
        for (int i = 0; i < memberList.size(); i++) {
           balance = balance + memberList.get(i).getSalary();
           familyId = memberList.get(i).getFamilyId();
        }
        return new Family(balance,asideMoney,familyId);
    }

    @Override
    public void writeIncomeExpensesFile(List<IncomeExpenses> list) {
        try (FileWriter fileWriter = new FileWriter("IncomeExpensesReport.txt");

             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write("" + list.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }


    }
}


