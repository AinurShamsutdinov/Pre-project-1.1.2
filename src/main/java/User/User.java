package User;

public class User {
    private long id;
    private String name;
    private long age;

    public User(){

    }

    public User(long id, String name, long age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(String name, long age){
        this.name = name;
        this.age = age;
    }
    public void setID(long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(long age){
        this.age = age;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public long getAge(){
        return age;
    }


}
