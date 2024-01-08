package shrishti.example;
import java.util.HashMap;

public class studentRepository {

    HashMap<Integer, student> studentsMap= new HashMap<>();
    HashMap<String ,Integer> Map= new HashMap<>();
    logger lg=new logger();

    public void addStudent(student stud){
        studentsMap.put(stud.getId(),stud);
        Map.put(stud.getName(),stud.getId());
    }


    public student retrieve(int id){
        student output =studentsMap.getOrDefault(id, null);
        if(output == null)
            lg.logmsg("User not listed in the system");

        return output;
    }
     public student retrieve(String name){
        int output =Map.getOrDefault(name.toLowerCase(),-1);
        if(output==-1)
            lg.logmsg("User not listed in the system");
        return studentsMap.get(output);
     }

     public void update(student stud, int id){
        student obj = studentsMap.getOrDefault(id,null);
        if(obj == null){
           lg.logmsg("User not listed in the system, add user");
        }
        studentsMap.put(id,stud);
     }

     public void printStudent(student stud){
         System.out.println("name: " + stud.getName());
         System.out.println("age: " + stud.getAge());
         System.out.println("grade" + stud.getGrade());
         System.out.println("id" + stud.getId());
     }



     /*


    public Student getStudentById(int id) {
        return studentsMap.getOrDefault(id, null);
    }

    public Student getStudentByName(String name) {
        for (Student student : studentsMap.values()) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
      */



    //public Student getStudentById(int id) {
      //  return studentsMap.getOrDefault(id, null);
    //}



}
