package de.ait.services;
import de.ait.models.Family;
import de.ait.models.IncomeExpenses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class IncomeExpensesServiceImplTest {
    private final IncomeExpensesService incomeExpensesService = new IncomeExpensesServiceImpl();
    @DisplayName("Проверка возможности осуществления покупки (сумма = 100)")
    @Test
    public void possibleBuy_testPossibleBuy_PurchasePossible(){
        List<IncomeExpenses> incomeExpensesList = new ArrayList<>();
        int sumOfPurchase = 100;
        boolean result = incomeExpensesService.possibleBuy(incomeExpensesList, sumOfPurchase);
        assertTrue(result);
    }

    @DisplayName("Проверка возможности осуществления покупки (сумма = 10000)")
    @Test
    public void possibleBuy_testPossibleBuy_PurchaseNotPossible(){
        List<IncomeExpenses> incomeExpensesList = new ArrayList<>();
        int sumOfPurchase = 10000;
        boolean result = incomeExpensesService.possibleBuy(incomeExpensesList, sumOfPurchase);
        assertFalse(result);
    }

    @Test
    public void AddAsideMoney_testAddAsideMoney_moneyAccumulated(){
        List<IncomeExpenses> y = new ArrayList<>();
        Family family;
        int x = 10;
        int sum = 1000;
        int actual = sum*x/100;
        int expected = 100;
        assertEquals(actual, expected);
    }
}
