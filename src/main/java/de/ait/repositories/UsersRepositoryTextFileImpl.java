package de.ait.repositories;

import de.ait.models.FamilyMember;
import de.ait.models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryTextFileImpl(String fileName) {
        this.fileName = fileName;
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

    private static FamilyMember parseLine(String line) {
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String lastName = parsed[1];
        int age = Integer.parseInt(parsed[2]);
        String status = parsed[3];

        return new FamilyMember(
                firstName, lastName, age, status
        );
    }
}
