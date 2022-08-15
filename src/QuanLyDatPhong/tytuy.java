package QuanLyDatPhong;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class tytuy {


	  public static void main(String[] args) {
	    // create a JFrame to hold everything
	    JFrame f = new JFrame("TabbedPaneFrame");
	    f.addWindowListener(new WindowAdapter( ) {
	      public void windowClosing(WindowEvent we) { System.exit(0); }
	    });
	    f.setSize(200, 200);
	    f.setLocation(200, 200);

	    JTabbedPane tabby = new JTabbedPane( );
	    
	    // create a controls pane
	    JPanel controls = new JPanel( );
	    controls.add(new JLabel("Service:"));
	    JList list = new JList(new String[] { "Web server", "FTP server" });
	    list.setBorder(BorderFactory.createEtchedBorder( ));
	    controls.add(list);
	    controls.add(new JButton("Start"));
	    
	    // create an image pane
	    String filename = "hinh/khach-san.jpg";
	    Image image = Toolkit.getDefaultToolkit( ).getImage(filename);
	    JComponent picture = new JScrollPane(new ImageComponent());
	    
	    tabby.addTab("Controls", controls);
	    tabby.addTab("Picture", picture);
	    
	    f.getContentPane( ).add(tabby);
	    f.setVisible(true);
	  }
	}

