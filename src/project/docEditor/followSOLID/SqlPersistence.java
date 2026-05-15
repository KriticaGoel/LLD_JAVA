package project.docEditor.followSOLID;


public class SqlPersistence implements PersistenceManager{
    public void save(String data){
            // save to sql database
            System.out.println("Saving to sql database "+data);

    }
}
