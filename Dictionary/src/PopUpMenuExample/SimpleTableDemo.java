package PopUpMenuExample;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTableDemo extends JFrame{
    
    private boolean DEBUG = true;
    
    public SimpleTableDemo(){
        super("SIMPLE TABLE DEMO");
        Object[][] data=
        {
            {"Mary","Compione","Showboarding",      new Integer(5), new Boolean(false)},
            {"Alison","Huml","Rowing",              new Integer(3), new Boolean(true)},
            {"Kathy","Walrath","Chasing toddlers",  new Integer(2), new Boolean(false)},
            {"Mark","Andrews","Speed reading",      new Integer(20),new Boolean(true)},
            {"Angela","Lih","Teaching high school", new Integer(4), new Boolean(false)}
        };
        String[] columnNames={"First Name","Last Name","Sport","# of Years","Vegetarian"};
        final JTable table = new JTable(data, columnNames);
        JScrollPane pane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(500,70));
        if(DEBUG)
        {
            table.addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked(MouseEvent e)
                {
                    printDebugData(table);
                }
            });
        }
        add(pane);
    }
            
    private void printDebugData(JTable table)
        {
            int numRows = table.getRowCount();
            int numCols = table.getColumnCount();
            
            javax.swing.table.TableModel model = table.getModel();
            System.out.println("Value of data: " );
            for(int i=0; i<numRows; i++)
            {
                System.out.println("row "+i+":");
                for(int j=0; j<numCols; j++)
                {
                    System.out.println(" "+model.getValueAt(i, j));
                }
                System.out.println();
            }
            System.out.println("-----------------------");
        }
        
    public static void main(String[] args) 
    {
        SimpleTableDemo frame = new SimpleTableDemo();
        frame.pack();
        frame.setVisible(true);
    }
}
