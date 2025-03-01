package com.cfci.magicapp.adapters;

import java.io.IOException;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cfci.magicapp.model.DataBaseHelper;

/**
 * Created by Carlos on 20/10/2015.
 */
public class TestAdapter
{
	protected static final String TAG = "TestAdapter";

	private final Context mContext;
	private SQLiteDatabase mDb;
	private DataBaseHelper mDbHelper;

	public TestAdapter(Context context)
	{
		this.mContext = context;
		mDbHelper = new DataBaseHelper(mContext);
	}

	public TestAdapter createDatabase() throws SQLException
	{
		try
		{
			mDbHelper.createDataBase();
		}
		catch (IOException mIOException)
		{
			Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
			throw new Error("UnableToCreateDatabase");
		}
		return this;
	}

	public TestAdapter open() throws SQLException
	{
		try
		{
			mDbHelper.openDataBase();
			mDbHelper.close();
			mDb = mDbHelper.getReadableDatabase();
		}
		catch (SQLException mSQLException)
		{
			Log.e(TAG, "open >>"+ mSQLException.toString());
			throw mSQLException;
		}
		return this;
	}

	public void close()
	{
		mDbHelper.close();
	}

	public Cursor getTestData()
	{
		try
		{
			String sql ="SELECT * FROM myTable";

			Cursor mCur = mDb.rawQuery(sql, null);
			if (mCur!=null)
			{
				mCur.moveToNext();
			}
			return mCur;
		}
		catch (SQLException mSQLException)
		{
			Log.e(TAG, "getTestData >>"+ mSQLException.toString());
			throw mSQLException;
		}
	}
}
