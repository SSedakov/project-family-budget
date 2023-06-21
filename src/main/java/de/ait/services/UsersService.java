package de.ait.services;

import de.ait.models.*;

import java.util.List;

public interface UsersService {
    List<String> getNames();
    boolean possibleBuy(int sum);


}
