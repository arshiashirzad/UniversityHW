public class Student {

    protected String fullName;
    protected String studentNo;
    protected String degree;
    protected double averageDegree;

    public Student(String fullName, String studentNo ,String degree,double averageDegree) {
        this.fullName = fullName;
        this.studentNo = studentNo;
        this.degree=degree;
        this.averageDegree=averageDegree;
    }
  @Override
  public String toString() {
      return "Student Name : " + fullName +"," + studentNo + "," + degree + "," + averageDegree;
  }
}
