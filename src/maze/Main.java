package maze;
import java.util.*;
public class Main {
      public static void main(String args[]){
	     MazeMap mazemap=new MazeMap();
	     mazemap.printMap();
	     System.out.println("\n");
	     
	     Point parent=new AStar().searchWay(mazemap.start,mazemap.end);
	     
	     ArrayList<Point> list=new ArrayList<>();
	     
	     while(parent!=null){
	    	 list.add(new Point(parent.x,parent.y));
	    	 parent=parent.preP;
	     }
	     
	     for(int i=0;i<7;i++){
	    	 for(int j=0;j<7;j++){
	    		 if(AStar.exits(list,i,j)){
	    			 System.out.print("☺"+" ");
	    		 }else{
	    			 System.out.print(mazemap.map[i][j]+" ");
	    		 }
	    	 }
	    	 System.out.println();
	    	 
	     }
  }
}
