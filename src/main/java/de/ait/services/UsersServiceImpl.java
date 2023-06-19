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
        List<FamilyMember> users = usersRepository.findAll(); // получаем всех пользователей
        List<String> names = new ArrayList<>(); // создаем пустой список имен

        for (FamilyMember user : users) { // пробегаемся по всем пользователям
            names.add(user.getFirstName()); // добавляем имя пользователя в список имен
        }
        // возвращаем имена
        return names;
    }

    @Override
    public String getLastNameOfMostAging() {

        List<FamilyMember> users = usersRepository.findAll();
        Map<Integer, String> userAge = new HashMap<>();

        for (FamilyMember user : users) { // пробегаем по всему списку
            userAge.put(user.getAge(), user.getLastName()); // добавили пару возраст-фамилия
        }

        int maxAge = Collections.max(userAge.keySet()); // находим максимальный возраст

        return userAge.get(maxAge); // возвращаем фамилию, которая лежит под максимальным ключом
    }
}
