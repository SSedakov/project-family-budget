package de.ait.services;

import de.ait.models.Family;
import de.ait.models.FamilyMember;

import java.util.List;

public interface UsersService {
    List<String> getNames();
    int addBudget(List<FamilyMember> family);
}
