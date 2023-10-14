public class DriverClass {
    public static void main(String[] args) {
        boolean on = true;
        int button = 1;
        Dropper[] droppers = new Dropper[2];
        
        droppers[0] = new IronDropper(2000);
        droppers[1] = new GoldDropper(1000);

        droppers[0].startDropping();
        
        //droppers[1].startDropping();

        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        droppers[0].stopDropping();
        // droppers[1].stopDropping();
        
        

        // droppers[0].getTotalOreDropped();
        // droppers[1].getTotalOreDropped();

        System.out.println("Done");

        

        

      

        
        
        
    }

}
