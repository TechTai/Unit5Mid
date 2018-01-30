package nyc.c4q.randomuserapp;

/**
 * Created by MsNehisi on 1/29/18.
 */

public class User {
    private String name;
    private String description;
    private int imageResourceID;

    public static final User[] user = {
            new User("Priya", "Program Manager for Access Code: Full Stack Web Development Cohort 4.2 - Nights and Weekends", R.drawable.c4q_priya),
            new User("Cody", "Instructor for Access Code: Full Stack Web Development Cohort 4.2 - Nights and Weekends", R.drawable.c4q_cody),
            new User("Stefani","Program Manager for Access Code: iOS Development 4.3 - Days", R.drawable.c4q_stefani),
            new User("Jose", "Instructor for Access Code: Android Development Cohort 4.4 - Nights and Weekends", R.drawable.c4q_jose)
    };

    //Constructor
    private User(String name, String description, int imageResourceID){
        this.name = name;
        this.description = description;
        this.imageResourceID = imageResourceID;
    }

    //Getters
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getImageResourceID(){
        return imageResourceID;
    }


}
