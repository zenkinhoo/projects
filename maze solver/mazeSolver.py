import turtle
import sys
import time

screen = turtle.Screen()
screen.bgcolor("black")
screen.setup(1300,700)
#t=turtle.Turtle()

#klasa za beli kvadratic lavirinta(zidovi)
class Maze(turtle.Turtle):
	def __init__(self):
		turtle.Turtle.__init__(self)
		self.shape("square")
		self.color("white")
		self.penup()
		self.speed(0)


#klasa za zeleni kvadratic lavirinta(izlaz)
class End(turtle.Turtle):
    def __init__(self):
        turtle.Turtle.__init__(self)
        self.shape("square")
        self.color("green")
        self.penup()
        self.speed(0)

#klasa za sprite
class sprite(turtle.Turtle):
    def __init__(self):
        turtle.Turtle.__init__(self)
        self.shape("turtle")
        self.color("red")
        self.setheading(270)  # point turtle to point down
        self.penup()
        self.speed(0)



    def moveDown(self):
    	if(self.heading() == 270):                 #ako je okrenuta ka dole (moze da se krece nadole)
    		x_cord = round(sprite.xcor(),0)        #uzima trenutnu x koordinatu
    		y_cord = round(sprite.ycor(),0)        #uzima trenutnu y koordinatu

    		if(x_cord,y_cord) in finish:           #ako se trenutne koordinate nalaze gde i zelena program je zavrsen
    			print("Program je zavrsen")
    			endProgram()

    		if(x_cord+24,y_cord) in walls:         #levo je zid
    			if(x_cord,y_cord-24) not in walls: #napred je prazno
    				self.forward(24)
    			else:
    				self.right(90)

    		else:
    			self.left(90)
    			self.forward(24)

    def moveUp(self):
    	if(self.heading() == 90):
    		x_cord = round(sprite.xcor(),0)
    		y_cord = round(sprite.ycor(),0)

    		if(x_cord,y_cord) in finish:
    			print("Program je zavrsen")
    			endProgram()

    		if(x_cord-24,y_cord) in walls:
    			if(x_cord,y_cord+24) not in walls:
    				self.forward(24)
    			else:
    				self.right(90)

    		else:
    			self.left(90)
    			self.forward(24)

    def moveRight(self):
    	if(self.heading() == 180):
    		x_cord = round(sprite.xcor(),0)
    		y_cord = round(sprite.ycor(),0)

    		if(x_cord,y_cord) in finish:
    			print("Program je zavrsen")
    			endProgram()

    		if(x_cord,y_cord-24) in walls:
    			if(x_cord-24,y_cord) not in walls:
    				self.forward(24)
    			else:
    				self.right(90)

    		else:
    			self.left(90)
    			self.forward(24)

    def moveLeft(self):
    	if(self.heading() == 0):
    		x_cord = round(sprite.xcor(),0)
    		y_cord = round(sprite.ycor(),0)

    		if(x_cord,y_cord) in finish:
    			print("Program je zavrsen")
    			endProgram()

    		if(x_cord,y_cord+24) in walls:
    			if(x_cord+24,y_cord) not in walls:
    				self.forward(24)
    			else:
    				self.right(90)

    		else:
    			self.left(90)
    			self.forward(24)








def generateMaze(grid):
	for y in range(len(grid)):
		for x in range(len(grid[y])):
			character = grid[y][x]       #trenutna pozicija naseg karaktera
			screen_x= -588 + (x*24) 		 #krajnja leva pozicija plus trenutna x koordinata puta debljina kvadratica
			screen_y= 288 - (y*24)			#analogno gore


			if(character == "+"):                     #ako je karakter zid
				maze.goto(screen_x,screen_y)		  #pomeri na trenutnu poziciju
				maze.stamp()					      #stampaj
				walls.append((screen_x,screen_y))                    #dodaj u listu zidova

			if(character =="e"):                    #ako je karakter izlaz
				end.goto(screen_x,screen_y)          #pomeri na trenutnu poziciju
				end.stamp()                          #stampaj
				finish.append((screen_x,screen_y))                   

			if(character =="s"):
				sprite.goto(screen_x,screen_y)



def endProgram():
    screen.exitonclick()
    sys.exit()






####### glavni program #######

#ovako nam izgleda lavirint
grid = [
"++++++++++++++++++++++++++++++++++++++++++++++",
"+    s          +                            +",
"+  ++++++++++  +++++++++++++  +++++++  ++++  +",
"+           +                 +        +     +",
"+  +++++++  +++++++++++++  +++++++++++++++++++",
"+  +     +  +           +  +                 +",
"+  +  +  +  +  +  ++++  +  +  +++++++++++++  +",
"+  +  +  +  +  +  +     +  +  +  +        +  +",
"+  +  ++++  +  ++++++++++  +  +  ++++  +  +  +",
"+  +     +  +              +           +  +  +",
"+  ++++  +  ++++++++++++++++  +++++++++++++  +",
"+     +  +                    +              +",
"++++  +  ++++++++++++++++++++++  ++++++++++  +",
"+  +  +                    +     +     +  +  +",
"+  +  ++++  +++++++++++++  +  ++++  +  +  +  +",
"+  +  +     +     +     +  +  +     +     +  +",
"+  +  +  +++++++  ++++  +  +  +  ++++++++++  +",
"+                       +  +  +             +",
"++++  +  +  ++++++++++  +  +  +  +++++++++++++",
"+++++++++++++++++++++++e++++++++++++++++++++++",
]
#objektna reprezentacija oblika
maze = Maze()                
sprite = sprite()            
end = End()


walls = [] #lista zidova
finish = [] #kad naidje na zelenu

generateMaze(grid)

while True:
    sprite.moveRight()
    sprite.moveDown()
   
    sprite.moveLeft()
    sprite.moveUp()

    time.sleep(0.02)