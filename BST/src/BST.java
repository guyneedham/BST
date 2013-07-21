/**
 * Created with IntelliJ IDEA.
 * User: Guy
 * Date: 20/03/13
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BST {

    BinarySearchTree<Integer> BST;
    BSTIterator<Integer> iterator;

    JTextField inputBox;
    JLabel outputLabel;
    JPanel panel;
    JPanel innerPanel;
    JFrame frame;

    public BST() {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }

    public static void main(String[] args) {
        new BST();
    }

    protected void createAndShowGUI() {
        frame = new JFrame("Integer sorter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        innerPanel = new JPanel();
        JLabel label = new JLabel("<html> Welcome to the integer sorter." + "<P>" + "Input your numbers, press enter, and they will be returned sorted by size." + "<P>" + "Do not separate input numbers by any punctuation.");
        panel.add(label);
        addInputBox();

        String text = "Sorted numbers appear here.";

        outputLabel = new JLabel(text);
        innerPanel.add(outputLabel);
        panel.add(innerPanel);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void addInputBox() {

        inputBox = new JTextField(25);
        inputBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                BST = new BinarySearchTree<Integer>();

                System.out.println("Entry = " + inputBox.getText());
                String[] inputs = inputBox.getText().split("\\s+");
                for (String s : inputs) {
                    int nextInput = Integer.parseInt(s);
                    System.out.println("Current input: " + nextInput);

                    BST.insert(nextInput, nextInput);

                }

                System.out.println("After Insert Loop");
                String text = printBST();
                StringBuilder sorts = new StringBuilder();

                for (char c : text.toCharArray()) {
                    if (Character.isDigit(c)) {
                        sorts.append(c);
                        sorts.append(" ");
                    }
                }

                innerPanel.removeAll();
                JLabel outputLabel = new JLabel(sorts.toString());
                innerPanel.add(outputLabel);
                innerPanel.validate();
                innerPanel.repaint();
            }
        });

        panel.add(inputBox);

        frame.getContentPane().add(panel);
    }

    public String printBST() {
        int[] sorted = new int[BST.getSize()];
        int i = 0;

        iterator = new BSTIterator(BST.getRoot());
        while(iterator.hasNext()) {
            TreeNode next = iterator.next();
            System.out.println(next.getElem());
            sorted[i] = next.getKey();
            i++;
        }

        return Arrays.toString(sorted);
    }

}