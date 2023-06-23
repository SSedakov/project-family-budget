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

        System.out.println(incomeExpensesList);

        int command = 1;
        String commandString = "";
        int commandInt = 0;

        System.out.printf(
                    "********************** Привет!!! **********************  %n" +
                    "********* Я планировщик бюджета твоей семьи. ********** %n" +
                    "**  Помогу тебе распланировать его и еще и накопить. ** %n" +
                    "******  Я уже знаю стартовый бюджет твоей семьи) ****** %n" +
                    "*********************** Начнем? *********************** %n" +
                    "********************* Да=1, Нет=2 ********************* %n");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 2) {
            System.out.printf(
                    "******************** Ок. Как скажешь. ******************* %n" +
                    "***** В файле txt ты можешь получить всю информацию ***** %n" +
                    "*********** о стартовом бюджете твоей семьи.  *********** %n");
            int actualBalance = familyService.getBalance(incomeExpensesList);
            familyService.writeIncomeExpensesFile(incomeExpensesList,familyMemberList,family,actualBalance);
           return;
        } else {
            System.out.printf(
                    "--------------------- Ок. Начинаем) --------------------- %n %n %n");
               }

        while (command == 1) {
            System.out.printf(
                    "+++++++++++++ Планируется ли в твоей семье ++++++++++++++ %n" +
                    "+++ в этом месяце(кроме зп) еще дополнительный доход? +++ %n"+
                    "++++++++++++++++++++++ Да=1, Нет=2 ++++++++++++++++++++++ %n");
            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 2) {
            } else {
                System.out.printf(
                     "++++++++++++++++ Укажи источник дохода: ++++++++++++++++ %n");
                commandString = scanner.nextLine();
                System.out.printf(
                     "++++++++++++++++++ Укажи сумму дохода: +++++++++++++++++ %n");
                commandInt = scanner.nextInt();
                incomeExpensesList.add(new IncomeExpenses(commandString, commandInt, familyId));
            }
        }

            System.out.printf(
                    "+++++++ Планируешь ли ты в этом месяце накопления? ++++++ %n" +
                    "++++++++++++++++++++++ Да=1, Нет=2 ++++++++++++++++++++++ %n");
            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 2) {
            } else {
                commandString = "Накопления ";
                System.out.printf(
                     "+++++++++ Какой процент ты планируешь отложить +++++++++ %n" +
                     "++++++++++++++ в этом месяце в накопления? +++++++++++++ %n");
                commandInt = scanner.nextInt();
                commandInt = incomeExpensesService.addAsideMoney(commandInt, incomeExpensesList,family);
                incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
            }

            System.out.printf(
                     "+++++++++++++++ Планируешь ли ты оплатить +++++++++++++++ %n" +
                     "+++++++++++ в этом месяце коммунальные услуги? ++++++++++ %n" +
                     "++++++++++++++++++++++ Да=1, Нет=2 ++++++++++++++++++++++ %n");
            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 2) {
            } else {
                commandString = "Коммунальные услуги ";
                System.out.printf(
                     "+++++++++++++ Какую сумму ты планируешь потратить +++++++ %n" +
                     "+++++++++  в этом месяце на коммунальные услуги? ++++++++ %n");
                commandInt = scanner.nextInt();
                if (incomeExpensesService.possibleBuy(incomeExpensesList,commandInt)) {
                    incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
                } else {
                    System.out.printf(
                      "++++++ Траты твоей семьи превышают семейный баланс. ++++++ %n" +
                      "+++++++++ Твоя семья не может себе это позволить. ++++++++ %n");
                }
            }
            commandString = "Расходы на питание ";
            System.out.printf(
                        "++++++++++ Какую сумму ты планируешь потратить ++++++++++ %n" +
                        "+++++++++++++++ в этом месяце на продукты? ++++++++++++++ %n");
            commandInt = scanner.nextInt();
            if (incomeExpensesService.possibleBuy(incomeExpensesList,commandInt)) {
                incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
            } else {
                System.out.printf(
                        "++++++ Траты твоей семьи превышают семейный баланс. +++++ %n" +
                        "+++++++++ Твоя семья не может себе это позволить. +++++++ %n");
            }
            commandString = "Карманные расходы ";
            System.out.printf(
                        "+++++++++++ Какую сумму ты планируешь выделить ++++++++++ %n" +
                        "+++++++++++ в этом месяце на карманные расходы? +++++++++ %n");
            commandInt = scanner.nextInt();
            if (incomeExpensesService.possibleBuy(incomeExpensesList,commandInt)) {
                incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
            } else {
                System.out.printf(
                        "++++++ Траты твоей семьи превышают семейный баланс. +++++ %n" +
                        "+++++++++ Твоя семья не может себе это позволить. +++++++ %n");
            }

            command = 1;
            while (command == 1) {
                System.out.printf(
                        "+++++++++++++ Планируешь ли ты в этом месяце ++++++++++++ %n" +
                        "+++++++++++++ еще крупные покупки для семьи? ++++++++++++ %n" +
                        "++++++++++++++++++++++ Да=1, Нет=2 ++++++++++++++++++++++ %n");
                command = scanner.nextInt();
                scanner.nextLine();
                if (command == 2) {
                } else {
                    System.out.printf(
                         "+++++++++++++++ Что ты планируешь купить? ++++++++++++++ %n");
                    commandString = scanner.nextLine();
                    //scanner.nextLine();
                    System.out.printf(
                         "+++++++++++++++ Укажи стоимость покупки: +++++++++++++++ %n");
                    commandInt = scanner.nextInt();
                    if (incomeExpensesService.possibleBuy(incomeExpensesList,commandInt)) {
                        incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
                    } else {
                        System.out.printf(
                          "+++++ Траты твоей семьи превышают семейный баланс. +++++ %n" +
                          "++++++++ Твоя семья не может себе это позволить. +++++++ %n");
                    }
                }
            }
            System.out.println(incomeExpensesList);

        /*    System.out.printf(
                          "======= Сумма денежных средств на расчетном счете: "
                    + familyService.getBalance(incomeExpensesList));
        System.out.println(family.getAsideMoney());*/

        int actualBalance = familyService.getBalance(incomeExpensesList);
        familyService.writeIncomeExpensesFile(incomeExpensesList,familyMemberList,family,actualBalance);
        }
    }


