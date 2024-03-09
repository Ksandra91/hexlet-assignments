package exercise;

// BEGIN
public interface Home {

    double getArea();
   default int compareTo(Home another){
       double thisArea = getArea();
       double ahotherArea = another.getArea();
       if (thisArea > ahotherArea) return 1;
       else if (thisArea < ahotherArea) return -1;
       else return 0;
   }

    String toString();
}
// END
