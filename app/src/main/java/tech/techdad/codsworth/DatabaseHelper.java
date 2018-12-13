package tech.techdad.codsworth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Name and Version
    private static final String DATABASE_NAME = "codsworth.db";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_UNITS = "units";
    private static final String TABLE_FACTIONS = "factions";
    private static final String TABLE_SKILLS = "skills";
    private static final String TABLE_ACTIONS = "actions";
    private static final String TABLE_ICONS = "icons";

    // Unit Table Column Names
    private static final String KEY_UNIT_ID = "id";
    private static final String KEY_UNIT_TITLE = "title";
    private static final String KEY_UNIT_FACTION = "faction";
    private static final String KEY_UNIT_UNIQUE = "unique";
    private static final String KEY_UNIT_MOVE = "move";
    private static final String KEY_UNIT_CHARGE = "charge";
    private static final String KEY_UNIT_STR = "str";
    private static final String KEY_UNIT_STR_SKILL1 = "str_skill1";
    private static final String KEY_UNIT_STR_SKILL2 = "str_skill2";
    private static final String KEY_UNIT_PER = "per";
    private static final String KEY_UNIT_PER_SKILL1 = "per_skill1";
    private static final String KEY_UNIT_PER_SKILL2 = "per_skill2";
    private static final String KEY_UNIT_END = "end";
    private static final String KEY_UNIT_END_SKILL1 = "end_skill1";
    private static final String KEY_UNIT_END_SKILL2 = "end_skill2";
    private static final String KEY_UNIT_CHA = "cha";
    private static final String KEY_UNIT_CHA_SKILL1 = "cha_skill1";
    private static final String KEY_UNIT_CHA_SKILL2 = "cha_skill2";
    private static final String KEY_UNIT_INT = "int";
    private static final String KEY_UNIT_INT_SKILL1 = "int_skill1";
    private static final String KEY_UNIT_INT_SKILL2 = "int_skill2";
    private static final String KEY_UNIT_AGL = "agl";
    private static final String KEY_UNIT_AGL_SKILL1 = "agl_skill1";
    private static final String KEY_UNIT_AGL_SKILL2 = "agl_skill2";
    private static final String KEY_UNIT_LUC = "luc";
    private static final String KEY_UNIT_LUC_SKILL1 = "luc_skill1";
    private static final String KEY_UNIT_LUC_SKILL2 = "luc_skill2";
    private static final String KEY_UNIT_SPECIAL = "special";
    private static final String KEY_UNIT_EQUIPPED = "equipped";
    private static final String KEY_UNIT_ARM_PHYS = "arm_phys";
    private static final String KEY_UNIT_ARM_ENERGY = "arm_energy";
    private static final String KEY_UNIT_ARM_RAD = "arm_rad";
    private static final String KEY_UNIT_REACT = "react";
    private static final String KEY_UNIT_ACT1 = "action_1";
    private static final String KEY_UNIT_ACT2 = "action_2";
    private static final String KEY_UNIT_ICON1  = "icon_1";
    private static final String KEY_UNIT_ICON2 = "icon_2";


    //Faction Table Column Names
    private static final String KEY_FACTION_ID = "id";
    private static final String KEY_FACTION_NAME = "name";

    //Skills Table Column Names
    private static final String KEY_SKILL_ID = "id";
    private static final String KEY_SKILL_NAME = "name";

    //Actions Table Column Names
    private static final String KEY_ACTION_ID = "id";
    private static final String KEY_ACTION_NAME = "name";

    //Icons Table Column Names
    private static final String KEY_ICON_ID = "id";
    private static final String KEY_ICON_NAME = "name";

    private static DatabaseHelper sInstance;

    public static synchronized DatabaseHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SKILLS_TABLE = "CREATE TABLE " + TABLE_SKILLS +
                "(" +
                KEY_SKILL_ID + " INTEGER PRIMARY KEY," +
                KEY_SKILL_NAME + " TEXT" +
                ")";

        String CREATE_FACTIONS_TABLE = "CREATE TABLE " + TABLE_FACTIONS +
                "(" +
                KEY_FACTION_ID + " INTEGER PRIMARY KEY," +
                KEY_FACTION_NAME + " TEXT" +
                ")";

        String CREATE_ACTIONS_TABLE = "CREATE TABLE " + TABLE_ACTIONS +
                "(" +
                KEY_ACTION_ID + " INTEGER PRIMARY KEY," +
                KEY_ACTION_NAME + " TEXT" +
                ")";

        String CREATE_ICONS_TABLE = "CREATE TABLE " + TABLE_ICONS +
                "(" +
                KEY_ICON_ID + " INTEGER PRIMARY KEY," +
                KEY_ICON_NAME + " TEXT" +
                ")";
        
        //Create The Tables
        db.execSQL(CREATE_SKILLS_TABLE);
        db.execSQL(CREATE_FACTIONS_TABLE);
        db.execSQL(CREATE_ICONS_TABLE);
        db.execSQL(CREATE_ACTIONS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SKILLS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_FACTIONS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ICONS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIONS);
            onCreate(db);
        }
    }

}
