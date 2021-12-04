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

        infect();

        test();

        System.out.println(numTests);
        


      

    }
    public static void infect() {
        //infect population with disease with 2% infection rate
        listPeople.giveDisease(infectionRate);
        for (int i = 0; i < listPeople.size(); i++) {
            if (peopleList.get(i).getIsSick() == 1) {
                System.out.println("Person " + i + " has been infected");
            }
        }
    }

    public static void test() {
        /*
        testing group size at a time (8) so split up list into groups of 8 
        if infection is found
            split into two lists
            if one group shows infection and other does not
                everyone in infect group tested individually, other group clear
            else both groups show infection
                test all members of both groups
        */

    
        List<List<Person>> listOfLists = splitInGroups(listPeople.getList(), groupSize);
        //iterate through each list of 8 
        for (List<Person> list: listOfLists) {
            numTests++;
            //then iterate through each person in list
            for (Person person: list) {
                //test if anyone of the 8 are sick
                if (person.getIsSick() == 1) {
                    //need to split this list into two groups of 4 here
                    List<List<Person>> splitList = new ArrayList<>();
                    splitList = splitInTwo(list);

                    //iterate through new list of lists with the new groups of 4
                    //increment test
                    for (int i = 0; i < splitList.size(); i++) {
                        numTests++;
                    }
                    //now need to iterate through the two lists of 4
                    for (List<Person> splitGroup: splitList) {
                        //iterate through the individual people in the lists of 4
                        for (Person personInSplitGroup: splitGroup) {
                            //if anyone is sick, need to test every person in each of the two groups of 4
                            if (personInSplitGroup.getIsSick() == 1) {
                                for (int j = 0; j < splitGroup.size(); j++) {
                                    numTests++;
                                }//for
                            }//if
                        }//for
                    }//for

                }//if
            }//for
        }//for
    }

    //splits original list up into groups of 8
    //returns a list of lists (of 8 each)
    public static <T> List<List<T>> splitInGroups(List<T> list, int groupSize) {
        List<List<T>> listOfLists = new ArrayList<List<T>>();
        for (int i = 0; i < list.size(); i += groupSize) {
            //adds sublist of original list from i to groupSize
            //i + groupSize exceeds the list size for the last list, so the min function is used for that case
            listOfLists.add(new ArrayList<T>(list.subList(i, Math.min(list.size(), i + groupSize))));
        }
        return listOfLists;
    }

    //split list of 8 into two lists of 4
    //also returns list of list (the two lists of 4)
    public static <T> List<List<T>> splitInTwo(List<T> list) {
        List<List<T>> listsOfFour = new ArrayList<List<T>>();

        int size = list.size();
    
        List<T> first = new ArrayList<>(list.subList(0, (size + 1) / 2));
        List<T> second = new ArrayList<>(list.subList((size + 1) / 2, size));

        listsOfFour.add(first);
        listsOfFour.add(second);

        return listsOfFour;


    }


    
}
