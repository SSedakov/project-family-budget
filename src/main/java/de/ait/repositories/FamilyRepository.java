package de.ait.repositories;

import de.ait.models.FamilyMember;

import java.util.List;

public interface FamilyRepository {
    List<FamilyMember> createFamily(int familyId);
}
