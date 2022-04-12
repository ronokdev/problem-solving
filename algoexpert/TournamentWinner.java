package com.ronok.algoexpert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class TournamentWinner {
    public static void main(String args[]){
        List<List<String >> stringList = new ArrayList<>();

        List<String> competitions = new ArrayList<>();
        competitions.add("HTML");
        competitions.add("C#");

        List<String> secondCompetitions = new ArrayList<>();
        secondCompetitions.add("C#");
        secondCompetitions.add("Python");

        List<String> thirdCompetitions = new ArrayList<>();
        thirdCompetitions.add("Python");
        thirdCompetitions.add("HTML");

        stringList.add(competitions) ;
        stringList.add(secondCompetitions) ;
        stringList.add(thirdCompetitions) ;

        List<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(0);
        results.add(1);

        System.out.println(stringList);
        System.out.println(results);
        
        doTournamentWinner(stringList,results);               // Expected Output: Python
        doTournamentWinner(stringList, Arrays.asList(1,1,0)); // Expected Output: HTML
    }

    private static String doTournamentWinner(List<List<String>> stringList, List<Integer> results) {

        /*
        * Steps
        *   - iterate through results arrayList
        *   - 1 means away home Wins
        *   - O means away team Wins
        *       - we will use a hashMap to store the team name
        *       - when iterating through the results array we will first check
        *           - if the team name already exists in the hasSet
        *               - if exists then we just grab the value and add +3 to it
        *                   - we also need to keep track of the value
        *                       - if the value is greater than the present value then we keep track of the team name
        *           - if team name does not exist then we inter the team name as key with value 3
        *
        *
        * Time complexity  : O(n), where n is the result array size
        * Space Complexity : O(k), where n is the number of competitor size
        *
        * */

        HashMap<String, Integer> teamHash = new HashMap<>() ;
        String currentWinner = null;
        String max = null;
        int currentMaxPoint = 0;


        for(int i=0;i< results.size();i++){

            // deciding the current winner name
            currentWinner = ( results.get(i) == 1 )  ? stringList.get(i).get(0) : stringList.get(i).get(1);

            // checking for existing team name in the hash, to update the score
            if(teamHash.containsKey(currentWinner)){
                int currentPoint = teamHash.get(currentWinner);
                teamHash.put(currentWinner,currentPoint+3);
            }

            // checking for existing team name in the hash, if not found then inserting into the hash
            else{
                teamHash.put(currentWinner,3);
                currentMaxPoint = currentMaxPoint == 0 ? 3 : currentMaxPoint;
            }

            // keeping track of the highest point and the team name
            if(currentMaxPoint <= teamHash.get(currentWinner)){
                currentMaxPoint = teamHash.get(currentWinner);
                max = currentWinner;
            }
        }
        System.out.println(max);
        return max;
    }
}
