// Question - Given a row of n houses, each house can be coloured with any of the three colours: let these be red blue or
// green. the cost for painting a particular house with a particular colour is going to be different. you have to colour
// the house in such a way that no two adjacent houses will have the same colour. the cost for painting  a house with any
// colour is represented by  n X 3 cost matrix where cost for painting house 0 with colour red is cost[0][0] and cost for
// painting house 4 with green colour is cost[4][2] and so on.....calculate the minimum cost to paint all houses.
// try to optimize it for space !!

// Time Complexity : O(m* 2^n) where m is the numbr of colors and n is the number of houses
// Space Complexity : O(n) stack spce used during recursion
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

//
public class PaintHouse {

    static int minCost(int[][] costs) {
        int total = costs[0].length;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < total; i++) {
            min = Math.min(min, colorHouse(costs, 0, i));
        }
        return min;
    }
    static  int colorHouse(int[][] costs, int index, int color) {
        if(index == costs.length) return 0;
        int min  = Integer.MAX_VALUE;
          for(int i = 0; i < costs[0].length; i++) {
              if(i != color) {
                  min = Math.min(min, costs[index][color] + colorHouse(costs, index+1, i));
              }
          }
        return min;
    }
    public static void main(String[] args) {
        int [][] costs = {{17,2,17}, {16, 16, 5},{4,3,19}};
        System.out.println("Minimum costs to paint the houses: " + minCost(costs));
    }

}
