package Entities;

public class User {
    private String user_name;
    private final int user_id;//Temporarily set to be a random 6 digit integer.
    private String user_address;
    private String summary;//Default to string "Default Summary".

     /**
     * Construct a User, giving them the name and address
     *
     * @param user_name String for name
     * @param user_address  String for address
     */
    public User(String user_name, String user_address){
        this.user_name = user_name;
        this.user_id = (int) (Math.random()*(900000)+100000);
        this.user_address = user_address;
        this.summary = "Default Summary";
    }

    /**
     * Set the username to the given name.
     * @param name String for new name to be set.
     */
    public void setUser_name(String name){
        this.user_name = name;
    }

     /**
     * @return the current value of user_name (String)
     */
    public String getUser_name(){
        return this.user_name;
    }

     /**
     * @return the current value of user_id (int)
     */
    public int getUser_id(){
        return this.user_id;
    }

    /**
     * TODO: Add Annotation
     */
    public void setUser_address(String address){
        this.user_address = address;
    }

     /**
     * @return the current value of user's address (String)
     */
    public String getUser_address(){
        return this.user_address;
    }

    /**
     * Set the user's summary to the given summary.
     *
     * @param summary new summary that will be changed.
     */
    public void setSummary(String summary){
        this.summary = summary;
    }

     /**
     * @return the current value of user's summary (String)
     */
    public String getSummary(){
        return this.summary;
    }

     /**
     * @return the String representation of the user
     */
    public String toString(){
        return "Name: " + user_name + "\n" +
                "Address: " + user_address + "\n" +
                "Summary: " + summary + "\n";
    }

}