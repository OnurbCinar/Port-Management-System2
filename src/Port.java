import java.util.ArrayList;

public class Port implements IPort {
static int idstat=0;
  private   int id;
    private double X ;
     private double Y;
     private ArrayList<Containers> containers;

      private ArrayList<Ship> history ;
    private ArrayList<Ship> current ;
public Port(double x, double y){
    this.id = idstat;
    this.X= x;
    this.Y = y;
idstat++;
containers = new ArrayList<>();

history = new ArrayList<>();
current = new ArrayList<>();

}
public void RemoveShip(Ship ship){
    this.current.remove(ship);
}
    public ArrayList<Ship> getCurrent() {
        return current;
    }
    public boolean ishech(Containers cont){
    return this.containers.contains(cont);

    }

    @Override
    public void incomingShip(Ship s) {
    this.current.add(s);


    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    @Override
    public void outgoingShip(Ship s) {
    this.history.add(s);

    }
    public double dinstancecalculator(Port another){

    double distancex = Math.abs(this.X - another.X);
    double distancey =  Math.abs(this.Y - another.Y);
    double distance = Math.sqrt((distancex * distancex) + (distancey * distancey));

    return distance;
    }
    public void SetContainer(Containers cont){
    this.containers.add(cont);
    }
    public void SetShip(Ship sip){
    this.current.add(sip);

    }

    public ArrayList<Containers> getContainers() {
        return containers;
    }
    public void Removecontainer ( Containers cont) {
    this.containers.remove(cont);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return STR."Portid=\{id}, X=\{X}, Y=\{Y}, containers=\{containers}\{current}"
                ;
    }
}
