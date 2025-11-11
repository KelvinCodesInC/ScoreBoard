import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Reader {

    public static void read() throws FileNotFoundException {
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);

        String[][] teams = {
                {"Green", "0"},
                {"Orange", "0"},
                {"Blue", "0"},
                {"Indigo", "0"},
                {"Red", "0"},
                {"Violet", "0"},
                {"Yellow", "0"}
        };


        for (int i = 0; i < 1000; i++) {
            String winner;
            String team_1 = s.next();
            String team_2 = s.next();

            boolean is_team_1 = true;
            int team_1_score = 0;
            int team_2_score = 0;

            while (s.hasNextInt()) {
                int play = s.nextInt();

                if (play == 0) {
                    is_team_1 = !is_team_1;
                } else {
                    if (is_team_1) {
                        team_1_score += play;
                    } else {
                        team_2_score += play;
                    }
                }
            }

            if (team_1_score > team_2_score) {
                winner = team_1;
            } else if (team_2_score > team_1_score) {
                winner = team_2;
            } else {
                winner = null;
            }

            if (winner != null) {
                for (int j = 0; j < teams.length; j++) {
                    if (teams[j][0].equals(winner)) {
                        int wins = Integer.parseInt(teams[j][1]);
                        wins++;
                        teams[j][1] = String.valueOf(wins);
                        break;
                    }
                }
            }

            System.out.println(team_1 + " scored: " + team_1_score);
            System.out.println(team_2 + " scored: " + team_2_score);
            System.out.println("Winner: " + winner);

            System.out.println();


        }

        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i][0] + " wins: " + teams[i][1]);
        }
    }
}
