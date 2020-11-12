// This program reads a data file and counts votes for candidates.

import java.util.*;
import java.io.*;

public class TallyVotes1 {
    public static void main(String[] args) 
            throws FileNotFoundException {
        Scanner input = new Scanner(new File("vote.txt"));
        ArrayList<Ballot> ballots = readFile(input);
        Collections.sort(ballots);
        oneRound(ballots);
    }

    // Reads a data file of voter preferences, returning a list
    // of the resulting ballots.  Candidate names are listed in
    // order of preference with tabs separating choices.
    public static ArrayList<Ballot> readFile(Scanner input) {
        ArrayList<Ballot> result = new ArrayList<>();
        while (input.hasNextLine()) {
            String text = input.nextLine();
            result.add(new Ballot(text.split("\t")));
        }
        return result;
    }

    // Counts and reports votes for each candidate.  Assumes the
    // list is in order by candidate name.
    public static void oneRound(ArrayList<Ballot> ballots) {
        int index = 0;
        while (index < ballots.size()) {
            String next = ballots.get(index).getCandidate();
            int count = processVotes(next, index, ballots);
            index += count;
        }
    }

    // Counts and reports the votes for the next candidate
    // starting at the given index in the ballots list.
    public static int processVotes(String name, int index,
                                   ArrayList<Ballot> ballots) {
        int count = 0;
        while (index < ballots.size() && 
               ballots.get(index).getCandidate().equals(name)) {
            index++;
            count++;
        }
        double percent = 100.0 * count / ballots.size();
        System.out.printf("%d votes for %s (%4.1f%%)\n", count,
                          name, percent);
        return count;
    }
}