import java.beans.beancontext.BeanContextChild;
import java.io.File;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
static int shipid=0;
static int i = -1;
static int containerid=0;
    public static void main(String[] args) {
        Scanner abc = new Scanner(System.in);
        System.out.println("Enter file name");
        String a = abc.next() + ".txt";
        ArrayList<Port> Porttempo = new ArrayList<>();
        ArrayList<Ship> Shiptempo = new ArrayList<>();
        ArrayList<Containers> Containerstempo = new ArrayList<>();
        int counterforport;
        String filename = "output_" + a.substring(a.length()-5);

        Scanner reader = null;
        PrintWriter outputStream = null;
        try{ outputStream = new PrintWriter(filename);
            reader= new Scanner(new File(a));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        String g ;
        g =  reader.nextLine();
        while(reader.hasNextLine()){
            g =  reader.nextLine(); //Second line
            String[] temp = g.split(" ");
            switch (temp[0]){
                case "1" :
                    int weight = Integer.parseInt(temp[2]);
                    int portid = Integer.parseInt(temp[1]);
                   if( temp.length ==4 ) {
                       if(temp[3].equals("L")){
Containerstempo.add(new LiquidContainer(portid,weight,containerid,'L'));

Porttempo.get(portid).SetContainer(Containerstempo.get(containerid));


                       }else{Containerstempo.add(new RefrigeratedContainer(portid,weight,containerid,'R'));

                           Porttempo.get(portid).SetContainer(Containerstempo.get(containerid));


                       }
                   }else{ if ( weight>=3000) {
                       Containerstempo.add(new HeavyContainer(portid,weight,containerid));
                       Porttempo.get(portid).SetContainer(Containerstempo.get(containerid));

                   }else {  Containerstempo.add(new BasicContainer(portid,weight,containerid));
                       Porttempo.get(portid).SetContainer(Containerstempo.get(containerid));
                   }

                   }


containerid++;
                    break;
                case "2" :
                    int tempportid  = Integer.parseInt(temp[1]);
                    int maxwei,maxcontan,maxheavy,maxrefri,maxliq;
                    double consump = Double.parseDouble(temp[7]);
                    maxwei = Integer.parseInt(temp[2]);
                    maxcontan = Integer.parseInt(temp[3]);
                    maxheavy = Integer.parseInt(temp[4]);
                    maxrefri = Integer.parseInt(temp[5]);
                    maxliq= Integer.parseInt(temp[6]);
                    Shiptempo.add( new Ship( tempportid,Porttempo.get(tempportid)
                            ,maxwei,maxcontan,maxheavy,maxrefri,maxliq,consump));
Porttempo.get(tempportid).SetShip(Shiptempo.get(shipid));

shipid++;


                    break;
                case "3" :
                    double x = Double.parseDouble(temp[1]);
                    double y= Double.parseDouble(temp[2]);

Porttempo.add(new Port(x,y));

                    break;
                case "4" :
                    int shipid = Integer.parseInt(temp[1]);
                    int containersid = Integer.parseInt(temp[2]);
               if(   Porttempo.get(Shiptempo.get(shipid).CurrentPortId()).ishech(Containerstempo.get(containersid)) ) {
                    if(Shiptempo.get(shipid).load(Containerstempo.get(containersid))){
Shiptempo.get(shipid).setContainers(Containerstempo.get(containersid));
Shiptempo.get(shipid).changefuelcomsumption(Containerstempo.get(containersid));
                        int ax =Shiptempo.get(shipid).CurrentPortId();
                        Porttempo.get(ax).Removecontainer(Containerstempo.get(containersid));

                    }}

                    break;
                case "5" :


                    int unloadforship = Integer.parseInt(temp[1]);
                    int unloadforcontainer = Integer.parseInt(temp[2]);
                    boolean temporary = Shiptempo.get(unloadforship).unLoad(Containerstempo.get(unloadforcontainer));

                    if( temporary) {


                        Shiptempo.get(unloadforship).dischangefuelcomsumption(Containerstempo.get(unloadforcontainer));
                        Porttempo.get(Containerstempo.get(unloadforcontainer).getPorts()).SetContainer(Containerstempo.get(unloadforcontainer));
                        Shiptempo.get(unloadforship).RemoveContainer(Containerstempo.get(unloadforcontainer));

                    }




                    break;
                case "6" :int sailforship = Integer.parseInt(temp[1]);
                    int sailforport = Integer.parseInt(temp[2]);
if(Shiptempo.get(sailforship).sailTo(Porttempo.get(sailforport))){

    Porttempo.get(sailforport).SetShip(Shiptempo.get(sailforship)); // yeni porta shipi kayıt et
    Porttempo.get(Shiptempo.get(sailforship).getCurrentPort().getId()).RemoveShip(Shiptempo.get(sailforship)); // eski porttan shipi sil
    Shiptempo.get(sailforship).setport(Porttempo.get(sailforport)); // geminin portunu yenile
    Shiptempo.get(sailforship).containersidchanger();

}

                    break;
                case "7" :
                    int shipidforfuel = Integer.parseInt(temp[1]);
                    double fuelamount = Double.parseDouble(temp[2]);
Shiptempo.get(shipidforfuel).reFuel(fuelamount);

                    break;
            }
        }
      for(Port i : Porttempo){
          System.out.println(i.toString().replace("[", "").replace("]", ""));
          outputStream.println(i.toString().replace("[", "").replace("]", " "));


      }
        outputStream.close ();
      reader.close();

    }
}



