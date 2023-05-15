package MazePathDFS;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class MazeClass extends JFrame implements ActionListener
{
    private int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1},
            {1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    JButton click;
    ArrayList<int[]>path = new ArrayList<int[]>();
    MazeClass()
    {
        this.setTitle("Path Through Maze");
        this.setSize(1080, 720);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("maze.png");
        this.setIconImage(icon.getImage());
        this.setVisible(true);

        click = new JButton("Press to find path");
        click.setLocation(300, 100);
        click.setBounds(300, 100, 200, 50);
        click.addActionListener(this);
        this.add(click);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        if(action.equals("Press to find path")) {
            DFS search = new DFS();
            search.findPath(maze, 1, 1, path);
            click.setEnabled(false);

        }
    }

    @Override
    public void paint(Graphics g)
    {
        g.translate(300, 200);
        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze[0].length; j++)
            {
                Color color;
                switch(maze[i][j])
                {
                    case 1 : color = new Color(94, 7, 7); break; //obstruction (red)
                    case 9 : color = new Color(45, 128, 24); break; //exit (green)
                    default : color = new Color(206, 206, 206); //navigable path (white)

                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(new Color(66, 66, 66, 255));
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }

        for(int i = 0; i < path.size(); i++)
        {
            int x = path.get(i)[0];
            int y = path.get(i)[1];
            g.setColor(Color.BLUE);
            g.fillRect(30*x, 30*y, 30, 30);
            g.setColor(new Color(66, 66, 66, 255));
            g.drawRect(30*x, 30*y, 30, 30);
        }
    }

    public static void main(String[] args)
    {
        MazeClass frame = new MazeClass();
    }
}
