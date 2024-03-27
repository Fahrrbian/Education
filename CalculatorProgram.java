package Java1P;


import javax.swing.*;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*; 

public class JavaC1 extends JPanel {
	
//	private final int eingabe; 
	
	private String[] numbers;
	private int[] resultArray; 
	private int count1; 
	private int IndexResult; 
	
	private boolean plusButtonPressed = false; 
	private boolean minusButtonPressed = false; 
	
	private final JFrame finalFrame; 
	
	public JavaC1() {
		finalFrame = new JFrame ("Rechner"); 
		
		finalFrame.setSize(1000, 1000); 
		finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		finalFrame.setLocationRelativeTo(null); 
        
		IndexResult = 1; 
		count1 = 0;
		numbers = new String[10]; 
		resultArray = new int[1]; // Größe ist 1 - Ich möchte hier stattdessen eine fixe größe des Arrays habenb - die der Größe entspricht der Zahlen die eingetragen werden
		
        addButton("1", finalFrame);
        addButton("2", finalFrame);
        addButton("3", finalFrame);
        addButton("4", finalFrame);
        addButton("5", finalFrame);
        addButton("6", finalFrame);
        addButton("7", finalFrame);
        addButton("8", finalFrame);
        addButton("9", finalFrame);
        
    	JButton plus = new JButton("+"); 
		plus.setPreferredSize(new Dimension(100, 50)); 
        plus.setBounds(150, 150, 100, 50); 
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//plusButtonPressed = true; 
                convertToIntegerArray();
            }
        }); 
        add(plus); 
        
        JButton minus = new JButton("-"); 
		plus.setPreferredSize(new Dimension(100, 50)); 
        plus.setBounds(150, 150, 100, 50); 
        plus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//minusButtonPressed = true; 
                convertToIntegerArray();
            }
        }); 
        add(minus); 
        
        JButton gleich = new JButton("="); 
        gleich.setPreferredSize(new Dimension(100, 50));
        gleich.setBounds(150, 150, 100, 50); 
        gleich.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		ergebnisAusgeben(); 
        	}
        });
        add(gleich); 
		//finalFrame.add(plus); 
		
        finalFrame.add(this); 
        
		finalFrame.setVisible(true); 
		}
	
        private void addButton(final String label, final JFrame frame){
        	JButton button = new JButton(label); 
        	button.setPreferredSize(new Dimension(50, 50)); 
        	button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	numbers[count1] = label; 
                	count1++; 
                	 	//An der Stelle muss ein String-Array die 
                }
            });
        	add(button); 
        }
        private int combineNumbers() {
        	String result = ""; 
        	for (int i = 0; i < count1; i++) {
        		result += numbers[i];
        	}
        	try {
        		return Integer.parseInt(result); 
        } catch (NumberFormatException e){
        	System.err.println("Ungültiger Wert: " + result); 
        	return 0; 
        	}
        }
        
        private void convertToIntegerArray() {        
        	
        	try {
    			int combinedValue = combineNumbers();  			
    			int[] newArray = new int[resultArray.length + 1];
    			
    			 for (int i = 0; i < resultArray.length; i++) {
    			        newArray[i] = resultArray[i];
    			    }
    			    
    			    // Den letzten Wert hinzufügen oder initialisieren
    			    newArray[resultArray.length] = combineNumbers();

    			    
    			    // Das aktuelle Array durch das neue Array ersetzen
    			    resultArray = newArray;
    			    // IndexResult inkrementieren
    			    IndexResult++;
    			    for (int i= 0; i < resultArray.length; i++) {
    			    	//System.out.println(resultArray[i]); 
    			    }
    				   //System.out.print(resultArray[i] + " Index " + i);  
            } catch (NumberFormatException e) {
                // Falls der String nicht in einen Integer umgewandelt werden kann
                // Hier können Sie alternative Behandlungsoptionen angeben
                System.err.println("Ungültiger Wert: " + resultArray[IndexResult]); 
    		} 
    		resetInputArray(); 
    	} 
        	
        
    private void resetInputArray() {
    	numbers = new String[10]; 
    	count1 = 0;
    }
    

    
    
    private void ergebnisAusgeben() { // gleich-Met: holt sich die ganzen int werte aus dem resultArray und rechnet diese miteinander
    	convertToIntegerArray(); 
    	int gesamtErg =0; 
    	//if (plusButtonPressed) {
	    	for(int i = 0; i < IndexResult; i++) {
	    		 gesamtErg += resultArray[i];  
    	//	}
    	//}else if (minusButtonPressed) {
    	//	for(int i = 0; i < IndexResult; i++) {
	   // 		 gesamtErg -= resultArray[i];  
    	//	}
    	}
    	System.out.println(gesamtErg); 
    }
        
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				JavaC1 panel = new JavaC1(); 
			}
		}); 
	}
}
