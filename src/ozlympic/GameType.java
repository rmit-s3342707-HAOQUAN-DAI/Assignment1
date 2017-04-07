package ozlympic;

public class GameType {
    static int SWIMMING = 1;
    static int CYCLING = 2;
    static int RUNNING = 3;
    static int ALL = 0;

    public static int getRandomGameType() {
        return Utility.GetRandom(0, 3);
    }

    public static int getRandomSpeed(int gameType)  // speed for different games
    {
        if (gameType == SWIMMING) {
            return Utility.GetRandom(100, 200);
        }
        if (gameType == CYCLING) {
            return Utility.GetRandom(500, 800);
        }
        if (gameType == RUNNING) {
            return Utility.GetRandom(10, 20);
        }
        return 0;
    }
}