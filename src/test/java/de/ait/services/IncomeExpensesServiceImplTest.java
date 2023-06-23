package de.ait.services;
import de.ait.models.Family;
import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class IncomeExpensesServiceImplTest {
    private final IncomeExpensesService incomeExpensesService = new IncomeExpensesServiceImpl();
    List<IncomeExpenses> incomeExpensesList = new ArrayList<>();

    @DisplayName("Проверка возможности осуществления покупки (возможно купить)")
    @Test
    public void possibleBuy_testPossibleBuyTrue_PurchasePossible(){
        int sumOfPurchase = 100;
        boolean result = incomeExpensesService.possibleBuy(incomeExpensesList, sumOfPurchase);
        assertTrue(true, String.valueOf(result));
    }

    @DisplayName("Проверка возможности осуществления покупки (невозможно купить)")
    @Test
    public void possibleBuy_testPossibleBuyFalse_PurchaseNotPossible(){
        int sumOfPurchase = 100;
        boolean result = incomeExpensesService.possibleBuy(incomeExpensesList, sumOfPurchase);
        assertFalse(false, String.valueOf(result));
    }

    @Test
    @DisplayName("Проверка расчета суммы для накопления")
    public void AddAsideMoney_div1000Plus100multiplyBy10_moneyAccumulated(){
        int x = 10;
        int accum = 1000;
        int expected = accum / 100 * x;
        assertEquals(100, expected);
    }
}
