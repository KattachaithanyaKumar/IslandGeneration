/* The code doesnot work yet */
int size = 30;
int[][] grid = new int[size][size];
int x = 10;
int y = 10;
int xx = size / 2;
int yy = size / 2;
int cdir = floor(random(3));
int odds = 1;
int cx = xx;
int cy = yy;
int wi = size / 2;
int hi = size / 2;
int count = 0;
int xdir = 0;
int ydir = 0;
/*
0 - water
1 - grass
2 - sand
*/

void setup()  {
  size(920, 920);
  //fullScreen();
  background(0);
  for (int i = 0; i < size; i++)  {
    for (int j = 0; j < size; j++)  {
      //grid[i][j] = floor(random(3));
      grid[i][j] = 0;
    }
  }
  grid[xx][yy] = 1;
}

int r = 0;

void draw()  {
  
  generate();
  
  for (int i = 0; i < size; i++)  {
    for (int j = 0; j < size; j++)  {
      int s = size;
        
      if (grid[i][j] == 0)  {
        //water
        rect(x + (i * s), y + (j * s), s, s);
        fill(0,0,255);
      }else if (grid[i][j] == 1)  {
        //grass
        rect(x + (i * s), y + (j * s), s, s);
        fill(0,255,0);
      }else if (grid[i][j] == 2)  {
        //sand
        rect(x + (i * s), y + (j * s), s, s);
        fill(255,255,0);
      }
      
    }
  }
}


void generate()  {
  for (int i = 0; i < 1000; i++)  {
  grid[cx][cy] = 1;
  int o = floor(random(odds));  
  if (o == odds)  {
  cdir = floor(random(3));
  }
  if (cdir == 0)  {
    xdir = 1;
    ydir = 0;
  }else if (cdir == 1)  {
    xdir = 0;
    ydir = -1;
  }else if (cdir == 2)  {
    xdir = -1;
    ydir = 0;
  }else if (cdir == 3)  {
    xdir = 0;
    ydir = 1;
  }
    
  cx += xdir;
  cy += ydir;
  cx = clamp(cx, 1, wi-1);
  cy = clamp(cy, 1, hi-1);
  }
  noLoop();
}

int clamp(int a, int low, int high)  {
  if (a <= low)  {
    a = low;
  }
  if (a >= high)  {
    a = high;
  }
  return a;
}
