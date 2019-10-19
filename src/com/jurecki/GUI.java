package com.jurecki;

import java.util.Scanner;

public class GUI {

    public static void showMenu(Machine machine) {
        System.out.print("Write action (buy, fill, take, remaining, exit): ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        switch (option) {
            case "remaining":
                machine.printMachineValues();
                GUI.showMenu(machine);
                break;

            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                String optionBuy = scanner.next();
                if(optionBuy == "back"){
                    GUI.showMenu(machine);
                }
                else{
                    machine.buyCoffee(optionBuy);
                    GUI.showMenu(machine);
                }
                break;

            case "fill":
                machine.fillMachine();
                GUI.showMenu(machine);
                break;

            case "take":
                System.out.println("I gave you $" + String.format("%.2f", machine.getMoney()));
                machine.setMoney(0);
                GUI.showMenu(machine);
                break;

            case "exit":
                System.exit(0);
                break;

            default:
                GUI.showMenu(machine);
                break;
        }
    }

}
