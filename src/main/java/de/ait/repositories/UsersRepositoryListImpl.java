package de.ait.repositories;

import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;

import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryListImpl implements UsersRepository {

    @Override
    public List<FamilyMember> createFamily() {
        FamilyMember user1 =
                new FamilyMember("Ivan", "Ivanov", 35, "father",4000);
        FamilyMember user2 =
                new FamilyMember("Mari", "Ivanova", 30, "mother",4000);
        FamilyMember user3 =
                new FamilyMember("Daniil", "Ivanov", 7, "son",0);
        FamilyMember user4 =
                new FamilyMember("Liana", "Ivanova", 5, "daughter",0);

        List<FamilyMember> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        return users;
    }


    public List<IncomeExpenses> createList() {
        return null;
    }

    @Override
    public  List<IncomeExpenses> addToList(String title, int sum) {
     return null;
    }

    @Override
    public int formBudget() {
        return 0;
    }


}
