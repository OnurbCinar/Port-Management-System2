import java.util.WeakHashMap;

public class Containers {
    static int ContainerId = 0;
   private int ID;
    private  int weight;
    private  int ports;
   protected double cumsumption;
    public Containers(int portId,int weight,int specialid){
        ports= portId;

        this.weight = weight;
        this.ID = specialid;

    }

    public int getID() {
        return ID;
    }

    boolean equals(Containers other){
        if(this.weight == other.weight && this.ID==other.ID ){

            return true;
        }
        return false;
    }

    public int getWeight() {
        return weight;
    }

    public int getPorts() {
        return ports;
    }

    public double getConsumption() {
        return cumsumption;
    }



    public void setPorts(int ports) {
        this.ports = ports;
    }

    @Override
    public String toString() {
        return
                "ID=" + ID +""
                ;
    }
}
