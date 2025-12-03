package com.srms;

public class ResultCalculator{

    // Calculate percentage
    public double calculatePercentage(Marks m) {
        double total = m.getMaths() + m.getScience() + m.getEnglish();
        return total / 3.0;
    }

    // Calculate grade
    public String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B+";
        else if (percentage >= 60) return "B";
        else if (percentage >= 50) return "C";
        else return "Fail";
    }
}
