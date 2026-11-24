import java.util.Scanner;

public class DataEntry {
     private String date;
     private Double hoursOfSleep;
     private Boolean exercise;
     private Boolean assessments;
     private Double hoursOfFreeTime;
     private Integer mood;
     private Scanner scan = new Scanner(System.in);
     public DataEntry(){
          System.out.println("What's the date? mm/dd/yy");
          this.date = scan.nextLine().strip();
          System.out.println();
          System.out.println("How many hours did you sleep?");
          this.hoursOfSleep = Double.parseDouble(scan.nextLine().trim());
          System.out.println();
          System.out.println("Did you exercise? Y/N");
          String yesOrNo = scan.nextLine();
          if(yesOrNo.contains("Y") || yesOrNo.contains("y")){
               this.exercise = true;
          }
          else if(yesOrNo.contains("N") || yesOrNo.contains("n")){
               this.exercise = false;
          }
          System.out.println();
          System.out.println("Did you have any assessments? Y/N");
          yesOrNo = scan.nextLine();
          if(yesOrNo.contains("Y") || yesOrNo.contains("y")){
               this.assessments = true;
          }
          else if(yesOrNo.contains("N") || yesOrNo.contains("n")){
               this.assessments = false;
          }
          System.out.println();
          System.out.println("How many hours of free time did you have?");
          this.hoursOfFreeTime = scan.nextDouble();
          System.out.println();
          System.out.println("On a scale of 1 - 10, 1 being horrible, 10 being incredible, how did today feel?");
          this.mood = scan.nextInt();
     }
     public void setDate(String newDate){
          this.date = newDate;
     }
     public void setSleep(Double newSleep){
          this.hoursOfSleep = newSleep;
     }
     public void setExercise(Boolean newExercise){
          this.exercise = newExercise;
     }
     public void setAssessments(Boolean newAssessments){
          this.assessments = newAssessments;
     }
     public void setFreeTime(Double newFreeTime){
          this.hoursOfFreeTime = newFreeTime;
     }
     public void setMood(Integer newMood){
          this.mood = newMood;
     }
     public String returnDataEntryString(){
          String sleep = hoursOfSleep.toString();
          String didExercise = exercise.toString();
          String hadAssessments = assessments.toString();
          String freeTime = hoursOfFreeTime.toString();
          String moodNum = mood.toString();
          String[] tokens = {date, sleep, didExercise, hadAssessments, freeTime, moodNum};
          return String.join(",", tokens);
     }
}
