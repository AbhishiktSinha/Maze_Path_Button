package MazePathDFS;

import java.util.ArrayList;

public class DFS
{
    public boolean findPath(int[][] maze, int x, int y, ArrayList<int[]> path)
    {
        if(maze[y][x] == 9) //exit cell
        {
            maze[y][x] = 2;
            path.add(new int[]{x, y});
            return true;
        }
        else if(maze[y][x] == 0) //navigable cell
        {
            //mark visited and find neighbours
            maze[y][x] = 2;

            //down - right - up - left
            int[] dy = {1, 0, -1, 0};
            int[] dx = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++)
            {
                boolean valid_path = findPath(maze, x+dx[i], y + dy[i], path);
                if(valid_path)
                {
                    path.add(new int[]{x, y});
                    return true;
                }
            }
        }
        return false;
    }
}
