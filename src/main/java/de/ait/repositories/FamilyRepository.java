package de.ait.repositories;

import de.ait.models.Family;

public class FamilyRepository<T> implements CrudRepository<Family> {

    @Override
    public void save(Family model) {

    }

    @Override
    public Family findById(String id) {
        return null;
    }
}
