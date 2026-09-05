import java.util.Arrays;

public class Problem5 {

    static class Player implements Comparable<Player> {

        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        // Constructor
        public Player(String name,
                      int matchesPlayed,
                      double battingAverage,
                      boolean injured) {

            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Rule 1: Experience-only
        static boolean isDraftable(int matchesPlayed) {

            return matchesPlayed >= 10;
        }

        // Rule 2: Matches + fitness
        static boolean isDraftable(int matchesPlayed,
                                   boolean injured) {

            return matchesPlayed >= 5 && !injured;
        }

        // Compare players by batting average in descending order
        @Override
        public int compareTo(Player other) {

            return Double.compare(
                other.battingAverage,
                this.battingAverage
            );
        }

        // Main draft and ranking method
        static String draftAndRank(Player[] players) {

            Player[] draftable = new Player[players.length];

            int count = 0;

            for (Player player : players) {

                if (isDraftable(player.matchesPlayed)
                        || isDraftable(player.matchesPlayed,
                                       player.injured)) {

                    draftable[count] = player;
                    count++;
                }
            }

            // Create array containing only draftable players
            Player[] finalDraftable =
                Arrays.copyOf(draftable, count);

            // Sort using compareTo()
            Arrays.sort(finalDraftable);

            String result = "";

            for (int i = 0; i < finalDraftable.length; i++) {

                result += (i + 1) + ". "
                       + finalDraftable[i].name;

                if (i < finalDraftable.length - 1) {
                    result += " | ";
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),

            new Player("Rahul", 7, 55.0, false),

            new Player("Sameer", 3, 60.0, false),

            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(
            Player.draftAndRank(players)
        );
    }
}
