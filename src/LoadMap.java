

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadMap{
	
	
	
	public static Tile[][] getMap(String fileName) throws FileNotFoundException
	{
		int x=0;
		int xFinal=0;
		int y=0;
		int startX=0;
		int startY=0;
		String mapReader="";
		//System.out.println(new File(".").getAbsolutePath());
		Scanner scan = new Scanner(new File("test.txt"));
		scan.useDelimiter(" ");
			/*System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());
			System.out.println(scan.nextLine());*/
			while(scan.hasNextLine())
			{
				Scanner scan2 = new Scanner(scan.nextLine());
				while(scan2.hasNext())
				{
					
					mapReader= scan2.next();
					if(!mapReader.equals("."))
					{
						if(mapReader.equals("0"))
						{
							//this is the center of the map;
							startX=x;
							startY=y;
						}
						
					}
					x++;

					
				
				}
				if(x>xFinal)
				{
					xFinal=x;
				}
				x=0;
				y++;
				System.out.println();
				scan2.close();
			}
			scan.close();
			System.out.println(xFinal+" "+y);
			
			Tile[][] mapArray = new Tile[xFinal][y];
			
			x=0;
			y=0;
			
			
			scan = new Scanner(new File("test.txt"));
			scan.useDelimiter(" ");
				while(scan.hasNextLine())
				{
					Scanner scan2 = new Scanner(scan.nextLine());
					while(scan2.hasNext())
					{
						
						
						//System.out.print(scan2.next());
						mapReader= scan2.next();
						if(!mapReader.equals("."))
						{
							if(mapReader.equals("g"))
							{
								//mapArray[x][y]=new Tile((x-startX)*16,(y-startY)*16,Color.RED);
								mapArray[x][y]=new Tile((x-startX)*VariablesFinal.SIZE_OF_TILE,(y-startY)*VariablesFinal.SIZE_OF_TILE,false,17*5,0);
							}
							else if(mapReader.equals("d"))
							{
								mapArray[x][y]=new Tile((x-startX)*VariablesFinal.SIZE_OF_TILE,(y-startY)*VariablesFinal.SIZE_OF_TILE,false,17*6,0);
							}
							else if(mapReader.equals("0"))
							{
								mapArray[x][y]=new Tile((x-startX)*VariablesFinal.SIZE_OF_TILE,(y-startY)*VariablesFinal.SIZE_OF_TILE,false,9*17,0);
							}
							else if(mapReader.equals("w"))
							{
								mapArray[x][y]=new Tile((x-startX)*VariablesFinal.SIZE_OF_TILE,(y-startY)*VariablesFinal.SIZE_OF_TILE,true,5*17,0*17,53*17,23*17);
							}
							else if(mapReader.equals("f"))
							{
								mapArray[x][y]=new Tile((x-startX)*VariablesFinal.SIZE_OF_TILE,(y-startY)*VariablesFinal.SIZE_OF_TILE,true,3*17,7*17);
							}
							
						}
						x++;
					
					}
					x=0;
					y++;
					scan2.close();
				}
				scan.close();
			
		
		
		return  mapArray;
	}

}
