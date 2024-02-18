public class LiquidContainer extends HeavyContainer {
    char type;

   public LiquidContainer(int portID, int weight,int speacialid, char a) {
        super(portID, weight,speacialid);
        this.type=type;
        consumption();
    }

    @Override
    void consumption() {
        this.cumsumption = this.getWeight() * 4.00;

    }
    @Override
    public String toString() {
        return "LiquadContainer=" + getID() ;
    }
}
