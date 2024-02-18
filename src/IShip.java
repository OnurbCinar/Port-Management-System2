public interface IShip {
    boolean sailTo(Port p);
    void reFuel(double newFuel);
    boolean unLoad(Containers cont);
    boolean load(Containers cont);
}
