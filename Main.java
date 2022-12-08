package com.company;

import java.lang.reflect.Array;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here

        System.out.println("Please enter the file name: ");
        //read the input file name.
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        //get the input name into the File
        File file = new File(input);

        //get the path using getCanonicalPath for the input file, so we can open the file
        //REMEMBER: the text file should be placed in the Stack_Queue file not in the src
        // replace or change the backslash into "\\" inside the string, so we can open the file.

        // The file needs to be saved in the file USPGraph, outside of the src
        String get_path = file.getCanonicalPath().replace("\\", "\\\\");
        File newFile = new File(get_path);
        Scanner readFile = new Scanner(newFile);

        //Scanner read = new Scanner(new File("C:\\Users\\maian\\Stack_Queue\\src\\text3.txt"));

        //integer for counting the line


        ArrayList<ArrayList<String>> mainID = new ArrayList<>();


        //create the boolean to stop the loop if HTML tag is false.
        boolean test = true;

        if (readFile.hasNext()) {
            System.out.println("Input file is read successfully. . .");
        }
        int countLine = 0;

        ArrayList<ArrayList<Integer>> graphStudent = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            graphStudent.add(new ArrayList<Integer>());
        }
        ArrayList<String> studentID = new ArrayList<>();
        ArrayList<String> studentIDmain = new ArrayList<>();
        ArrayList<String[]> studentRelation = new ArrayList<>();

        Map<String, String> mapID = new HashMap<>();

        Map<Integer, String> mapstudentId = new HashMap<>();

//


        ArrayList<ArrayList> friendCombine = new ArrayList<>();
        //String[] a = new String[10];
        String[] afterS = new String[0];
        ArrayList<String> friendGet = new ArrayList<>();
        int studentSchool = 0;
        while (readFile.hasNext() && test) {
            // for (int i = 0; i < data.length; i++) {
            String data = readFile.nextLine();
            afterS = data.split("\t");
            System.out.println(Arrays.toString(afterS));

            //this is the list of each line containing student infor/ only one student
            studentID = new ArrayList<>(Arrays.asList(afterS));


            studentIDmain.add(studentID.get(0));
//
            studentRelation.add(afterS);


//


            for (int t = 0; t < afterS.length; t++) {
                //System.out.println(t + " " + afterS[t]);
                //map contains the ID and name of student
                mapID.put(afterS[0], afterS[1]);
            }
            countLine++;
        }
//friend combine contains the friend inside arraylist with following the order of the array ID
        for (int i = 0; i < studentRelation.size(); i++) {
            System.out.println(Arrays.toString(studentRelation.get(i)));
            ArrayList<String> friendlist = new ArrayList<>();
            for (int j = 7; j < studentRelation.get(i).length; j++) {
                System.out.println("Friend" + studentRelation.get(i)[j]);
                friendlist.add(studentRelation.get(i)[j]);
            }

            friendCombine.add(friendlist);
        }


        for (int i = 0; i < studentIDmain.size(); i++) {
            mapstudentId.put(i, studentIDmain.get(i));
        }
        for (Entry m : mapstudentId.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
        int friendID = 0;
        System.out.println("BOMMMM!!!");
        for (int i = 0; i < friendCombine.size(); i++) {
            for (int j = 0; j < friendCombine.get(i).size(); j++) {

                for (Entry<Integer, String> entry : mapstudentId.entrySet()) {
                    if (Objects.equals(friendCombine.get(i).get(j), entry.getValue())) {
                        friendID = entry.getKey();
                        // System.out.println( " i:" + i  + " j: "+j + " friend " + friendID );
                        //addEdge (graphStudent, i, friendID);
                    }
//
//                }
                }
                System.out.println(" i:" + i + " j: " + j + " friend " + friendID);
                addEdge(graphStudent, i, friendID);
            }

        }

        //System.out.println("Orgional " + studentRelation);



        System.out.println("WHTTJSJFJS");

        printAdjacencyList(graphStudent);


//
        System.out.println(" friends" + friendCombine);
//

        System.out.println("Total number of vertices is " + countLine);
        countEdge(graphStudent);
        System.out.println("new list contains array list of all student" + studentIDmain);
//
        ArrayList<Integer> sameId= new ArrayList<>();
        for(int i= 0 ; i<studentRelation.size(); i++) {

            if (studentRelation.get(i)[3].contains("Engineering, Architecture and Technology")) {
                System.out.println("Student college" + i + studentRelation.get(i)[3]);
                sameId.add(i);
            }
        }

        System.out.println(sameId);
        CircleBFS circle = new CircleBFS(31);
        for (int k = 0; k < sameId.size(); k++) {
            //if (graphStudent.get(k).contains(sameId.get(k))) {
            //System.out.println(graphStudent.get(k));
            System.out.println(sameId.get(k));
                for (int i = 0; i < graphStudent.get(k).size(); i++) {

                    System.out.println("huhuhuhu" + graphStudent.get(k).get(i));
                    circle.addCircleEdge(sameId.get(k), graphStudent.get(k).get(i));
                }
        }
        System.out.println("beeeeleelldld");
        ArrayList<ArrayList<Integer>> fine = new ArrayList<>();
        for (int k = 0; k < sameId.size(); k++) {
            System.out.println("bfs dkfjklsdjfl");
            //System.out.println( circle.BFS(sameId.get(k)).getClass().getSimpleName());
            //circle.BFS(sameId.get(k));
            fine.add( circle.BFS(sameId.get(k)));
        }
        System.out.println(fine);
//        for(int i = 0; i < fine.size(); i++){
//            for(int y = 0; y < fine.get(i).size(); y++) {
//                System.out.println(fine.get(i).get(y));
////                if (!sameId.contains(fine.get(i).get(y))) {
////                    System.out.println("Different" + fine.get(i));
////                }
//            }
            //find the different from 2 array then list our the student who has least friend from school

        //}



        //menu
        boolean check = true;
        Scanner getInput = new Scanner(System.in);
        while (check) {
            System.out.println("1. Remove Friendship." + "\n " +
                    "2. Delete Account" + "\n " +
                    "3. Count Friends" + "\n " +
                    "4. Friend Circle" + "\n " +
                    "5. Closet Centrality " + "\n " +
                    "6. exit ");
            System.out.println("Please enter the number: ");
            //create cases
            int choice;
            choice = getInput.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Remove Friendship.");
                    System.out.println("Please end the name of the students");
                    System.out.println("First Student's name: ");
                    Scanner nameA = new Scanner(System.in);
                    String getnameA = nameA.nextLine();
                    System.out.println("Second Student's name: ");
                    String studentGetIDA = getIDKeyStudent(mapID, getnameA);
                    int studentGetIDnoA = getIDKey(mapstudentId, studentGetIDA);
                    Scanner nameB = new Scanner(System.in);
                    String getnameB = nameB.nextLine();
                    String studentGetIDB = getIDKeyStudent(mapID, getnameB);
                    int studentGetIDnoB = getIDKey(mapstudentId, studentGetIDA);

                    //delete the relation between 2 students
                    removeEdge(graphStudent, studentGetIDnoA,studentGetIDnoB);
                    int totalVertex = graphStudent.size();
                    System.out.println("Total number of students in the graph: " + totalVertex);
                    countEdge(graphStudent);
                case 2:
                    System.out.println("Remove Account");
                    System.out.println("Please end the name of the students");
                    Scanner nameDelete = new Scanner(System.in);
                    String getnameDel = nameDelete.nextLine();
                    String studentDelete = getIDKeyStudent(mapID, getnameDel);
                    int studentDeleteB = getIDKey(mapstudentId, studentDelete);

                    //remove the student and student's relation
                    removeVertex(graphStudent, studentDeleteB);
                case 3:
                    System.out.println("Count Friends");
                    System.out.println("Please enter student's name: ");
                    Scanner nameCount = new Scanner(System.in);
                    String getnameCount = nameCount.nextLine();
                    String studentCount = getIDKeyStudent(mapID, getnameCount);
                    int studentCountId = getIDKey(mapstudentId, studentCount);
                    //count friend of a student
                    countFriend(graphStudent, studentCountId);
                    break;
                case 4:
                    System.out.println("Friend Circle");
                    System.out.println("Please enter the student's college not include the College of/ School of: For example: Engineering, Architecture and Technology ");
                    Scanner nameCollege = new Scanner(System.in);
                    String getnameCollege = nameCollege.nextLine();
//                    ArrayList<Integer> sameId= new ArrayList<>();
//                    for(int i= 0 ; i<studentRelation.size(); i++) {
//
//                        if (studentRelation.get(i)[3].contains(getnameCollege)) {
//                            System.out.println("Student college" + i + studentRelation.get(i)[3]);
//                            sameId.add(i);
//                        }
//                    }
//                    System.out.println(sameId);
//                    for (int k = 0; k < sameId.size(); k++) {
//                        if (graphStudent.get(k).contains(sameId.get(k))) {
//                            for (int i = 0; i < graphStudent.get(k).size(); i++) {
//
//
//                                System.out.println("huhuhuhu" + graphStudent.get(k).get(i));
//                            }
//                        }
//
//                    }


                break;
                case 5:
                case 6:
                    System.out.println("Exit");
                    check = false;
            }
        }
    }

    public static void printAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("Adjacency list of " + i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> graphID, int stu, int friend) {
        graphID.get(stu).add(friend);
        //graphID.get(friend).add(stu);
    }


    public static int getIDKey(Map<Integer, String> map, String inputid) {
        int id = 0;
        for (Entry<Integer, String> entry : map.entrySet()) {
            if (Objects.equals(inputid, entry.getValue())) {
                id = entry.getKey();
            }

        }
        return id;
    }

    public static String getIDKeyStudent(Map<String, String> map, String inputid) {
        String id = null;
        for (Entry<String, String> entry : map.entrySet()) {
            if (Objects.equals(inputid, entry.getValue())) {
                id = entry.getKey();
            }

        }
        return id;
    }

    public static String getidValue(Map<Integer, String> map, int id) {
        String studentID = null;
        for (Entry<Integer, String> entry : map.entrySet()) {
            if (Objects.equals(id, entry.getKey())) {
                studentID = entry.getValue();
            }

        }
        return studentID;
    }
    public static void countEdge(ArrayList<ArrayList<Integer>> graph){
        int sum =0;
        for(int i = 0; i< 31; i++){
            sum+= graph.get(i).size();
        }
       int countE = sum/2;
        System.out.println("total of edge in the graph is" + countE);
    }

    public static void removeEdge(ArrayList<ArrayList<Integer>>graph, int id, int studentid){
        for(int i = 0; i < graph.get(id).size(); i++)
        {

            if (graph.get(id).get(i) == studentid)
            {
               graph.get(id).remove(i);
                System.out.println("The edge between the students has been successfully \n" +
                        "removed..");
                break;
            }
            else if (graph.get(id).get(i) != studentid){
                System.out.println("Sorry.. There is no edge between the vertices "+ id + " and"+ studentid + " .");
            }
        }

        for (int i = 0; i < graph.get(studentid).size(); i++)
        {
            if (graph.get(studentid).get(i) == id)
            {
                graph.get(studentid).remove(i);
                break;
            }
            else if (graph.get(id).get(i) != studentid){
                System.out.println("Sorry.. There is no edge between the vertices "+ id + " and"+ studentid + " .");
            }
        }
    }

    public static void removeVertex(ArrayList<ArrayList<Integer>> graph, int id){
        if(id > graph.size()){
            System.out.println("Sorry the student not found!");
        }
        else {
            graph.remove(id);

            for(int i =0; i< graph.size(); i++){
                for(int j =0 ; j< graph.get(i).size(); j++ ){
                    if(graph.get(i).get(j)== id){
                        graph.get(i).remove(id);
                    }
                }

            }
        }
    }

    public static void countFriend(ArrayList<ArrayList<Integer>> graph, int id) {
        int countFriend = 0;
        if (id > graph.size()) {
            System.out.println("Sorry . . the student not found!");
        } else {

            System.out.println("Friend of student are: ");
            for (int i = 0; i < graph.get(id).size(); i++) {

                System.out.println(graph.get(id).get(i));

                    countFriend++;

                }
            System.out.println("Friend count of student is: " + countFriend);
            }

        }
    }




