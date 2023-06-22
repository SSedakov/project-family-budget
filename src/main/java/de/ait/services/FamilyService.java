package de.ait.services;

import de.ait.models.Family;
import de.ait.models.FamilyMember;

import java.util.List;

public interface FamilyService {
    List<FamilyMember> getAllMembers(int familyId);
    void getBalanced(int familyId);



}