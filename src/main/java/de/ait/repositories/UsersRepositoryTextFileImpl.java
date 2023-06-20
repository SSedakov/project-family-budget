package de.ait.repositories;

import de.ait.models.Family;
import de.ait.models.FamilyMember;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository {

    private String fileName;
    private int totalBudget = 0;

    public UsersRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
    }
    public int getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(int totalBudget) {
        this.totalBudget = totalBudget;
    }

    @Override
    public List<FamilyMember> findAll() {
        List<FamilyMember> users = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                FamilyMember user = parseLine(line);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return users;
    }




    public FamilyMember parseLine(String line) {
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String lastName = parsed[1];
        int age = Integer.parseInt(parsed[2]);
        String status = parsed[3];
        int salary = Integer.parseInt(parsed[4]);

        totalBudget = totalBudget + salary;

        return new FamilyMember(
                firstName, lastName, age, status, salary
        );
    }
    //public void addBudget(Family family) {
    //    family.addBudget(totalBudget);
 }



