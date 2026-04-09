package java2ddrawingapplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
/**
 * due 10/19/23
 * @author Kevin Cai
 */
public class DrawingApplicationFrame extends JFrame{
    
    //Makes panels
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JPanel first_panel = new JPanel();
    private JPanel second_panel = new JPanel();
    

    //Makes firstLine panel
    private JComboBox<String> shapeJcomboBox;
    private JLabel shapelabel;
    private JButton first_button;
    private JButton second_button;
    private JButton undo_button;
    private JButton clear_button;
    

    //Makes secondLine Panel.
    private JLabel options;
    private JCheckBox fill_box;
    private JCheckBox gradient_box;
    private JCheckBox Dash_box;
    private JLabel Width;
    private JLabel len_label;
    private JSpinner stroke_len;
    private JSpinner stroke_width;

    
    //Creates the variables for drawPanel.
    private DrawPanel drawpanel = new DrawPanel();
    ArrayList<MyShapes> Shapes = new ArrayList<>();
    Paint Paint;
    Stroke Stroke;
    private static Color colour1 = Color.CYAN;
    private static Color colour2 = Color.GRAY;
    //Adds status label
    private JLabel status_label;
    private static final String[] Shape = {"Line", "Oval", "Rectangle"};
  
    
    //Constructor for DrawingApplicationFrame
    public DrawingApplicationFrame(){
        
        super("Java 2D Drawings");
        
        
        //firstLine widgets
        shapelabel = new JLabel("Shape:");
        shapeJcomboBox = new JComboBox<String>(Shape);
        shapeJcomboBox.setMaximumRowCount(4);
        first_button = new JButton("1st Color");
        second_button = new JButton("2nd Color");
        undo_button = new JButton("Undo");
        clear_button = new JButton("Clear");
        
        first_panel.add(shapeJcomboBox);
        first_panel.add(shapelabel);
        first_panel.add(first_button);
        first_panel.add(second_button);
        first_panel.add(undo_button);
        first_panel.add(clear_button);
        

        //secondLine widgets
        options = new JLabel("Options");
        fill_box = new JCheckBox("Filled");
        gradient_box = new JCheckBox("Use Gradient");
        Dash_box = new JCheckBox("Dashed");
        Width = new JLabel("Line Width");
        stroke_width = new JSpinner(new SpinnerNumberModel(1,1,20,1));
        len_label = new JLabel("Dash Length");
        stroke_len = new JSpinner(new SpinnerNumberModel(1,1,20,1));
        second_panel.add(options);
        second_panel.add(fill_box);
        second_panel.add(gradient_box);
        second_panel.add(Dash_box);
        second_panel.add(Width);
        second_panel.add(stroke_width);
        second_panel.add(len_label);
        second_panel.add(stroke_len);

        
        //Adds the top panel of two panels
        panel.setLayout(new GridLayout(2,1));
        panel.add(first_panel);
        panel.add(second_panel);
        first_panel.setBackground(Color.cyan);
        second_panel.setBackground(Color.cyan);
        
        
        //Adds the topPanel to North, drawPanel to Center, and statusLabel to South
        add(panel,BorderLayout.NORTH);
        drawpanel.setBackground(Color.WHITE);
        add(drawpanel,BorderLayout.CENTER);
        
        
        status_label = new JLabel("(X,Y)");
        add(status_label,BorderLayout.SOUTH);
        
        
        //Adds the listeners and event handlers
        undo_button.addActionListener(
          new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event ) {
                if (!Shapes.isEmpty()){
                    Shapes.remove(Shapes.size() - 1);
                    repaint();}
                }
            }
        );
        
        
        clear_button.addActionListener(
           new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!Shapes.isEmpty()){
                    Shapes.clear();
                    repaint();
                }
            }
        }
        );
        
        
        first_button.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                colour1 = JColorChooser.showDialog(
                DrawingApplicationFrame.this,"Selct a color",colour1);
                if (colour1 == null)
                    colour1 = Color.BLUE;
                }
            }
                
        );
        
        
        second_button.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                colour2 = JColorChooser.showDialog(
                DrawingApplicationFrame.this,"Selct a color",colour2);
                if(colour2 == null)
                    colour2 = Color.GREEN;
                
            }
            }
                
        );
    
        
    }

    
    //Creates a private inner class for the DrawPanel.
    private class DrawPanel extends JPanel{
        
        public DrawPanel(){
           addMouseListener(new MouseHandler());
           addMouseMotionListener(new MouseHandler());
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //loop through and draw each shape in the shapes arraylist
            for (MyShapes shape: Shapes){
                shape.draw(g2d);
            }
                
        }
        
    }



    private class MouseHandler extends MouseAdapter implements MouseMotionListener{

        @Override
        public void mousePressed(MouseEvent event){

            Point Coordinates = new Point(event.getX(), event.getY());
            float sl = (Float.parseFloat(stroke_len.getValue().toString()));
            MyShapes currentShape = null;

            String shapeName = (String) shapeJcomboBox.getSelectedItem();

            if (Dash_box.isSelected()){
                Stroke = new BasicStroke((float)(int) stroke_width.getValue(),BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10 ,new float[]{sl} ,0);
            }

            else{
                Stroke = new BasicStroke((float)(int) stroke_width.getValue(),BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
            }

            if(gradient_box.isSelected()){
                Paint = new GradientPaint(0,0,colour1,50,50,colour2,true);
            }

            else{
                Paint = colour1;
            }

            switch(shapeName){
                case "Rectangle":
                    MyRectangle R = new MyRectangle(Coordinates,Coordinates,Paint,Stroke,fill_box.isSelected());
                    currentShape = R;
                    break;
                case "Oval":
                    MyOval O = new MyOval(Coordinates,Coordinates,Paint,Stroke,fill_box.isSelected());
                    currentShape = O;
                    break;
                case "Line":
                    MyLine L = new MyLine(Coordinates,Coordinates,Paint,Stroke);
                    currentShape = L;
                    break;
            }
            
            Shapes.add(currentShape);
            repaint();
            status_label.setText(String.format("(%d,%d)",event.getX(),event.getY())); 

        }

        @Override
        public void mouseReleased(MouseEvent event){
            Shapes.get(Shapes.size() - 1).setEndPoint(event.getPoint());
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent event){
            status_label.setText(String.format("(%d, %d)", event.getX(), event.getY()));
            Shapes.get(Shapes.size() - 1).setEndPoint(event.getPoint());
            repaint();

        }

        @Override
        public void mouseMoved(MouseEvent event){

             status_label.setText("(" + event.getX() + "," + event.getY() + ')');


        }
    }

}
