import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager
{

    public static List<List<String>> createEmptyMatrix(int n, int m)
    {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Invalid dimension.");
        }
    
        List<List<String>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < m; j++)
            {
                row.add("O");
            }
            matrix.add(row);
        }
    
        return matrix;
    }

    public static Boolean isBetweenLimits(List<List<String>> matrix, int x, int y)
    {
        int xLength = matrix.size();
        int yLength = matrix.get(0).size();

        boolean xChecker = x >= 0 && x < xLength;
        boolean yChecker = y >= 0 && y < yLength;

        return xChecker && yChecker;
    }

    public static Boolean hasBeenVisited(List<List<Integer>> visitedPositions, int x, int y)
    {
        List<Integer> position = new ArrayList<Integer>(Arrays.asList(x,y));
        int checkX = position.get(0);
        int checkY = position.get(1);
        for (List<Integer> positions : visitedPositions)
        {
            //Get x,y positions.get(x)
            int checkX2 = positions.get(0);
            int checkY2 = positions.get(1);
            if (checkX == checkX2 && checkY == checkY2)
            {
                return true;
            }            
        }
        return false;
    }

    public static Boolean isBlocked(List<List<Integer>> blockedPositions, int x, int y)
    {
        List<Integer> position = new ArrayList<Integer>(Arrays.asList(x,y));
        int checkX = position.get(0);
        int checkY = position.get(1);
        for (List<Integer> positions : blockedPositions)
        {
            //Get x,y positions.get(x)
            int checkX2 = positions.get(0);
            int checkY2 = positions.get(1);
            if (checkX == checkX2 && checkY == checkY2)
            {
                return true;
            }            
        }
        return false;
    }

    public static List<List<List<Integer>>> BADrecursiveFunction(
    List<List<String>> matrix,
    List<List<Integer>> route,
    List<Integer> start,
    List<Integer> end,
    List<List<List<Integer>>> allRoutes)
    {
        // Checking if start is a valid position
        int x = start.get(0);
        int y = start.get(1);


        if(Manager.isBetweenLimits(matrix, x, y) && !(hasBeenVisited(route, x, y)))
        {
            // Add they to the route
            route.add(start);
            System.out.println("Aca queda 1");

            // If new position is equals to end, we have finished
            int x2 = end.get(0);
            int y2 = end.get(1);
            if(x2 == x && y2 == y) 
            {
                System.out.println("Aca queda 2");
                route.add(start);
                allRoutes.add(route);
                // Clean route
                route.clear();
            }

            List<Integer> copy1 = new ArrayList<>(start);
            List<Integer> copy2 = new ArrayList<>(start);
            List<Integer> copy3 = new ArrayList<>(start);
            List<Integer> copy4 = new ArrayList<>(start);

            // Increment x copy1
            copy1.set(0, start.get(0) + 1);
            BADrecursiveFunction(matrix, route, copy1, end, allRoutes);

            // Increment y copy2
            copy2.set(1, start.get(1) + 1);
            BADrecursiveFunction(matrix, route, copy2, end, allRoutes);

            // Decrement x copy3
            copy3.set(0, start.get(0) - 1);
            BADrecursiveFunction(matrix, route, copy3, end, allRoutes);

            // Decrement y copy4
            copy4.set(1, start.get(1) - 1);
            BADrecursiveFunction(matrix, route, copy4, end, allRoutes);

        }
        return allRoutes;
    }

    public static List<List<List<Integer>>> recursiveFunction(
    List<List<String>> matrix,
    List<List<Integer>> route,
    List<Integer> start,
    List<Integer> end,
    List<List<List<Integer>>> allRoutes,
    List<List<Integer>> blockedPositions)
    {
    int x = start.get(0);
    int y = start.get(1);

    if (Manager.isBetweenLimits(matrix, x, y) && !Manager.hasBeenVisited(route, x, y) && !Manager.isBlocked(blockedPositions, x, y))
    {
        // Add the position to the route
        route.add(start);

        int x2 = end.get(0);
        int y2 = end.get(1);

        if (x == x2 && y == y2)
        {
            // If we reached the end, add the route to allRoutes
            allRoutes.add(new ArrayList<>(route));
        }
        
        else
        {
            // Increment x
            List<Integer> copy1 = new ArrayList<>(start);
            copy1.set(0, start.get(0) + 1);
            recursiveFunction(matrix, route, copy1, end, allRoutes, blockedPositions);

            // Increment y
            List<Integer> copy2 = new ArrayList<>(start);
            copy2.set(1, start.get(1) + 1);
            recursiveFunction(matrix, route, copy2, end, allRoutes, blockedPositions);

            // Decrement x
            List<Integer> copy3 = new ArrayList<>(start);
            copy3.set(0, start.get(0) - 1);
            recursiveFunction(matrix, route, copy3, end, allRoutes, blockedPositions);

            // Decrement y
            List<Integer> copy4 = new ArrayList<>(start);
            copy4.set(1, start.get(1) - 1);
            recursiveFunction(matrix, route, copy4, end, allRoutes, blockedPositions);
        }

        // Remove the last position to backtrack
        route.remove(route.size() - 1);
    }

    return allRoutes;
}
    public static void main(String[] args)
    {
        //Let's try it
        List<List<String>> matrix = Manager.createEmptyMatrix(2,2);
        List<List<Integer>> route = new ArrayList<List<Integer>>();
        List<List<Integer>> toBlock = new ArrayList<List<Integer>>();

        toBlock.add(new ArrayList<>());


        List<List<List<Integer>>> allRoutes = new ArrayList<List<List<Integer>>>();
        List<Integer> start = new ArrayList<Integer>(Arrays.asList(0,0));
        List<Integer> end = new ArrayList<Integer>(Arrays.asList(1,1));

        Manager.recursiveFunction(matrix, route, start, end, allRoutes, toBlock);

        System.out.println(allRoutes);
    }

}