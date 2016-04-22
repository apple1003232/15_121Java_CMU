/*

	A graphical component for displaying the contents of a 	binary tree.

 	DO NOT CHANGE THIS CLASS!
 	
*/

import java.awt.*;
import java.awt.geom.*;
import java.util.Stack;
import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TreeDisplay<E> extends JComponent {
    private static final int ARC_PAD = 2; // pixels between text and edge
    private TreeNode<E> root = null; // the tree being displayed

    public TreeDisplay() {
        JFrame frame = new JFrame("Tree Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    // Called whenever the TreeDisplay must be drawn on the screen.
    public void paint(Graphics g) {
        if (root == null) return; // No tree to draw.
        
        Graphics2D g2 = (Graphics2D) g;
        Dimension d = getSize();
        g2.setPaint(Color.white);
        g2.fill(new Rectangle2D.Double(0, 0, d.width, d.height));

        // Avoid division by zero if only one level in tree.
        int depth = (getDepth() == 1 ? 2 : getDepth());

        TreeNode<E> leftmost = root;
        while (leftmost.left != null) leftmost = leftmost.left;
        TreeNode<E> rightmost = root;
        while (rightmost.right != null) rightmost = rightmost.right;
            
        // Compute the size of the text
        FontMetrics font = g2.getFontMetrics();
        int leftPad = font.stringWidth(leftmost.data + "") / 2;
        int rightPad = font.stringWidth(rightmost.data + "") / 2;
        int textHeight = font.getHeight();

        int minX = leftPad + ARC_PAD;
        int maxX = d.width - rightPad - ARC_PAD;
        int yInit = textHeight / 2 + ARC_PAD;
        int yIncrement = (d.height - textHeight - 2 * ARC_PAD) / (depth - 1);
        drawTree(g2, root, minX, maxX, yInit, yIncrement);
    }

    // Draws the tree starting at t, with x = {minX, ..., maxX}, starting from
    // yInit and incrementing to byIncr at each level.
    private void drawTree(Graphics2D g2, TreeNode<E> t, int minX, int maxX,
                          int yInit, int yIncr) {
        if (t == null) return; // No tree to draw.

        int x = (minX + maxX) / 2;
        int nextY = yInit + yIncr;

        // Draw black lines.
        g2.setPaint(Color.black);
        if (t.left != null) {
            int nextX = (minX + x) / 2;
            g2.draw(new Line2D.Double(x, yInit, nextX, nextY));
        }
        if (t.right != null) {
            int nextX = (x + maxX) / 2;
            g2.draw(new Line2D.Double(x, yInit, nextX, nextY));
        }

        // Measure text.
        FontMetrics font = g2.getFontMetrics();
        String text = t.data + "";
        int textHeight = font.getHeight();
        int textWidth = font.stringWidth(text);

        // Draw the box around the node.
        Rectangle2D.Double box = new Rectangle2D.Double(
            x - textWidth / 2 - ARC_PAD,
            yInit - textHeight / 2 - ARC_PAD,
            textWidth + 2 * ARC_PAD,
            textHeight + 2 * ARC_PAD);
        Color c = new Color(187, 224, 227);
        g2.setPaint(c);
        g2.fill(box);
        
        // Draw black border.
        g2.setPaint(Color.black);
        g2.draw(box);

        // Draw text.
        g2.drawString(text, x - textWidth / 2, yInit + textHeight / 2);

        // Draw children.
        drawTree(g2, t.left, minX, x, nextY, yIncr);
        drawTree(g2, t.right, x, maxX, nextY, yIncr);
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
        repaint();
    }

    private int getDepth() {
        Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
        Stack<Integer> leftStack = new Stack<Integer>();
        Stack<Integer> rightStack = new Stack<Integer>();

        nodeStack.push(root);
        leftStack.push(-1);
        rightStack.push(-1);

        while (true) {
            TreeNode<E> t = nodeStack.peek();
            int left = leftStack.peek();
            int right = rightStack.peek();

            if (t == null) {
                nodeStack.pop();
                leftStack.pop();
                rightStack.pop();
                int value = 0;
                if (nodeStack.isEmpty())
                    return value;
                else if (leftStack.peek() == -1) {
                    leftStack.pop();
                    leftStack.push(value);
                } else {
                    rightStack.pop();
                    rightStack.push(value);
                }
            } else if (left == -1) {
                nodeStack.push(t.left);
                leftStack.push(-1);
                rightStack.push(-1);
            } else if (right == -1) {
                nodeStack.push(t.right);
                leftStack.push(-1);
                rightStack.push(-1);
            } else {
                nodeStack.pop();
                leftStack.pop();
                rightStack.pop();
                int value = 1 + Math.max(left, right);
                if (nodeStack.isEmpty())
                    return value;
                else if (leftStack.peek() == -1) {
                    leftStack.pop();
                    leftStack.push(value);
                } else {
                    rightStack.pop();
                    rightStack.push(value);
                }
            }
        }
    }
}
