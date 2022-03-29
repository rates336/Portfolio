package gameHub.info.RPS;

import java.util.Scanner;

public class Info {
    Info info = new Info();
    public void help() {
        System.out.println("You entered to help center");
        System.out.println("My name is robot Rumbo Jumbo, for friends Jumbo");
        System.out.println("Remember if you don't know how make something enter jumbo");
        System.out.println("When you call out me I try to help you :)");
        System.out.println("If you want help details enter: jumbo, if you not want");
        System.out.println("help now enter: skip");
        System.out.println("Remember sIzE oF LeTtErS is important, use only small letters");
        Scanner scanner = new Scanner(System.in);
        if(scanner.next().equals("jumbo")) {
            info.jumboHelpCenter();
        }
    }
    //To implements help center
    public void jumboHelpCenter() {
        System.out.println("In future the lace had help center");
        System.out.println("IN FUTURE bro ;)");
    }
    public void howToPlay() {
        System.out.println("For play please enter correct value");
        System.out.println("When you get message info about enter your type");
        System.out.println("you must enter value how explain under the line");
        System.out.println("For Rock enter: 1");
        System.out.println("For Paper enter 2");
        System.out.println("For Scissors enter 3");
    }
    public void howToExit() {
        System.out.println("If you want whenever stop play and save your stats");
        System.out.println("Enter in your turn: SAS");
        System.out.println("This is short from Stop And Save");
        System.out.println("But when you want finish your game and not save stats");
        System.out.println("Enter in your turn: FANS");
        System.out.println("This is short from Finish And Not Save");
    }


}
