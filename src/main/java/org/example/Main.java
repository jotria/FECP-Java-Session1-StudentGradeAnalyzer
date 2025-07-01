package org.example;

import java.util.*;

public class Main{
    public static char calculateGrades(int score){
        char grade = 0;
        if (score >= 90 && score <= 100){
            grade = 'A';
        } else if (score >= 80 && score <= 89){
            grade = 'B';
        } else if (score >= 70 && score <= 79){
            grade = 'C';
        } else if (score >= 60 && score <= 69){
            grade = 'D';
        } else if (score >= 0 && score <= 59){
            grade = 'F';
        }

        return grade;
    }

    public static float calculateAverage(ArrayList<Integer> grades){
        int total = 0;
        for(int score: grades){
            total += score;
        }

        float average = (float)total/grades.size();
        return average;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Integer> studentGrades = new ArrayList<>();
        ArrayList<Character> studentLetterGrades = new ArrayList<>();
        ArrayList<String> topStudents = new ArrayList<>();

        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        int topScore = -1;

        for(int i=1; i<=numberOfStudents; i++){
            System.out.print("Enter name of student " + i + ": ");
            String name = scanner.nextLine();
            studentNames.add(name);

            int score;
            while(true){
                System.out.print("Enter score for " + name + ": ");
                score = scanner.nextInt();
                scanner.nextLine();

                if(score >= 0 && score <= 100){
                    break;
                } else{
                    System.out.println("Invalid input. Please input valid grade.");
                }
            } studentGrades.add(score);

            if(score > topScore){
                topScore = score;
                topStudents.clear();
                topStudents.add(name);
            } else if (score == topScore){
                topStudents.add(name);
            }

            //function to get letter grade
            char letterGrade = calculateGrades(score);
            System.out.println(name + " got grade: " + letterGrade + "\n");
            studentLetterGrades.add(letterGrade);

            switch (letterGrade){
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
                case 'F':
                    countF++;
                    break;
                default:
                    break;
            }
        }

        System.out.println("----- Class Summary -----");
        float classAverage = calculateAverage(studentGrades);
        System.out.printf("Average Score: %.2f%n", classAverage);

        System.out.println("Grade Counts: " + "A:" + countA + " B:" + countB + " C:"
                + countC + " D:" + countD + " F:" + countF);

        System.out.print("Top Student(s): ");
        if(topStudents.size() > 1){
            for(int i=0; i < topStudents.size(); i++){
                String student = topStudents.get(i);
                System.out.print(student + " (" + topScore + ")");

                if (i < topStudents.size()-1){
                    System.out.print(", ");
                }
            }
        } else{
            System.out.println(topStudents.getFirst() + " (" + topScore + ") ");
        }
    }
}
