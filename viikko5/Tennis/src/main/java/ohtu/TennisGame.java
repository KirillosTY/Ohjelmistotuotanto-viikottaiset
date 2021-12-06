package ohtu;

public class TennisGame {
    
    private int playerOnesScore = 0;
    private int playerTwosScore = 0;
    private String playerOnesName;
    private String playerTwosName;

    public TennisGame(String playerOnesName, String playerTwosName) {

        this.playerOnesName = playerOnesName;

        this.playerTwosName = playerTwosName;
    }

    public void wonPoint(String playerName) {

        if (playerName == "player1") {

            playerOnesScore += 1;
        } else {
            playerTwosScore += 1;
        }
    }

    public String getScore() {

        String score = "";

        score = getScoreString(playerOnesScore);

        if (playerOnesScore == playerTwosScore) {

            if (playerOnesScore > 3) {

                score = "Deuce";
            } else {

                score += "-All";
            }

        } else if (playerOnesScore >=4 || playerTwosScore >=4) {
            int minusResult = playerOnesScore - playerTwosScore;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        } else {
            score += "-";

            score+= getScoreString(playerTwosScore);
        }


        return score;
    }


    public String getScoreString(int playerScore){

        String score = "";
        switch(playerScore) {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;

        }





        return score;
    }
}