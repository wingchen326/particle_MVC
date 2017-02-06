package PaSkCode;
import java.util.ArrayList;


public class PSysModel {
    // ArrayList or similar of particles
    // each particle: x, y, velX, velY, radius
	  int size = 5;
	  int px;
	  int py;
	  int velX;
	  int velY;
	  int radius;
	  
	  private ArrayList<Particle> P_List;
	
	  
    PSysModel() {
	// instantiate list of particles
    	
     P_List = new ArrayList<Particle>();
        	
     }

    // add a particle to list 
    void add(int rad, int x, int y, int vx, int vy) {
   
    	radius = rad;
    	px = x;
    	py = y;
    	velX = vx;
    	velY = vy;
    
    	//add particle objects to list.
    	Particle p_obj = new Particle(radius, px, py, velX, velY);
    		P_List.add (p_obj);
    	}
    
    // get list of 5 particles.
    public ArrayList<Particle> getList() {
    	return P_List;    	
    }


    // update state of each particle in list
    void update(int bw, int bh) {
        	
           for(int i= 0; i< P_List.size(); i++){
        	   P_List.get(i).px += P_List.get(i).velX;
        	   P_List.get(i).py += P_List.get(i).velY;
        	   
        	if (P_List.get(i).px >= bw-P_List.get(i).radius&& P_List.get(i).velX> 0) {
        	    P_List.get(i).velX = -P_List.get(i).velX;
        	}
        	else if (P_List.get(i).px < P_List.get(i).radius && P_List.get(i).velX< 0) {
        	    P_List.get(i).velX = -P_List.get(i).velX;
        	}

        	if (P_List.get(i).py >= bh-P_List.get(i).radius && P_List.get(i).velY > 0) {
        	    P_List.get(i).velY = - P_List.get(i).velY;
        	}
        	else if (P_List.get(i).py < P_List.get(i).radius && P_List.get(i).velY < 0) {
        	    P_List.get(i).velY = - P_List.get(i).velY;
        	}
      	
           }
    		
    	}
    		
    	}
    	
    

