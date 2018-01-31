package DB;

import android.provider.BaseColumns;

/**
 * Created by dlekd on 2017-10-07.
 */

public final class DataBases {

    public static final class CreateDB implements BaseColumns {
        public static final String C_NAME = "C_NAME";
        public static final String C_PATH = "C_PATH";
        public static final String _TABLENAME = "COURSE";
        public static final String _CREATE =
                "create table "+_TABLENAME+"("
                        +_ID+" integer primary key autoincrement, "
                        +C_NAME+" varchar not null, "
                        +C_PATH+" text not null);";
    }
}
