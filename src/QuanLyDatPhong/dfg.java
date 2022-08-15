package QuanLyDatPhong;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import DanhMuc.FormDichVu;
 
public class dfg {
 
    private static void createAndShowGUI() {
 
        // Create and set up the window.
        final JFrame frame = new JFrame("Split Pane Example");
 
        // Display the window.
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // set grid layout for the frame
        frame.getContentPane().setLayout(new GridLayout(1, 1));
 
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
 
        tabbedPane.addTab("Tab2", makePanel("This is tab 2"));
        tabbedPane.addTab("Tab3", makePanel("This is tab 2"));
        tabbedPane.addTab("Tab4", makePanel("This is tab 2"));
        tabbedPane.addTab("Tab5", makePanel("This is tab 2"));
        tabbedPane.addTab("Tab6", makePanel("This is tab 2"));
 
        frame.getContentPane().add(tabbedPane);
 
    }
 
    private static Component makePanel(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
 
  //Schedule a job for the event-dispatching thread:
 
  //creating and showing this application's GUI.
 
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
 
public void run() {
 
    createAndShowGUI(); 
 
}
 
  });
    }
 
}
//
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class dfg {
//   private JFrame mainFrame;
//   private JLabel headerLabel;
//   private JLabel statusLabel;
//   private JPanel controlPanel;
//   private JLabel msglabel;
//
//   public dfg(){
//      prepareGUI();
//   }
//
//   public static void main(String[] args){
//      dfg swingLayoutDemo = new dfg();  
//      swingLayoutDemo.showSpringLayoutDemo();       
//   }
//      
//   private void prepareGUI(){
//      mainFrame = new JFrame("Vi du Java Swing");
//      mainFrame.setSize(400,400);
//      mainFrame.setLayout(new GridLayout(3, 1));
//
//      headerLabel = new JLabel("",JLabel.CENTER );
//      statusLabel = new JLabel("",JLabel.CENTER);        
//
//      statusLabel.setSize(350,100);
//      mainFrame.addWindowListener(new WindowAdapter() {
//         public void windowClosing(WindowEvent windowEvent){
//	        System.exit(0);
//         }        
//      });    
//      controlPanel = new JPanel();
//      controlPanel.setLayout(new FlowLayout());
//
//      mainFrame.add(headerLabel);
//      mainFrame.add(controlPanel);
//      mainFrame.add(statusLabel);
//      mainFrame.setVisible(true);  
//   }
//
//   private void showSpringLayoutDemo(){
//
//      headerLabel.setText("Layout in action: SpringLayout");   
//      SpringLayout layout = new SpringLayout();
//
//      JPanel panel = new JPanel();
//      panel.setLayout(layout);
//      JLabel label = new JLabel("Enter Name: ");
//      JTextField textField = new JTextField("", 15);
//      panel.add(label);
//      panel.add(textField);
//
//      layout.putConstraint(SpringLayout.WEST, label,5,
//         SpringLayout.WEST, controlPanel);
//      layout.putConstraint(SpringLayout.NORTH, label,5,
//         SpringLayout.NORTH, controlPanel);
//      layout.putConstraint(SpringLayout.WEST, textField,5,
//         SpringLayout.EAST, label);
//      layout.putConstraint(SpringLayout.NORTH, textField,5,
//         SpringLayout.NORTH, controlPanel);
//      layout.putConstraint(SpringLayout.EAST, panel,5,
//         SpringLayout.EAST, textField);
//      layout.putConstraint(SpringLayout.SOUTH, panel,5,
//         SpringLayout.SOUTH, textField);
//      controlPanel.add(panel);
//      mainFrame.setVisible(true);  
//   } 
//}