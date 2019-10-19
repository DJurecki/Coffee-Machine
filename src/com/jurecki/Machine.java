package com.jurecki;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Machine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private double money;

    public Machine(int water, int milk, int coffeeBeans, int cups, double money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public Machine(){
        this.water = (int)(Math.random() * 2000);
        this.milk = (int)(Math.random() * 2000);
        this.coffeeBeans = (int)(Math.random() * 2000);
        this.cups = (int)(Math.random() * 10);
        this.money = (Math.random() * 500);
    }

    public void printMachineValues(){
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.coffeeBeans + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");

        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        System.out.println(currencyFormatter.format(this.money) + " of money");
    }

    public void fillMachine() throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Write how many ml of water do you want to add: ");
            this.water += scanner.nextInt();
            System.out.println("Write how many ml of milk do you want to add: ");
            this.milk += scanner.nextInt();
            System.out.println("Write how many grams of coffee beans do you want to add: ");
            this.coffeeBeans += scanner.nextInt();
            System.out.println("Write how many disposable cups do you want to add: ");
            this.cups += scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.err.println("Please enter correct number once again");
        }
    }

    public void buyCoffee(String s){
        if (s.equals("1")) calculateEspresso();
        if (s.equals("2")) calculateLatte();
        if (s.equals("3")) calculateCappuccino();
        else System.err.println("Enter correct option");
    }

    private void calculateEspresso(){
        if(this.water >= 250 && this.coffeeBeans >= 16 && this.cups >= 1){
            System.out.println("I have enough resources, making you a Espresso!");
            this.water -= 250;
            this.coffeeBeans -= 16;
            this.money += 4;
            this.cups--;
        }
        else{
            System.out.println("Sorry, not enough resources to make Espresso:(");
        }
    }

    private void calculateLatte(){
        if(this.water >= 350 && this.milk >= 75 && this.coffeeBeans >= 20 && this.cups >= 1){
            System.out.println("I have enough resources, making you a Latte!");
            this.water -= 350;
            this.coffeeBeans -= 16;
            this.money += 7;
            this.cups--;
        }
        else{
            System.out.println("Sorry, not enough resources to make Latte:(");
        }
    }

    private void calculateCappuccino(){
        if(this.water >= 200 && this.milk >= 100 && this.coffeeBeans >= 12 && this.cups >= 1){
            System.out.println("I have enough resources, making you a Cappuccino!");
            this.water -= 200;
            this.milk -= 100;
            this.coffeeBeans -= 12;
            this.cups--;
        }
        else{
            System.out.println("Sorry, not enough resources to make Cappuccino:(");
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
