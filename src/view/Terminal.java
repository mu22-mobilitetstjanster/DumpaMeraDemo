package view;

import pojo.Choice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Terminal {
  private static final String EXIT_KEY_WORD = "exit";

  private List<Choice> choices;

  private Scanner scanner;
  private boolean open;

  public Terminal() {
    this.scanner = new Scanner(System.in);
    this.choices = new ArrayList<>();
  }

  public void addChoice(int index, String title) {
    this.choices.add(new Choice(index, title));
  }

  public void viewOptions() {
    this.open = true;
    while(open) {

      for (int i = 0; i < choices.size(); i++) {
        Choice choice = this.choices.get(i);
        System.out.println(i + " - " + choice.getTitle());
      }

      waitForInput();
    }
  }



  private void handleInput(String input) {
    int menuIndex = Integer.parseInt(input);

    ChoiceTerminal terminal = (ChoiceTerminal) this;
    Choice choice = this.choices.get(menuIndex);

    terminal.handleUserChoice(choice.getIndex());
  }

  private void waitForInput() {
    String input = scanner.nextLine();

    if(input.equalsIgnoreCase(EXIT_KEY_WORD)) {
      this.open = false;
    } else {
      this.handleInput(input);
    }
  }


  public String queryInput(String query, List<String> options) {
    System.out.println(query);
    if(options != null) {
      for (int i = 0; i < options.size(); i++) {
        System.out.println(i + " - " + options.get(i));
      }
    }
    return scanner.nextLine();
  }

  public String queryInput(String query) {
    return queryInput(query, null);
  }
}
