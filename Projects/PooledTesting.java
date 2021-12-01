import java.util.*;

public class PooledTesting {
    
    public static int infectionRate = 2; // represents 2% infection rate
    public static int groupSize = 8;
    public static int numTests = 0;
    public static int numPeople = 1000;

    //need to first create the list of 1000 people, use that to create the actual list of people
    public static List<Person> peopleList = new ArrayList<>(numPeople);
    public static ListPeople listPeople = new ListPeople(peopleList);
    public static void main(String[] args) {

        listPeople.addPeople(numPeople);

        listPeople.giveDisease(infectionRate);
        for (int i = 0; i < listPeople.size(); i++) {
            if (peopleList.get(i).isSick == 1) {
                System.out.println("Person " + i + " has been infected");
            }

        }
        

      

    }


    
}
