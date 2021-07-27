public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public double g = 6.67e-11;
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
	  xxPos = p.xxPos;
	  yyPos = p.yyPos;
	  xxVel = p.xxVel;
	  yyVel = p.yyVel;
	  mass = p.mass;
	  imgFileName = p.imgFileName;
	}
	
	public double calcDistance(Planet p){

		double dx;
		double dy;
		double rsq;
		dx = xxPos - p.xxPos;
		dy = yyPos - p.yyPos;
		rsq = Math.pow(dx,2)+ Math.pow(dy,2);
		return Math.sqrt(rsq);
	}
	public double calcForceExertedBy(Planet p){

		double force;
		
		force = (g * this.mass * p.mass) / (this.calcDistance(p)*this.calcDistance(p));
		return force;
	} 
	public double calcForceExertedByX(Planet p){
		double forcex; 
		forcex = (calcForceExertedBy(p)* (p.xxPos - xxPos))/calcDistance(p);
		return forcex;
	}   
	public double calcForceExertedByY(Planet p){
		double forcey;
		forcey = (calcForceExertedBy(p)* (p.yyPos - yyPos))/calcDistance(p);
		return forcey;
	}
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double netForceX = 0;
		for(int i = 0; i < allPlanets.length;i++){
			if (this.equals(allPlanets[i])) {
				continue;

			}
			netForceX += calcForceExertedByX(allPlanets[i]);
		}
		return netForceX;
	}
	public double calcNetForceExertedByY(Planet[] allPlanets){
		double netForceY = 0;
		for(int i = 0; i < allPlanets.length;i++){
			if (this.equals(allPlanets[i])) {
				continue;
			}
			netForceY += calcForceExertedByY(allPlanets[i]);

		}
		return netForceY;
	}
	public void update(double dt, double fX, double fY){
	/**	double vNewX;
		double vNewY;
		double pNewX;
		double pNewY;
		double alphaNetX;
		double alphaNetY;

		alphaNetX = fX/this.mass;
		alphaNetY = fY/this.mass;
		vNewX = this.xxVel + dt*alphaNetX;
		vNewY = this.yyVel + dt*alphaNetY;
		pNewX = this.xxPos + dt*vNewX;
		pNewY = this.yyPos + dt*vNewY;

*/
		double aX = fX / this.mass;
        double aY = fY / this.mass;

        this.xxVel = this.xxVel + dt * aX;
        this.yyVel = this.yyVel + dt * aY;

        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
	
	}
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
	}	
}
