import java.util.Objects;
import java.util.Random;

public class MyTestingClass {
    private int id;
    private String jobPosition;

    public MyTestingClass(String jobPosition) {
        this.id = id;
        this.jobPosition = jobPosition;
    }
    public String getJobPosition() {
        return jobPosition;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyTestingClass that = (MyTestingClass) o;
        return Objects.equals(jobPosition, that.jobPosition);
    }
    @Override
    public int hashCode() {
        int res = 17;
        res = 17 * res + id;
        for(int i =0;i<jobPosition.length();i++){
            res = res * 31 + jobPosition.charAt(i);
        }
        return res;
    }
}