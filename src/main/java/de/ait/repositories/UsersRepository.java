package de.ait.repositories;

import de.ait.models.FamilyMember;

import java.util.List;

public interface UsersRepository {
    List<FamilyMember> findAll();
}
