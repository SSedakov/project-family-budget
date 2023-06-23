package de.ait.app;
import de.ait.models.Family;
import de.ait.models.FamilyMember;
import de.ait.models.IncomeExpenses;
import de.ait.repositories.FamilyRepository;
import de.ait.repositories.FamilyRepositoryTextFileImpl;
import de.ait.services.FamilyService;
import de.ait.services.FamilyServiceImpl;
import de.ait.services.IncomeExpensesServiceImpl;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FamilyRepository familyRepository = new FamilyRepositoryTextFileImpl("familyMember.txt");

        FamilyService familyService = new FamilyServiceImpl(familyRepository);
        IncomeExpensesServiceImpl incomeExpensesService = new IncomeExpensesServiceImpl();
        int familyId = 1;
        List<FamilyMember> familyMemberList = familyService.getAllMembers(familyId);
        List<IncomeExpenses> incomeExpensesList = incomeExpensesService.formBudget(familyMemberList);
        Family family = familyRepository.createFamily(familyMemberList);


        int command = 1;
        String commandString = "";
        int commandInt = 0;

        System.out.printf(
                "%n%n%n%n%n%n%n                                   Привет!!!  %n" +
                        "                        Я планировщик бюджета твоей семьи.%n" +
                        "                Помогу тебе распланировать его и еще и накопить.%n" +
                        "                     Я уже знаю стартовый бюджет твоей семьи)  %n" +
                        "                                    Начнем?  %n" +
                        "********************************* Да=1, Нет=2 ********************************* %n");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 2) {
            System.out.printf(
                    "                              Ок. Может тогда в другой раз)%n" +
                            "                     В файле txt ты можешь получить всю информацию. %n" +
                            "                             о стартовом бюджете твоей семьи.%n");
            int actualBalance = familyService.getBalance(incomeExpensesList);
            familyService.writeIncomeExpensesFile(incomeExpensesList, familyMemberList, family, actualBalance);
            return;
        } else {
            System.out.printf(
                    "                                     Ок. Поехали)  %n %n %n");
        }

        while (command == 1) {
            System.out.printf(
                    "                           Планируется ли в твоей семье %n" +
                            "                 в этом месяце(кроме зп) ЕЩЕ дополнительный доход? %n" +
                            "--------------------------------------- Да=1, Нет=2 --------------------------- %n");
            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 2) {
            } else {
                System.out.printf(
                        "                               Укажи источник дохода:  %n");
                commandString = scanner.nextLine();
                System.out.printf(
                        "                               Укажи сумму дохода: %n");
                commandInt = scanner.nextInt();
                incomeExpensesList.add(new IncomeExpenses(commandString, commandInt, familyId));
            }
        }

        System.out.printf(
                "                       Планируешь ли ты в этом месяце накопления? %n" +
                        "--------------------------------------- Да=1, Нет=2 --------------------------- %n");
        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 2) {
        } else {
            commandString = "Накопления ";
            System.out.printf(
                    "                          Какой процент ты планируешь отложить %n" +
                            "                               в этом месяце в накопления? %n");
            commandInt = scanner.nextInt();
            if (commandInt > 100) {
                System.out.printf(
                        "%n%n                И где же их взять??? Таких денег у семьи нет... %n%n");

            } else {
                commandInt = incomeExpensesService.addAsideMoney(commandInt, incomeExpensesList, family);
                incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
                System.out.printf("%n%n                        Вау! Ты так и на яхту соберешь!!!  %n%n");

            }

            System.out.printf(
                    "                              Планируешь ли ты оплатить %n" +
                            "                         в этом месяце коммунальные услуги?  %n" +
                            "--------------------------------------- Да=1, Нет=2 --------------------------- %n");
            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 2) {
            } else {
                commandString = "Коммунальные услуги ";
                System.out.printf(
                        "                          Какую сумму ты планируешь потратить %n" +
                                "                         в этом месяце на коммунальные услуги? %n");
                commandInt = scanner.nextInt();
                if (incomeExpensesService.possibleBuy(incomeExpensesList, commandInt)) {
                    incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
                    System.out.printf(
                            "%n%n               О, да! Ты можешь позволить себе содержать этот дворец! %n%n");
                } else {
                    System.out.printf(
                            "                                    Нее!!! %n" +
                                    "                  Пора задуматься о замене дворца на меньший...%n%n%n");
                }
            }
            commandString = "Расходы на питание ";
            System.out.printf(
                    "                       Какую сумму ты планируешь потратить %n" +
                            "                           в этом месяце на продукты? %n");
            commandInt = scanner.nextInt();
            if (incomeExpensesService.possibleBuy(incomeExpensesList, commandInt)) {
                incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
                System.out.printf(
                        "%n%n                               Ок. Потянем %n%n");
            } else {
                System.out.printf(
                        "                                 Нет. Не потянем. %n" +
                                "                        Попробуй перевести семью на манку))) %n%n%n");
            }
            commandString = "Карманные расходы ";
            System.out.printf(
                    "                        Какую сумму ты планируешь выделить %n" +
                            "                        в этом месяце на карманные расходы?  %n");
            commandInt = scanner.nextInt();
            if (incomeExpensesService.possibleBuy(incomeExpensesList, commandInt)) {
                incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
                System.out.printf(
                        "%n%n                Ок. Гуляем))) Не забудь сводить жену в ресторан... %n%n");
            } else {
                System.out.printf(
                        "                               Ого. Это не реально. %n" +
                                "                      Может предложишь всем бросить курить? %n%n%n");
            }

            command = 1;
            while (command == 1) {
                System.out.printf(
                        "                         Планируешь ли ты в этом месяце  %n" +
                                "                          ЕЩЕ крупные покупки для семьи? %n" +
                                "--------------------------------------- Да=1, Нет=2 --------------------------- %n");
                command = scanner.nextInt();
                scanner.nextLine();
                if (command == 2) {
                } else {
                    System.out.printf(
                            "                                     И что же это?  %n");
                    commandString = scanner.nextLine();
                    //scanner.nextLine();
                    System.out.printf(
                            "                                     Сколько стоит?  %n");
                    commandInt = scanner.nextInt();
                    if (incomeExpensesService.possibleBuy(incomeExpensesList, commandInt)) {
                        incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
                        System.out.printf(
                                "%n%n                          Ок. А почему бы и нет))) %n%n");
                    } else {
                        System.out.printf(
                                "                В этом месяце забудь или тебе надо ограбить банк.%n" +
                                        "                Кстати, банк за поворотом в соседнем квартале) %n%n%n%n");
                    }
                }
            }

            System.out.printf(
                    "                             ############### %n" +
                            "                  ##########                 ##########   %n" +
                            "            ###########           SUPER !!!       ########## %n" +
                            "     ########             Твой бюджет спланирован!         #########%n" +
                            "            ###########     Смотри распечатку     ########## %n" +
                            "                  ##########                  ########  %n" +
                            "                             ############### %n%n");

            int actualBalance = familyService.getBalance(incomeExpensesList);
            familyService.writeIncomeExpensesFile(incomeExpensesList, familyMemberList, family, actualBalance);
        }
    }
}


