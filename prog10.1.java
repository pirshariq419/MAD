package com.example.shariq;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

public class Students_Providers extends ContentProvider {

    static final String AUTHORITY = "com.example.studentprovider.StudentsProvider";
    static final String PATH = "students";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + PATH);

    private static final int STUDENTS = 1;
    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, PATH, STUDENTS);
    }

    MatrixCursor dataCursor;

    @Override
    public boolean onCreate() {
        dataCursor = new MatrixCursor(new String[] { "_id", "name", "roll" });
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        if (uriMatcher.match(uri) == STUDENTS) {
            return dataCursor;
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        if (uriMatcher.match(uri) == STUDENTS) {
            dataCursor.addRow(new Object[] {
                    dataCursor.getCount() + 1,
                    values.getAsString("name"),
                    values.getAsString("roll")
            });
        }
        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }
}
