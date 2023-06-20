package de.ait.services;

import de.ait.models.Family;
import de.ait.models.FamilyMember;
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
    public int addBudget(List<FamilyMember> family) {
        return 0;
    }


}
