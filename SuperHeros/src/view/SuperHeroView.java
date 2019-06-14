package view;

import controller.SuperHeroController;
import dao.SuperHeroData;
import dto.AddSuperHero;
import service.InvalidTeamNameException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SuperHeroView implements Runner {
    SuperHeroController controller;

    @Override
    public void run(SuperHeroController c) {
        controller = c;

        boolean loop;

        while (loop = true) {
            PrintMenu();
            int opt = menuPrompt();
            switch (opt) {
                case 1:
                    System.out.println("Picked Print all Super Heroes\n");
                    System.out.println(c.listSuperHeroes());
                    break;
                case 2:
                    System.out.println("Picked Print all Super Teams\n");
                    System.out.println(c.getSuperTeam());
                    break;
                case 3:
                    System.out.println("Picked Print all Super Heroes with their Teams\n");
                    String teamName = promptTeamName();
                    System.out.println(c.listSuperHeroes(teamName));
                    break;
                case 4:
                    System.out.println("Enter a super hero!\n");
                    AddSuperHero hero = printNewSuperHero();
                    c.addSuperHero(hero);
                    break;
                case 5:
                    System.out.println("No?\n");
                    loop = false;
                    break;
                case -1:
                    break;
                default:
                    System.out.println("Enter a valid menu option!\n");
                    break;
            }
        }
    }


    public void PrintMenu() {
        System.out.println("Database for the hero");
        System.out.println("1. Print all Super Heroes");
        System.out.println("2. Print all Super Teams");
        System.out.println("3. Print all Super Heroes with their Teams");
        System.out.println("4. Enter a superhero");
    }

    public int menuPrompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a choice");
        int opt = -1;
        try {
            opt = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input!\n");
        }
        return opt;
    }

    public String promptTeamName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a team name");
        String teamName = sc.nextLine();
        return teamName;
    }

    public AddSuperHero printNewSuperHero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a super hero");
        String superName = sc.nextLine();
        System.out.println("Enter the real name");
        String realName = sc.nextLine();
        System.out.println("Enter the powers");
        String powerString = sc.nextLine();
        ArrayList<String> powers = new ArrayList<String>(Arrays.asList(powerString.split(",")));
        System.out.println("Enter the age");
        int age = sc.nextInt();
        System.out.println("Enter the height");
        double height = sc.nextDouble();
        System.out.println("Enter the weight");
        double weight = sc.nextDouble();
        System.out.println("Enter the sex");
        char sex = sc.next().toUpperCase().charAt(0);
        String teamName = promptTeamName();
        AddSuperHero hero = new AddSuperHero(superName, realName, powers, age, height, weight, sex, teamName);
        return hero;

        }
    }

