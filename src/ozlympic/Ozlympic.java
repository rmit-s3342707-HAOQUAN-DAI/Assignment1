package ozlympic;

import java.util.*;

public class Ozlympic {
    public static void main(String[] args) {
        Athelete atheletes[] = new Athelete[30];  // randomly get 30 players
        ArrayList<Game> games = new ArrayList<Game>();
        int gameCounter = 0;
        for (int i = 0; i < 30; i++) {
            int gameType = GameType.getRandomGameType();
            atheletes[i] = new Athelete(gameType);

        }
        System.out.println("Ozlympic Game!!!");
        do {
            System.out.println("================================");
            System.out.println("1. Select a game to run");
            System.out.println("2. Display the final results of all games");
            System.out.println("3. Display the scores of all atheletes");
            System.out.format("%15s", "Please select 1 - 3: ");
            Scanner input = new Scanner(System.in);
            int selectedOption = input.nextInt();
            if (selectedOption == 1) {
                do {
                    System.out.println("===============");
                    System.out.println("1. Swimming");
                    System.out.println("2. Cycling");
                    System.out.println("3. Running");
                    System.out.println("4. Return to main menu");
                    System.out.format("%25s", "Please select Game 1 - 3 or 4 to return: ");
                    int selectedOption2 = input.nextInt();
                    if (selectedOption2 == 4) {
                        break;
                    }

                    Game game = new Game(selectedOption2, gameCounter++, atheletes);
                    System.out.println("Do you want to guess the winner? (y/n): ");
                    String guessWinner = "";
                    do {
                        if (input.hasNextLine()) {
                            guessWinner = input.nextLine();
                        }
                    } while (guessWinner.isEmpty());

                    int guessedWinnerSequence = 0;
                    if (!guessWinner.isEmpty() && guessWinner.substring(0, 1).toLowerCase().equals("y")) {
                        game.showAtheleteNames();
                        do {
                            System.out.println("Select which one could be winner? (1-" + game.getAtheletes().size() + "): ");
                            guessedWinnerSequence = input.nextInt();
                            // Check if input is beyond range of atheletes of a game
                            if (guessedWinnerSequence >= 1 && guessedWinnerSequence <= game.getAtheletes().size()) {
                                game.setGuessedWinnerIndex(guessedWinnerSequence);
                                break;
                            }
                        } while (true);
                    }


                    game.run();
                    games.add(game);

                    System.out.println("======== Game End (" + game.getGameTypeText() + ") ==========");
                    game.showAtheleteResults();
                    // Show if guessing is correct???
                    if (guessedWinnerSequence > 0) {
                        Athelete guessedAthelete = game.getAtheletes().get(game.getGuessedWinnerIndex());
                        System.out.println("---- Your guess was: " + guessedAthelete.getName() + " ----");
                        if (game.guessedCorrect()) {
                            System.out.println("**** BINGO!! YOUR GUESS IS CORRECT!!!! ****");
                        } else {
                            System.out.println("---- WRONG GUESS, Try next time... ----");
                        }
                    }

                } while (true);
            }
            if (selectedOption == 2) {
                if (games.size() <= 0) {
                    System.out.println("NO GAME RUN YET.");
                    continue;
                }
                System.out.println("======== All Games Results =========");
                int counter = 1;
                for (Game game : games) {
                    System.out.println("======== Game " + counter + ": (" + game.getGameTypeText() + ") ==========");
                    game.showAtheleteResults();
                    counter++;

                }
            }
            if (selectedOption == 3) {
                if (games.size() <= 0) {
                    System.out.println("NO GAME RUN YET.");
                    continue;
                }
                System.out.println("======== All Atheletes Stats =========");
                System.out.format("%16s%12s\n", "Name", "Score");
                for (int i = 0; i < atheletes.length; i++) {
                    Athelete athelete = atheletes[i];
                    athelete.showStats();
                }
                System.out.println("=====================================");

            }

        } while (true);
    }
}
