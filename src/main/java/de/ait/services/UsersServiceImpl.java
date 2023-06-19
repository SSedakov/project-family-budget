package de.ait.services;

import de.ait.models.FamilyMember;
import de.ait.models.User;
import de.ait.repositories.UsersRepository;

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
    public String getLastNameOfMostAging() {

        List<FamilyMember> users = usersRepository.findAll();
        Map<Integer, String> userAge = new HashMap<>();

        for (FamilyMember user : users) {
            userAge.put(user.getAge(), user.getLastName());
        }

        int maxAge = Collections.max(userAge.keySet());
        return userAge.get(maxAge);
    }
}
