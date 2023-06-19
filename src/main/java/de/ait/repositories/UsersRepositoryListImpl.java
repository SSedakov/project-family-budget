package de.ait.repositories;

import de.ait.models.FamilyMember;
import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryListImpl implements UsersRepository {

    @Override
    public List<FamilyMember> findAll() {
        FamilyMember user1 =
                new FamilyMember("Ivan", "Ivanov", 35, "father");
        FamilyMember user2 =
                new FamilyMember("Mari", "Ivanova", 30, "mother");
        FamilyMember user3 =
                new FamilyMember("Daniil", "Ivanov", 7, "son");
        FamilyMember user4 =
                new FamilyMember("Liana", "Ivanova", 5, "daughter");

        List<FamilyMember> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        return users;
    }
}
