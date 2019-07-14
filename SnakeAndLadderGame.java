import java.awt.*;
import java.awt.event.*;
import java.applet.*; 


/*<applet code="SnakesandLaddersGame" width=800 height=600> </applet>*/ 


public class SnakeAndLadderGame extends Applet implements Runnable,ActionListener
{ 

	static int N = 10;

	int k,x,y,num,index,clicked,way,i,j;
	int cord[][] = new int[100][2];
	int check_snake[][] = new int[5][4];
	int check_ladder[][] = new int[5][4];
	Button button1;

        static String[] numbers={								//array of numbers to be displayed on the game board.
        "100","99","98","97","96","95","94","93","92","91",
        "81","82","83","84","85","86","87","88","89","90",
        "80","79","78","77","76","75","74","73","72","71",
        "61","62","63","64","65","66","67","68","69","70",
        "60","59","58","57","56","55","54","53","52","51",
        "41","42","43","44","45","46","47","48","49","50",
        "40","39","38","37","36","35","34","33","32","31",
        "21","22","23","24","25","26","27","28","29","30",
        "20","19","18","17","16","15","14","13","12","11",
        "1","2","3","4","5","6","7","8","9","10",
    };
	public void init()
	{

		button1 = new Button("ROLL THE DICE");
		setBounds(650,600,50,50);
		add(button1);
		button1.addActionListener(this);

		x=30;
		y=575;
		index =0;
		clicked =0;
		way =1;



		for(int i=0;i<100;i++)
		{
			if(k == 10)
			{
				k=0;
				if(way == 1)
				{
					x-=60;
				}
				else 
				{
					x+=60;
				}
				y-=60;
				if(way == 1)
				{
					way =0;
				}
				else
					way =1;

			}
			if(k<10 && way == 1)
			{
				cord[i][0]=x;
				x+=60;
				cord[i][1]=y;
				k++;
			}
			else if(k<10 && way == 0)
			{
				cord[i][0]=x;
				x-=60;
				cord[i][1]=y;
				k++;
			}
		}
		x=cord[0][0];
		y=cord[0][1];

		init_snake_and_ladder();
		repaint();
	}

	public void actionPerformed(ActionEvent e) 
	{		
		clicked = 1;
		repaint();
 	}

	public void init_snake_and_ladder()
	{
		check_ladder[0][0] = 150;
		check_ladder[0][1] = 575;
		check_ladder[0][2] = 30;
		check_ladder[0][3] = 335;
		check_ladder[1][0] = 330;
		check_ladder[1][1] = 455;
		check_ladder[1][2] = 390;
		check_ladder[1][3] = 215;
		check_ladder[2][0] = 30;
		check_ladder[2][1] = 275;
		check_ladder[2][2] = 90;
		check_ladder[2][3] = 155;
		check_ladder[3][0] = 210;
		check_ladder[3][1] = 395;
		check_ladder[3][2] = 270;
		check_ladder[3][3] = 215;
		check_ladder[4][0] = 510;
		check_ladder[4][1] = 455;
		check_ladder[4][2] = 270;
		check_ladder[4][3] = 35;

		check_snake[0][0] = 390;
		check_snake[0][1] = 395;
		check_snake[0][2] = 450;
		check_snake[0][3] = 515;
		check_snake[1][0] = 330;
		check_snake[1][1] = 275;
		check_snake[1][2] = 210;
		check_snake[1][3] = 575;
		check_snake[2][0] = 510;
		check_snake[2][1] = 155;
		check_snake[2][2] = 570;
		check_snake[2][3] = 515;
		check_snake[3][0] = 210;
		check_snake[3][1] = 35;
		check_snake[3][2] = 270;
		check_snake[3][3] = 155;
		check_snake[4][0] = 90;
		check_snake[4][1] = 35;
		check_snake[4][2] = 210;
		check_snake[4][3] = 335;
	}

	public void check_place()
	{
		int flag=0;
		for(int i=0;i<5;i++)
		{
			if(check_snake[i][0] == x && check_snake[i][1] == y)
			{
				flag = 1;
				x = check_snake[i][2];
				y = check_snake[i][3];
				repaint();
				break;
			}
		}
		if(flag == 0)
		{
			for(int i=0;i<5;i++)
		{
			if(check_ladder[i][0] == x && check_ladder[i][1] == y)
			{
				flag = 1;
				x = check_ladder[i][2];
				y = check_ladder[i][3];
				repaint();
				break;
			}
		}

		}
	}

	public void player(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillOval(x-10, y-10, 20, 20);
	}

	public void roll()
	{
		num = (int)(Math.random() * 329)%10;

		if(num > 6 || num == 0)
		{
			roll();
		}
	}

	public void get_index()
	{
		for(int i=0;i<100;i++)
		{
			if(cord[i][0] == x && cord[i][1] == y)
			{
				index = i;
			}
		}
	}

	public void set_index()
	{
		x=cord[index][0];
		y=cord[index][1];
		repaint();
	}

	public void move()
	{
		switch(num)
		{
			case 1 : get_index();
					 if(index<100)
					 {
						 index++;
					 }
					 set_index();
					break;
			case 2 : get_index();
					 if(index < 98)
					 {
						index+=2;
					 }
					 set_index();
					 break;
			case 3 : get_index();
					 if(index < 97)
					 {
						index+=3;
					 }
					 set_index();
					 break;
			 case 4 : get_index();
					 if(index < 96)
					 {
						index+=4;
					 }
					 set_index();
					 break;
			case 5 : get_index();
					 if(index < 95)
					 {
						index+=5;
					 }
					 set_index();
					 break;
			case 6 : get_index();
					 if(index < 94)
					 {
						index+=6;
					 }
					 set_index();
					 break;
			default: System.out.println("Something is wrong");

		}
		check_place();
		repaint();
	}


	public void board(Graphics g)
	{
		int x, y; 
                i=0;
		for (int row = 0; row < N; row++) { 

			for (int col = 0; col < N; col++) { 
				x = row * 60; 
				y = col * 60; 
				if ((row % 2 == 0) == (col % 2 == 0)) 
					g.setColor(Color.GRAY); 
				else
					g.setColor(Color.WHITE); 
				g.fillRect(x, y, 60, 60); 
			}
			g.setColor(Color.BLACK);
			g.drawLine(600, 0, 600, 600);
		}
                      for (int col = 0; col < N; col++) { 

			for (int row = 0; row < N; row++) {
                               x = row * 60; 
				y = col * 60;

                               g.drawString(numbers[i],x,y+60);
                                i++; 
                      }}

		Graphics2D g2 = (Graphics2D) g;
           g2.setStroke(new BasicStroke(5));  
           //Snakes
          g.setColor(Color.red);
          g.drawLine(90,30,210,330);
          g.drawLine(210,30,270,150);
          g.drawLine(510,150,570,500);
          g.drawLine(330,270,210,570);
          g.drawLine(390,390,450,510);
          //ladders
          g.setColor(Color.green);
          g.drawLine(150,570,30,330);//ladder 3
          g.drawLine(160,570,40,330);
          g.drawLine(149,560,153,550);
          g.drawLine(120,480,110,490);
          g.drawLine(75,420,80,415);
          g.drawLine(59,360,54,365);

          g.drawLine(330,450,390,210);
          g.drawLine(340,450,400,210);
          //g.drawLine(315,415,320,410);

          g.drawLine(210,390,270,210);
          g.drawLine(220,390,280,210);

          g.drawLine(30,270,90,150);
          g.drawLine(40,270,100,150);

          g.drawLine(510,450,270,30);
          g.drawLine(520,450,280,30);  

          g.drawLine(35,265,40,265);
          g.drawLine(75,180,80,180);
          g.drawLine(290,60,295,60);
          g.drawLine(360,180,365,180);

          g.drawLine(240,300,245,300);
g.drawLine(225,360,230,360);
g.drawLine(330,440,335,445);
g.drawLine(370,300,375,300);
	}


	public void paint(Graphics g) 
	{ 

		this.board(g);
		this.player(g);

		if(clicked == 1)
		{
			clicked =0;
			this.roll();
			this.move();
		}
	} 

	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(10);
				repaint();
			}
			catch(Exception e){}
		}
	}


}