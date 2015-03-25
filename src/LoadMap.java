

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
					
					x++;
					System.out.print(scan2.next());
					
				
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
							if(mapReader.equals("q"))
							{
								mapArray[x][y]=new Tile(x*16,y*16,Color.RED);
							}
							else if(mapReader.equals("w"))
							{
								mapArray[x][y]=new Tile(x*16,y*16,Color.GREEN);
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