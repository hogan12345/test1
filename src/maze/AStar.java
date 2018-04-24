package maze;
import java.util.List;
import java.util.ArrayList;
public class AStar {
    private ArrayList<Point> openlist=new ArrayList<Point>();
    private ArrayList<Point> closelist=new ArrayList<Point>();
    MazeMap mazemap=new MazeMap();
   
    
    public Point findMinFPoint(){
    	Point temp=openlist.get(0);
    	for(Point p : openlist){
    		if(getf(p,mazemap)<getf(temp,mazemap)){
    			temp=p;
    		}
    	}
    	return temp;
    }
        
   public static boolean exits(List<Point> p,Point point){
	   for(Point points : p){
		   if(points.x==point.x&&points.y==point.y){
			   return true;
		   }
	   }
	   return false;
   }
   
   public static boolean exits(List<Point> p,int x,int y){
	   for(Point points : p){
		   if(points.x==x&&points.y==y){
			   return true;
		   }
	   }
	   return false;
   }
   
   public boolean reachable(int x,int y){
	   if(x>0&&y<7&&y>0&&x<7){
		   return mazemap.map[x][y].isReach==true;
		   }
	   else{
		   return false;
	   }
   }
   
   
   public ArrayList<Point> Neighbor(Point current){
	   ArrayList<Point> list=new ArrayList<>();
	   
	   int upx=current.x-1;
	   int upy=current.y;
	   if(reachable(upx,upy)&&!exits(closelist,upx,upy)){
		   list.add(new Point(upx,upy));}
		
	   int downx=current.x+1;
	   int downy=current.y;
	   if(reachable(downx,downy)&&!exits(closelist,downx,downy)){
		   list.add(new Point(downx,downy));
	   }
	   
	   int leftx=current.x;
	   int lefty=current.y-1;
	   if(reachable(leftx,lefty)&&!exits(closelist,leftx,lefty)){
		   list.add(new Point(leftx,lefty));
	   }
	   
	   int rightx=current.x;
	   int righty=current.y+1;
	   if(reachable(rightx,righty)&&!exits(closelist,rightx,righty)){
		   list.add(new Point(rightx,righty));
	   }
	   return list;
	   
   }
    
    public static int getg(Point p,MazeMap mazemap){
    	if(p.equals(mazemap.start)){
    		return 0;
    	}
    	return getg(p.preP(),mazemap);
    }
    
    public static int geth(Point p,MazeMap mazemap){
    	return Math.abs(mazemap.end.getx()-p.getx())+Math.abs(mazemap.end.gety()-p.gety());
    }
    
    public static int getf(Point p,MazeMap mazemap){
    	return geth(p,mazemap)+getg(p,mazemap);
    }
    
    public static Point search(List<Point> list,Point point){  //查找表中相同的点
    	for(Point p : list)
    		if((p.x==point.x)&&(p.y==point.y)){
    			return p;
    		}
    		return null;    	
    }
    
    public Point searchWay(Point s,Point e){
    	openlist.add(mazemap.start);
    	
    	while(!openlist.isEmpty()){
    		Point current=findMinFPoint();
    		openlist.remove(current);
    		closelist.add(current);
    		
    		ArrayList<Point> neighbor=Neighbor(current);
    		for(Point p : neighbor){
    			if(exits(openlist,p)){
    				searchPoint(current,p);
    			}else{
    				notsearchPoint(current,mazemap,p);
    			}
    		}
    		 if (search(openlist, mazemap.end) != null) {  
                 return search(openlist, mazemap.end);  
             }  
         }  
   
         return search(openlist, mazemap.end);  
    	}
    
    
    public void searchPoint(Point temp,Point point){
    	int g=getg(temp,mazemap);
    	if(g<point.g){
    		point.preP=temp;
    		point.g=g;
    		point.f=getf(temp,mazemap);
    	}
    }
    
    public void notsearchPoint(Point temp,MazeMap mazemap,Point point){
    	point.preP=temp;
    	point.g=getg(temp,mazemap);
    	point.h=geth(temp,mazemap);
    	point.f=getf(temp,mazemap);
    	openlist.add(point);
    }
}
