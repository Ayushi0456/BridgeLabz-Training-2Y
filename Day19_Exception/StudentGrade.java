public class StudentGrade {
    public static void main(String[] args) {

        String grades = "90, A+, 85, B, 100, 75";  
        
        String[] gradeList = grades.split(",");     

        System.out.println("Parsing Grades...\n");

        for (String g : gradeList) {
            g = g.trim(); 

            try {
                int value = Integer.parseInt(g);
                System.out.println("Valid Grade: " + value);
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid Grade Input: " + g);
            }
        }
    }
}

