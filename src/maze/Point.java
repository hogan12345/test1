package maze;
public class Point {
   public int x;
   public int y;
   public boolean isReach;
   private String icon;
   public Point preP=null;
   public int g;  //估价函数中g(n)值
   public int h;  
   public int f;
   
   
   public Point(int x,int y){
	   this.x=x;
	   this.y=y;
   }
   
   public int getx(){
	   return x;
   }
   
   public int gety(){
	   return y;	
   }
   
   public void setP(int x,int y){
	   this.x=x;
	   this.y=y;
   }
   
  
   
   public void setpreP(Point preP){
	   this.preP=preP;
   }
   
   public Point preP(){
	   return preP;
   }
   
   public boolean equals(Point p){
	   if(p.x==x&&p.y==y)
		   return true;
	   return false;
   }
   
   public void setIcon(String icon){
	   this.icon=icon;
   }
   
   public String getIcon(){
	   return this.icon;
   }
   public boolean isReach(){
	   return isReach;
   }
   
   public String toString(){
	   return icon;
   }
   
   public void setisReach(boolean isReach){
	   if(isReach==true){
		   this.isReach=true;
		   this.icon="□";
	   }
	   else{
		   this.isReach=false;
		   this.icon="■";
		   
	   }
   }
}
