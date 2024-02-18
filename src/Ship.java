import java.lang.ref.Reference;
import java.util.ArrayList;

public class Ship implements IShip{
static int shipidstat=0;
    private int specialid;
    private int currentweightsum;
    private int heavycontainer, sumofcontainer,refricontainer,liquidcontainer;
   private Port currentPort;
   private ArrayList<Containers> containers;
   private int Portİd, totalWeightCapacity , maxNumberOfAllContainers,maxNumberOfHeavyContainers;
   private int maxNumberOfRefrigeratedContainers,maxNumberOfLiquidContainers;
    private double fuelConsumptionPerKM;
    private double fuelofship;

    public Ship(int İD,Port p , int totalWeightCapacity, int
             maxNumberOfAllContainers, int maxNumberOfHeavyContainers, int
                         maxNumberOfRefrigeratedContainers, int
                         maxNumberOfLiquidContainers, double fuelConsumptionPerKM){
        specialid = shipidstat;
        currentPort = p ;
Portİd = İD;
        this.totalWeightCapacity = totalWeightCapacity;
        this.maxNumberOfAllContainers= maxNumberOfAllContainers;
        this.maxNumberOfRefrigeratedContainers = maxNumberOfRefrigeratedContainers;
        this.maxNumberOfHeavyContainers = maxNumberOfHeavyContainers;
        this.maxNumberOfLiquidContainers = maxNumberOfLiquidContainers;
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
shipidstat++;
containers = new ArrayList<>();
heavycontainer = 0 ;
liquidcontainer = 0 ;
sumofcontainer =0 ;
refricontainer = 0 ;

    }
    public ArrayList<Containers> getCurrentContainers(){

        return containers;
    }

    @Override
    public boolean sailTo(Port p) {
        if (this.currentPort == p) {
            return false;
        } else {
            double distancefor = this.currentPort.dinstancecalculator(p);
            double needfuel = distancefor * this.fuelConsumptionPerKM;
            if (this.fuelofship >= needfuel) {

                this.fuelofship = this.fuelofship - needfuel;
                return true;
            } else {
                return false;
            }}
    }
    @Override
    public void reFuel(double newFuel) {
this.fuelofship = newFuel + this.fuelofship;
    }

    @Override
    public boolean unLoad(Containers cont) {
      if ( this.Portİd == cont.getPorts() ) {
          if ( this.containers.contains(cont)){

              return true;
          }
          else{ return false; }
      }else{ return false; }


    }

    @Override
    public boolean load(Containers cont) {
        if(this.containers.contains(cont)){
            System.out.println("alalala");
            return false;

        }
        if(this.Portİd != cont.getPorts()){
            return false;
        }
        int tempo = 0 ;
        if (this.Portİd == cont.getPorts() ) {
      if(cont.getClass().equals(HeavyContainer.class)){
if(maxNumberOfHeavyContainers == heavycontainer){
    return false;}
if(totalWeightCapacity <= (currentweightsum+   cont.getWeight()     )){
    return false;
}
else {
    sumofcontainer++;
    heavycontainer++;
    currentweightsum = currentweightsum + cont.getWeight()  ;
    return true;
}
      }
      else{
          if (cont.getClass().equals(BasicContainer.class)){
              if(maxNumberOfAllContainers == sumofcontainer){
                  return false;
              }
              if(totalWeightCapacity <= (currentweightsum+ cont.getWeight()    )){
                  return false;
              }
              else {
                  sumofcontainer++;
                  currentweightsum = currentweightsum + cont.getWeight();
                  return true;
              }

           }else{ if(cont.getClass().equals(RefrigeratedContainer.class)) {
              if(maxNumberOfHeavyContainers == heavycontainer){
                  return false;}
              if(totalWeightCapacity <= (currentweightsum+ cont.getWeight()   )){
                  return false;
              }
              if(maxNumberOfRefrigeratedContainers == ( refricontainer )) {
                  return false;
              }
              else{
                  sumofcontainer++;
                  currentweightsum = currentweightsum + cont.getWeight();
                  refricontainer++;
                  heavycontainer++;
return true;}
           }else{
              if (cont.getClass().equals(LiquidContainer.class)){
                  if(maxNumberOfHeavyContainers == heavycontainer){
                      return false;}
                  if(totalWeightCapacity <= (currentweightsum+ cont.getWeight()  )){
                      return false;
                  }
                  if(maxNumberOfLiquidContainers == ( liquidcontainer )) {
                      return false;
                  }
                  else{
                      sumofcontainer++;
                      currentweightsum = currentweightsum + cont.getWeight();
                      liquidcontainer++;
                      heavycontainer++;
                      return true;}
              }
          }
          }
      }
      return false; }
        return false;  }
    public void setContainers(Containers cont) {
        this.containers.add(cont);
    }
    public void RemoveContainer(Containers cont){

        this.containers.remove(cont);

    }
    public int CurrentPortId(){
        return Portİd;
    }

    public Port getCurrentPort() {
        return currentPort;
    }
    public void changefuelcomsumption(Containers cont){
    }
    public void dischangefuelcomsumption(Containers cont){
        this.fuelConsumptionPerKM = this.fuelConsumptionPerKM  - cont.cumsumption;
    }
    public void setport(Port a){
        this.currentPort = a;
        this.Portİd = a.getId();
    }
    public void setFuelofship(double distance){
        this.fuelofship =  fuelofship - (this.fuelConsumptionPerKM * distance);

    }

    public ArrayList<Containers> getContainers() {
        return containers;
    }

    public double getFuelofship() {
        return fuelofship;
    }

    public double getFuelConsumptionPerKM() {
        return fuelConsumptionPerKM;
    }
    public void containersidchanger(){
        int newport = this.Portİd;
        for( int i = 0 ; i<this.containers.size() ;i++){
this.containers.get(i).setPorts(newport);

        }
    }

    @Override
    public String toString() {

        return
                "\nShip id=" + specialid +
                ", containers=" + containers +
                ", fuelofship=" + fuelofship + ""
                ;


    }
}
