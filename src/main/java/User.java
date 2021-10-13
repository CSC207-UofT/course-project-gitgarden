/* CRC Class Information Class name: User

Parent Class: None

Responsibilities:
* Stores name, address, identification, summary

Collaborators:
* ProfileManager
* Farmer
* Distributor

*/


public class User {

    //User's Name & Identification
    //There may be more information added(i.e. contact)
    private String user_name;
    private int user_id; //(1)

    //Address
    private String user_address;//(2)We might also need user's postal code clearify their address

    //Summary
    public String summary; //(3)We need a method to edit summary outside of the class

     /**
     * Construct a User, giving them the name and address
     *
     * @param user_name String for name
     * @param user_address  String for address
     */

    public User(String user_name, String user_address){
        this.user_name = user_name;
        this.user_id = 1000; //(4)
        this.user_address = user_address;
        this.summary = "Default Summary";
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
     * @return the current value of user's address (String)
     */
    public String getUser_address(){
        return this.user_address;
    }

    public String getSummary(){
        return this.summary;
    }

     /**
     * @return the String representation of the user
     */
    public String toString(){
        return "Name: " + user_name + "\"" +
                "ID: " + user_id + "\"" +
                "Address: " + user_address + "\"" +
                "Summary: " + summary;
    }

}
