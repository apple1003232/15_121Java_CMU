/*
 * 				DO NOT CHANGE/EDIT THIS CLASS
 * 
 */


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GridGUI{
	
		private JFrame window;
		private MouseListener ML;
		
		public GridGUI(Color[][] grid,MouseListener M)
		{
			ML=M;
			createGUI(grid);
		}
		
	   private void createGUI(Color[][] grid) {
	        if(grid == null || grid.length == 0) {
	            System.out.println("You did not initialize the grid! You must " +
	                    "initialize the grid to run the puzzle!");
	            System.exit(0);
	        }

	        // Create the window.
	        JFrame.setDefaultLookAndFeelDecorated(true);
	        window = new JFrame("Column Puzzle");
	        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setResizable(false);

	        // Set up the content pane.
	        Container cp = window.getContentPane();
	        cp.setLayout(new GridLayout(grid.length, grid[0].length));
	        cp.addMouseListener(ML);

	        // Add panels.
	        for (int row = 0; row < grid.length; row++) {
	            for (int col = 0; col < grid[row].length; col++) {
	                JPanel cell = new JPanel();
	                cell.setPreferredSize(new Dimension(100, 100));
	                cell.setBackground(grid[row][col]);
	                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	                cp.add(cell);
	            }
	        }

	        paint(grid);
	    }

	    public void dispose() {
	        if (window != null) {
	            window.setVisible(false);
	            window.dispose();
	        }
	    }

	    public void paint(Color[][] grid) {
	        Container cp = window.getContentPane();
	        for (int row = 0; row < grid.length; row++) {
	            for (int col = 0; col < grid[row].length; col++) {
	                Color curr = grid[row][col];
	                cp.getComponent(row * grid[0].length + col).setBackground(curr);
	            }
	        }
	        window.pack();
	        window.setVisible(true);
	    }


	    /*
	     * Do not change anything below this line. If you do, you will receive a 0.
	     *
	     * You are, however, encouraged to read it. It's OK if you don't understand
	     * every line, but you can probably understand what it's doing in general.
	     */
	    public void setTitle(String title) {
	        window.setTitle(title);
	    }

	    /** 
	     * Gets the title on the Grid Window
	     */
	    public String getTitle() {
	        return window.getTitle();
	    }

}
