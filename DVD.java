// A simple definition for a DVD.
public class DVD {
    public String name;
    public int releaseYear;
    public String director;

    public DVD(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public String toString() {
        return this.name + ", directed by " + this.director + ", released in " + this.releaseYear;
    }
    public static void main(String[] args) {
        DVD[] dvdCollection = new DVD[15];
        
        for(int i = 0; i< dvdCollection.length;i++){
            DVD d = new DVD("Praise", 2002, "Paul");
            dvdCollection[i] = d;
            System.out.println(dvdCollection[i]);
        }
    }
}