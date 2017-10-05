package brainzerstechnologies.sample.com.sharedpreferencessample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 10/5/2017.
 */

class UtilPreferences {
    // Shared Preferences
    private static SharedPreferences pref;

    // Editor for Shared preferences
    private static SharedPreferences.Editor editor;

    // Context
    private static Context _context;
    // Shared pref mode
    private static int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "BrainzersPref";

    // All Shared Preferences Keys
    private static  final String  IS_LOGIN = "isLogin";

    // User name (make variable public to access from outside)
    private static final String KEY_EMAIL = "email";

    // Email address (make variable public to access from outside)
    private static final String KEY_PASSWORD = "password";


    public UtilPreferences(Context context) {
        _context = context;
        pref = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.apply();
    }


    void setKeyEmail(String email){
        editor.putString(KEY_EMAIL, email);
        editor.commit();
    }
    public String getKeyEmail(){
        return pref.getString(KEY_PASSWORD, "");
    }

    void setKeyPassword(String password){
        editor.putString(KEY_PASSWORD, password);
        editor.commit();
    }
    public String getKeyPassword(){
        return pref.getString(KEY_PASSWORD, "");
    }

    void setIsLogin(boolean isLogin){
        editor.putBoolean(IS_LOGIN, isLogin);
        editor.commit();
    }
    public boolean getIsLogin(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    void clearLoginPreference(){
        editor.clear();
        editor.commit();
    }
}
