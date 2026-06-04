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
            case 1:
                controller = new AddIncomeController();
                break;
            case 2:
                controller = new AddOutcomeController();
                break;
            case 3:
                controller = new ShowAllController();
                break;
            case 4:
                controller = new ShowByMonthController();
                break;
        }
        return controller;
    }
}
