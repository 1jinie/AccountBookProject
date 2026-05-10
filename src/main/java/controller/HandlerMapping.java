package controller;

public class HandlerMapping{
    private static HandlerMapping instance =  new HandlerMapping();

    public static HandlerMapping getInstance(){
        if(instance == null){
            instance = new HandlerMapping();
        }
        return instance;
    }

    public Controller getController(int no){
        Controller controller = null;
        switch (no){
            case 3:
                controller = new ShowAllController();
                break;
        }
        return controller;
    }
}
