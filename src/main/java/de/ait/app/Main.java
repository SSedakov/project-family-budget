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

        System.out.printf("%n %n" +
                    "********************** Привет!!! **********************  %n" +
                    "********** Я планировщик бюджета твоей семьи. ********* %n" +
                    "**  Помогу тебе распланировать его и еще и накопить. ** %n" +
                    "******  Я уже знаю стартовый бюджет твоей семьи) ****** %n" +
                    "********************** Начнем? ************************ %n" +
                    "******************* Да=1, Нет=2 *********************** %n");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 2) {
            System.out.printf(
                    "******************** Ок. Как скажешь.****************** %n" +
                    "**** В файле txt ты можешь получить всю информацию **** %n" +
                    "************ о стартовом бюджете твоей семьи. ********* %n");
            familyService.writeIncomeExpensesFile(incomeExpensesList);
            return;
        } else {
            System.out.println("Укажите источник дохода");
            commandString = scanner.nextLine();
            //scanner.nextLine();
            System.out.println("Укажите сумму дохода");
            commandInt = scanner.nextInt();

    }


        while (command == 1) {
            System.out.println("Планируется ли в вашей семье ЕЩЁ дополнительный доход в этом месяце(кроме зп)?");
            System.out.println("Да=1, Нет=2");
            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 2) {
            } else {
                System.out.println("Укажите источник дохода");
                commandString = scanner.nextLine();
                //scanner.nextLine();
                System.out.println("Укажите сумму дохода");
                commandInt = scanner.nextInt();
                incomeExpensesList.add(new IncomeExpenses(commandString, commandInt, familyId));
            }
        }

            System.out.println("Планируете ли Вы накопления в этом месяце?");
            System.out.println("Да=1, Нет=2");
            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 2) {
            } else {
                commandString = "Накопления";
                System.out.println("Какой процент Вы планируете отложить в накопления в этом месяце?");
                commandInt = scanner.nextInt();
                commandInt = incomeExpensesService.addAsideMoney(commandInt, incomeExpensesList,family);
                incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
            }


            System.out.println("Планируете ли Вы оплатить коммунальные услуги в этом месяце?");
            System.out.println("Да=1, Нет=2");
            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 2) {
            } else {
                commandString = "коммунальные услуги";
                System.out.println("Какую сумму планируете потратить в этом месяце на коммунальные услуги?");
                commandInt = scanner.nextInt();
                if (incomeExpensesService.possibleBuy(incomeExpensesList,commandInt)) {
                    incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
                } else {
                    System.out.println("Ваши траты превышают балланс. Вы не можете себе это позволить.");
                }
            }

            commandString = "расходы на питание";
            System.out.println("Какую сумму планируете выделить в этом месяце на продукты");
            commandInt = scanner.nextInt();
            if (incomeExpensesService.possibleBuy(incomeExpensesList,commandInt)) {
                incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
            } else {
                System.out.println("Ваши траты превышают балланс. Вы не можете себе это позволить.");
            }
            commandString = "карманные расходы";
            System.out.println("Какую сумму планируете выделить в этом месяце на карманные расходы");
            commandInt = scanner.nextInt();
            if (incomeExpensesService.possibleBuy(incomeExpensesList,commandInt)) {
                incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
            } else {
                System.out.println("Ваши траты превышают балланс. Вы не можете себе это позволить.");
            }


            command = 1;
            while (command == 1) {
                System.out.println("Планируется ли в вашей семье ЕЩЁ крупные покупки в этом месяце?");
                System.out.println("Да=1, Нет=2");
                command = scanner.nextInt();
                scanner.nextLine();
                if (command == 2) {
                } else {
                    System.out.println("Что Вы хотите купить?");
                    commandString = scanner.nextLine();
                    //scanner.nextLine();
                    System.out.println("Укажите сумму покупки");
                    commandInt = scanner.nextInt();
                    if (incomeExpensesService.possibleBuy(incomeExpensesList,commandInt)) {
                        incomeExpensesList.add(new IncomeExpenses(commandString, -commandInt, familyId));
                    } else {
                        System.out.println("Ваши траты превышают балланс. Вы не можете себе это позволить.");
                    }
                }
            }

            System.out.println(incomeExpensesList);

            System.out.println("Сумма денежных средств на расчетном счете: "
                    + familyService.getBalance(incomeExpensesList));
        System.out.println(family.getAsideMoney());


        int actualBalance = familyService.getBalance(incomeExpensesList);
        familyService.writeIncomeExpensesFile(incomeExpensesList,familyMemberList,family,actualBalance);


        }
    }


