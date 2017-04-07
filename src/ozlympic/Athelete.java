package ozlympic;

import java.util.*;

public class Athelete {
    int speed;
    int gameType;
    int selectedGameType;
    ArrayList<Integer> ranks = new ArrayList();
    ArrayList<Integer> scores = new ArrayList();
    ArrayList<Integer> speeds = new ArrayList();

    String name = "";

    public Athelete(int gameType) {
        this.name = Utility.GetPersonName();
        this.gameType = gameType;
    }

    int compete() {
        this.speed = GameType.getRandomSpeed(this.selectedGameType);
        return this.speed;
    }

    void putRankByGame(int rank, int gameIndex) {
        while (gameIndex >= this.ranks.size()) {
            this.ranks.add(0);
        }
        if (gameIndex == -1) {
            this.ranks.add(rank);
        } else {
            this.ranks.set(gameIndex, rank);
        }

    }

    void putSpeedByGame(int speed, int gameIndex) {
        while (gameIndex >= this.speeds.size()) {
            this.speeds.add(0);
        }
        if (gameIndex == -1) {
            this.speeds.add(speed);
        } else {
            this.speeds.set(gameIndex, speed);
        }
    }

    void putScoreByGame(int score, int gameIndex) {
        while (gameIndex >= this.scores.size()) {
            this.scores.add(0);
        }
        if (gameIndex == -1) {
            this.scores.add(score);
        } else {
            this.scores.set(gameIndex, score);
        }
    }

    void initGame() {
        this.putSpeedByGame(0, -1);
        this.putScoreByGame(0, -1);
        this.putRankByGame(0, -1);
    }

    int getSpeedByGameIndex(int gameIndex) {
        if (gameIndex >= this.speeds.size()) {
            return 0;
        }
        return this.speeds.get(gameIndex);
    }

    int getRankByGameIndex(int gameIndex) {
        if (gameIndex >= this.ranks.size()) {
            return 0;
        }
        return this.ranks.get(gameIndex);
    }

    int getScoreByGameIndex(int gameIndex) {
        if (gameIndex >= this.scores.size()) {
            return 0;
        }
        return this.scores.get(gameIndex);
    }

    String getName() {
        return this.name;
    }

    int getSpeed() {
        return this.speed;
    }

    void showStats() {
        int totalScore = 0;
        int index = 0;
        boolean showResult = false;
        for (Integer score : scores) {
            totalScore += score;
            if(speeds.get(index) > 0) {
                showResult = true;
            }
        }
        if (showResult) {
            System.out.format("%16s%12d\n", this.name, totalScore);
        }

    }

}