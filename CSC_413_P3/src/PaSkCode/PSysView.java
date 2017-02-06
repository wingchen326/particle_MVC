package PaSkCode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;

public class PSysView{
    
	//private PSysModel PM_obj;
    PSysView() {
    }

    // draw all particles in psm
    void draw(PSysModel PM_obj, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
    	//	g2d.setRenderingHints(
    	//	    new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
    	//			       RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        
        // PM_obj = new PSysModel ();
       ArrayList<Particle> P_List = PM_obj.getList(); //get list of particles from PSySModel.
        for(int i=0; i< P_List.size(); i++){
        	g2d.setColor(Color.RED);
        	g2d.fillOval(P_List.get(i).px- P_List.get(i).radius, 
        			P_List.get(i).py- P_List.get(i).radius,
        			(P_List.get(i).radius)*2,
        			(P_List.get(i).radius)*2); 	
        	
        }     
    }

    // dump information on all particles in psm
    void dump(PSysModel PM_obj, int lc) {
    	ArrayList<Particle> P_List = PM_obj.getList();
    	
    	System.out.println("Frame " + lc);
    	if(lc == 1000){
    		for(int i= 0; i<P_List.size();i++){
    			System.out.println(P_List.get(i).radius + " " + P_List.get(i).px + " " +
 	    					P_List.get(i).py + " " + P_List.get(i).velX + " " + P_List.get(i).velY);
    	}
 	  
    	}
    }
}