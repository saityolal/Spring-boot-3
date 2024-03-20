package spring_boot_3.demo;

public class Course {

    int id;
    String definition;
    String author;

    

    @Override
    public String toString() {
        return "Course [id=" + id + ", definition=" + definition + ", author=" + author + "]";
    }
    


    Course() {
    }


    Course(int id, String definition, String author) {
        this.id = id;
        this.definition = definition;
        this.author = author;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getDefinition() {
        return definition;
    }



    public void setDefinition(String definition) {
        this.definition = definition;
    }



    public String getAuthor() {
        return author;
    }



    public void setAuthor(String author) {
        this.author = author;
    };

}
