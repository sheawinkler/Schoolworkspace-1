package bander.notepad;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oscar on 12/6/14.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "ContactDB";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

       Log.d("Debug", "Entering MySQLiteHelper::onCreate");
        // SQL statement to create book table
        String CREATE_CONTACT_TABLE = "CREATE TABLE Contact ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "owner TEXT," +
                "name TEXT, "+
                "phoneNumber TEXT," +
                "email TEXT," +
                "address TEXT)";

        String CREATE_USER_TABLE = "CREATE TABLE User (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT, " +
                "password TEXT)";

        String addUser1 = "INSERT INTO User (username,password) VALUES ('Oscar', '12345')";
        String addUser2 = "INSERT INTO User (username,password) VALUES ('Jasmine', '67890')";
        String addUser3 = "INSERT INTO User (username,password) VALUES ('Hero', 'tobe')";

        String addContact11 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Oscar','Contact For Oscar','402-523-8755','Jasmine@live.com', 'clcul st')";

        String addContact1 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Oscar','Contact for Oscar','402-523-8755','Jasmine@live.com', '346 S st')";
        String addContact2 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Oscar','Contact for Oscar','402-878-0990','Jonathon@live.com', '456 N st')";
        String addContact3 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Oscar','Contact for Oscar','402-090-6776','Kevin@live.com', '34 Jefferson St')";
        String addContact4 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Jasmine','Contact for Jasmine','402-123-4544','AllenWhat@live.com', 'C st')";
        String addContact5 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Jasmine','Contact for Jasmine','402-478-2689','Jennifer@tolive.com', '9th st')";
        String addContact6 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Jasmine','Contact for Jasmine','467-690-1480','Donold@richy.com', 't st')";
        String addContact7 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Hero','Contact for Hero','402-949-8755','Nathan@live.com', 'Unknown')";
        String addContact8 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Hero','Contact for Hero','402-099-1343','Force@live.com', 'Unknown')";
        String addContact9 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Hero','Contact for Hero','402-234-1111','ChrisitanBora@live.com', 'H st')";
        String addContact10 = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES " +
                "('Hero','Contact for Hero','435-898-8755','Deverick@live.com', 'M st')";



        // create books table
        db.execSQL(CREATE_CONTACT_TABLE);
        db.execSQL(CREATE_USER_TABLE);

        //initialize tables
        db.execSQL(addUser1);
        db.execSQL(addUser2);
        db.execSQL(addUser3);
        db.execSQL(addContact1);
        db.execSQL(addContact2);
        db.execSQL(addContact3);
        db.execSQL(addContact4);
        db.execSQL(addContact5);
        db.execSQL(addContact6);
        db.execSQL(addContact7);
        db.execSQL(addContact8);
        db.execSQL(addContact9);
        db.execSQL(addContact10);
        db.execSQL(addContact11);

        Log.d("Debug", "Exiting MySQLiteHelper::onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Contact");
        onCreate(db);
    }

    //Entry table name
    public static final String TABLE_CONTACT = "Contact";

    //Entry column names
    //public static final String KEY_NAME = "name";
    //public static final String KEY_PHONE_NUMBER = "phoneNumber";
    //public static final String KEY_EMAIL = "email";
    //public static final String KEY_ADDRESS = "address";

    //public static final String[] columns = { KEY_NAME, KEY_PHONE_NUMBER, KEY_EMAIL, KEY_ADDRESS};

    public boolean authenticate(String username,String password)
    {
        String query = "SELECT * FROM User WHERE username = " + "'" + username + "'" +
                " AND password = " + "'" + password + "'";
            //    password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        return cursor.getCount() != 0;

    }

    public void addContact(PrivateContact contact){
        //Log.d("DEBUG", "Running addContact()");
        String addQuery = "INSERT INTO Contact (owner,name,phoneNumber,email,address) VALUES (?,?,?,?,?)";
//        String owner = contact.getOwner();
//        String name = contact.getName();
//        String phoneNumber = contact.getPhoneNumber();
//        String email = contact.getEmail();
//        String address = contact.getAddress();

        SQLiteDatabase db = this.getWritableDatabase();
        String[] args = { contact.getOwner(), contact.getName(), contact.getPhoneNumber(), contact.getEmail(), contact.getAddress()};
        db.execSQL(addQuery, args);
        db.close();

        //Log.d("DEBUG", "Exiting addContact()");
    }

    public List<PrivateContact> getAllContacts(String username) {
        List<PrivateContact> contacts = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_CONTACT + " WHERE owner = " + "'" +username + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do {
                String name = cursor.getString(2);
                String phoneNumber = cursor.getString(3);
                String email = cursor.getString(4);
                String address = cursor.getString(5);

                contacts.add(new PrivateContact(username, name, phoneNumber, email, address));
            } while (cursor.moveToNext());
        }
        db.close();

        return contacts;
    }


}
