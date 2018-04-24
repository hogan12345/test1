package maze;
public class MazeMap {
		public Point[][] map=new Point[8][8];
		public Point start;
		public Point end;
		
		public  MazeMap(){
			int i;
			int j ;
			for(i=0;i<7;i++)
				for(j=0;j<7;j++){
				map[i][j]=new Point(i,j);
			    map[i][j].setisReach(true);
		         }
		
			start=map[5][0];
			start.setIcon("S");
			start.g=0;
			end=map[4][6];
			end.setIcon("E");
					
		  for(j=0;j<7;j++){
			  map[0][j].setisReach(false);
			  
		  }
		  
		  for(i=0;i<5;i++){
			  map[i][0].setisReach(false);
		  }
		  
		  for(i=0;i<3;i++){
			  map[i][5].setisReach(false);
		  }
		  
		 
		  map[5][3].setisReach(false); 
		  map[4][3].setisReach(false);
		  map[6][6].setisReach(false);
		  map[6][5].setisReach(false);        //初始化地图
		}
		
		public void printMap(){
			int i;
			int j;
			for(i=0;i<7;i++){
				for(j=0;j<7;j++){
					System.out.print(map[i][j].getIcon()+" ");
				}
				System.out.println();
		}
		}
	}
