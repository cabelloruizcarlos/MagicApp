package com.cfci.magicapp.OLDmodel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Carlos on 20/10/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
	private static String TAG = "DataBaseHelper";

	private static String DB_PATH = "";
	private static String DB_NAME = "MagicDb";// Database name
	private static String TABLE_NAME = "Cards";
	private SQLiteDatabase mDataBase;
	private final Context mContext;

	public DataBaseHelper(Context context) {
		super(context, DB_NAME, null, 1);
		if (android.os.Build.VERSION.SDK_INT >= 17) {
			DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
		} else {
			DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
		}
		this.mContext = context;
	}

	public void createDataBase() throws IOException {
		//If database not exists copy it from the assets

		boolean mDataBaseExist = checkDataBase();
		if (!mDataBaseExist) {
			this.getReadableDatabase();
			this.close();
			try {
				//Copy the database from assests
				copyDataBase();
				Log.e(TAG, "createDatabase database created");
			} catch (IOException mIOException) {
				throw new Error("ErrorCopyingDataBase");
			}
		}
	}

	//Check that the database exists here: /data/data/your package/databases/MagicDb
	private boolean checkDataBase() {
		File dbFile = new File(DB_PATH + DB_NAME);
		//Log.v("dbFile", dbFile + "   "+ dbFile.exists());
		return dbFile.exists();
	}

	//Copy the database from assets
	private void copyDataBase() throws IOException {
		InputStream mInput = mContext.getAssets().open(DB_NAME);
		String outFileName = DB_PATH + DB_NAME;
		OutputStream mOutput = new FileOutputStream(outFileName);
		byte[] mBuffer = new byte[1024];
		int mLength;
		while ((mLength = mInput.read(mBuffer)) > 0) {
			mOutput.write(mBuffer, 0, mLength);
		}
		mOutput.flush();
		mOutput.close();
		mInput.close();
	}

	//Open the database, so we can query it
	public boolean openDataBase() throws SQLException {
		String mPath = DB_PATH + DB_NAME;
		//Log.v("mPath", mPath);
		mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
		//mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		return mDataBase != null;
	}

	@Override
	public synchronized void close() {
		if (mDataBase != null)
			mDataBase.close();
		super.close();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		db.execSQL("CREATE TABLE " + TABLE_NAME + " (\"name\" VARCHAR PRIMARY KEY  NOT NULL  UNIQUE , \"manaCost\" VARCHAR, \"cmc\" INTEGER DEFAULT 0, \"colour\" VARCHAR, \"type\" VARCHAR, \"superType\" VARCHAR, \"types\" VARCHAR, \"subTypes\" VARCHAR, \"rarity\" VARCHAR, \"loyalty\" INTEGER DEFAULT 0, \"text\" VARCHAR, \"flavor\" VARCHAR, \"artist\" VARCHAR, \"number\" VARCHAR, \"power\" VARCHAR, \"toughness\" VARCHAR, \"layout\" VARCHAR, \"multiverseId\" INTEGER, \"id\" VARCHAR UNIQUE )");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
		onCreate(db);
	}
}
