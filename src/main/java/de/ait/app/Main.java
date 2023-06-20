package de.ait.app;

import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import de.ait.services.UsersService;
import de.ait.services.UsersServiceImpl;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("familyMember.txt");
        UsersRepository testUserRepository = new UsersRepositoryListImpl();
        UsersService usersService = new UsersServiceImpl(usersRepository);
        System.out.println(usersRepository.findAll());
        System.out.println("Планируется в вашей семье дополнительный доход в этом месяце(кроме зп)?");
        System.out.println("Да=1, Нет=2");
        int command=0;
        String commandString="";
        int commandInt=0;
        command = scanner.nextInt();
        scanner.nextLine();
        if (command==1) {
            System.out.println("Укажите источник дохода");
            commandString = scanner.nextLine();
            //scanner.nextLine();
            System.out.println("Укажите сумму дохода");
            commandInt= scanner.nextInt();

        }

        System.out.println(commandString);
        System.out.println(commandInt);





        while (true) {
            System.out.println("1. Вывести имена всех членов семьи");
            System.out.println("2. Вывести актуальный семейный бюджет");
            System.out.println("3. Вывести отложенную сумму");
            System.out.println("4. Вывести сумму потраченную за прошедший месяц");

            System.out.println("0. Выход");

          command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    System.out.println("Выводим имена всех членов семьи");
                    List<String> names = usersService.getNames();
                    for (String name : names) {
                        System.out.println(name);
                    }

                    break;



                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }
        }
    }
}
