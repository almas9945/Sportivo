package com.example.sporty;

public class Match<E> {
    private Outcomes result;
    private player<E> first;
    private player<E> second;

    public enum Outcomes {
        ePlayer_One_Won,
        ePlayer_Two_Won,
        eDraw
    };

    public Match(player<E> firstPlayer, player<E> secondPlayer,
                 Outcomes result)
    {
        first = firstPlayer;
        second = secondPlayer;
        this.result = result;
        firstPlayer.addMatch(this);
        secondPlayer.addMatch(this);
    }

    /**
     * The opponent of the given player in this match.
     * @param player played in this match.
     */
    public player<E> getOpponent(player<E> player) {
        player<E> opponent = null;
        if (player == first) {
            opponent = second;
        }
        else if (player == second) {
            opponent = first;
        }
        else {
            throw new IllegalArgumentException(
                    "Given player was not in this match.");
        }
        return opponent;
    }

    /**
     * The score of the given player in this match.
     * @return 1 for a win, 0 for a loss, and 0.5 for a tie.
     * @throws IllegalArgumentException if player was not in this match.
     */
    public double getScore(player<E> player) {
        double score = 0.5;
        if (player == first) {
            switch (result) {
                case ePlayer_One_Won:
                    score = 1.0;
                    break;
                case ePlayer_Two_Won:
                    score = 0.0;
                    break;
                case eDraw:
                    score = .5;
                    break;
            }
        } else if (player == second) {
            switch (result) {
                case ePlayer_One_Won:
                    score = 0.0;
                    break;
                case ePlayer_Two_Won:
                    score = 1.0;
                    break;
                case eDraw:
                    score = .5;
                    break;
            }
        } else {
            throw new IllegalArgumentException(
                    "Given player was not in this match.");
        }
        return score;
    }
}
