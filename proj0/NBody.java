import java.util.List;
import java.util.ArrayList;
public class NBody{
	public static double readRadius(String fileName){
		 In in = new In(fileName);
		int N = in.readInt();
		double radius = in.readDouble();
		 return radius;
	}


	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int N = in.readInt();
		double radius = in.readDouble();
		int i = 0;
		Planet[] planetsInf = new Planet[N];
		while(i< N){	
					double xCoor = in.readDouble();
					double yCoor = in.readDouble();
				 	double xCompo = in.readDouble();
					double yCompo = in.readDouble();	
					double mass = in.readDouble();
					String name = in.readString();
					planetsInf[i] = new Planet(xCoor, yCoor, xCompo, yCompo, mass, name);//this is the double array 
					i++;
				}
		return planetsInf;
			
		
	} 
	public static void main(String[] args) {
		double T;
		double dt;
		String filename;
		T = Double.parseDouble(args[0]);		
		dt = Double.parseDouble(args[1]);
		filename = args[2];
		double radius = readRadius(filename); //if the method doesn't work, add 'NBody.' on it.
		Planet[] planetsInf = readPlanets(filename);
		int N = planetsInf.length;
		
	//set up background
		String img = "images/starfield.jpg";
		StdDraw.setScale(-radius,radius);
		StdDraw.picture(0,0, img,2*radius,2*radius);
		for(int i = 0; i < N; i++){
			planetsInf[i].draw();
		}

		StdDraw.enableDoubleBuffering();
		

	//create time variable and set it to 0
		double t = 0;
		while(t < T){

	//create an xForce and yForce array
			double[] xForces = new double[N];
			double[] yForces = new double[N]; 
	//Calculate the net x and y forces for each planet, stroing these in the xForce and yForces arrays
			for(int i = 0; i < N; i++){
			xForces[i] = planetsInf[i].calcNetForceExertedByX(planetsInf);
			yForces[i] = planetsInf[i].calcNetForceExertedByY(planetsInf);
		}

	//Call update on each of the planets. This will update each planet
		for(int i = 0; i < N; i++){
			planetsInf[i].update(dt, xForces[i],yForces[i]);
		}

	//Draw the background image
		StdDraw.picture(0,0,img,2*radius,2*radius);


	//Draw all of the planets.
		for (int i = 0; i < N ; i ++ ) {
			planetsInf[i].draw();		
		}
		StdDraw.show();
		StdDraw.pause(10);
		t = t + dt;

	}
	
	}

	
}
