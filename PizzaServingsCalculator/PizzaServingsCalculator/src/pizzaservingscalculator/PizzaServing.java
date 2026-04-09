package pizzaservingscalculator;

/**
 * due 10/5/23
 * @author Kevin Cai
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PizzaServing extends JFrame {
   public static void main(String s[]) { 
    JFrame frame = new JFrame("Pizza Servings Calculator");
    
    JLabel jLabelResult = new JLabel("",SwingConstants.CENTER);
    
    JLabel jLabelTitle = new JLabel("Pizza Servings Calculator",SwingConstants.CENTER);
    jLabelTitle.setForeground(Color.RED);
    jLabelTitle.setFont(new Font("Serif", Font.BOLD,28));
    frame.add(jLabelTitle);
    
    JPanel line2 = new JPanel();
    JLabel jLabelInches = new JLabel("Enter the size of the pizza in inches : ");
    line2.add(jLabelInches);
    
    JTextField jTextField = new JTextField();
    jTextField.setColumns(4);
    line2.add(jTextField);
    frame.add(line2);
    
    JButton jButton = new JButton("Calculate Servings");
    
    jButton.addActionListener((ActionEvent e) -> {
        String input = jTextField.getText();
        if(!input.isEmpty()) {
            double size = Double.parseDouble(input);
            double servings = Math.pow((size / 8),2);            
            jLabelResult.setText("A " + input + " inch pizza will serve " + String.format("%.2f", servings) + " people.");
        }
        else {
            jLabelResult.setText("Invalid value.");
        }
        
    });

    frame.add(jButton);
    frame.add(jLabelResult);
    frame.setLayout(new GridLayout(4,1));
    frame.setSize(350,300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}