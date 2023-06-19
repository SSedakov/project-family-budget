package de.ait.repositories;

import de.ait.models.FamilyMember;
import de.ait.models.User;

import java.util.List;

public interface UsersRepository {
    List<FamilyMember> findAll();
}
