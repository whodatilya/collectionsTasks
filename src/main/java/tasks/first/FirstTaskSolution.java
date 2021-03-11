package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class FirstTaskSolution implements FirstTask {
    public Scanner scanner = new Scanner(System.in);

    @Override
    public String breadthFirst (boolean [] [] adjacencyMatrix, int indexStart){
        String res = "";
        int matrixLength = adjacencyMatrix.length;
        ArrayList<Integer> stat = new ArrayList<>();
        ArrayDeque<Integer> graph = new ArrayDeque<Integer>();
        graph.add(indexStart);
        while(stat.size() < matrixLength)
        {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < matrixLength; i++)
            {
                if (adjacencyMatrix[i][graph.peekFirst()])
                {
                    tempList.add(i);
                }
            }
            Collections.sort(tempList);
            graph.addAll(tempList);

            if(!stat.contains(graph.peekFirst()))
            {
                stat.add(graph.peekFirst());
                res = res + graph.pop() + ",";
            }
            else
                {
                graph.removeFirst();
                }
        }
        return res.substring(0, res.length() - 1);
    }


    @Override
    public Boolean validateBrackets(String s)
    {
        String oBraces = "([{";
        String cBraces = ")]}";
        char[] input = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character c : input)
        {
            if (oBraces.contains(c.toString()))
            {
                stack.add(c);
            } else if (cBraces.contains(c.toString()))
            {
                if (stack.isEmpty())
                {
                    return false;
                } else if (cBraces.indexOf(c) == oBraces.indexOf(stack.peekLast()))
                {
                    stack.removeLast();
                }
            }
        }
        return stack.isEmpty();
    }


    @Override
    public Long polishCalculation(String s)
    {
        return Long.valueOf(0);
    }
}