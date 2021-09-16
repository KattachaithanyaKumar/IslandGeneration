int size = 10;
int wh = 90;
int[][] grid = new int[wh][wh];
int xx = 10;
int yy = 10;
int w = wh;
int h = wh;
int px = xx;//floor(random(size));
int py = yy;//floor(random(size));
int ox = px;
int oy = py;
/*
0 - water
1 - grass
2 - sand
*/

void setup()  {
  size(920, 920);
  //fullScreen();
  background(0);
  for (int i = 0; i < wh; i++)  {
    for (int j = 0; j < wh; j++)  {
      //grid[i][j] = floor(random(3));
      grid[i][j] = 0;
    }
  }
  //grid[xx][yy] = 1;
}

void draw()  {

  dogen();
  design();
  for (int i = 0; i < wh; i++)  {
    for (int j = 0; j < wh; j++)  {
      int s = size;
        
      if (grid[i][j] == 0)  {
        //water
        rect(xx + (i * s), yy + (j * s), s, s);
        fill(0,0,255);
      }else if (grid[i][j] == 1)  {
        //grass
        rect(xx + (i * s), yy + (j * s), s, s);
        fill(0,255,0);
      }else if (grid[i][j] == 2)  {
        //sand
        rect(xx + (i * s), yy + (j * s), s, s);
        fill(255,255,0);
      }
      
    }
  }
}

void ex(int sx, int sy)  {
  int radius = floor(random(10));
  int top =    sy - radius,
    bottom = sy + radius;

    for (int y = top; y <= bottom; y++) {
      int   dy  = y - sy;
      float dx  = sqrt(radius*radius - dy*dy);
      int left  = ceil(sx - dx),
          right = floor(sx + dx);
      for (int x = left; x <= right; x++) {
        // draw tile (x, y)   
       grid[x][y] = 1;
       System.out.println("x: " + x + " y: " + y);
     }
  }
  noLoop();
}

void dogen()  {
  for (int i = 0; i < 50; i++)  {
    int _x = floor(random(wh));
    int _y = floor(random(wh));
    if ((_x < 80)&&(_x > 10)&&(_y > 10)&&(_y < 80))  {
      grid[_x][_y] = 1;
      ex(_x, _y);
    }
  }
  noLoop();
}

void design()  {
  for (int i = 5; i < 85; i++)  {
    for (int j = 5; j < 85; j++)  {
      if ((grid[i][j] == 1)&&(grid[i+1][j] == 0))  {
        grid[i][j] = 2;
      }
      if ((grid[i][j] == 1)&&(grid[i-1][j] == 0))  {
        grid[i][j] = 2;
      }
      if ((grid[i][j] == 1)&&(grid[i][j+1] == 0))  {
        grid[i][j] = 2;
      }
      if ((grid[i][j] == 1)&&(grid[i][j-1] == 0))  {
        grid[i][j] = 2;
      }
    }
  }
}
