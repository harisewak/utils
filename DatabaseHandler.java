package com.techmorphosis.qube.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kamlesh on 011 11/12/15.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "audio_one_db";
    final String TABLE_NOTIF = "notif_table";
    final String KEY_ID = "id";
    final String KEY_MESSAGE = "message";
    final String KEY_TIME = "time";
    static final int DATABASE_VERSION = 1;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NOTIF + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MESSAGE + " TEXT," + KEY_TIME + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIF);
        onCreate(db);
    }

//    public boolean add(NotifModel model) {
//        ContentValues values = new ContentValues();
//        values.put(KEY_MESSAGE, model.notifText);
//        values.put(KEY_TIME, model.notifTime);
//        return getWritableDatabase().insert(TABLE_NOTIF, null, values) != -1;
//    }
//
//    public List<NotifModel> fetchAll() {
//        Cursor cursor = getReadableDatabase().query(TABLE_NOTIF, null, null, null, null, null, KEY_ID + " desc");
//        List<NotifModel> list = new ArrayList<>();
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//                list.add(new NotifModel(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
//            }
//
//        }
//        return list;
//    }
}
