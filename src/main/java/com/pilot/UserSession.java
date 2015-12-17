package com.pilot;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class UserSession {
	private SharedPreferences sp;
	private SharedPreferences.Editor spEditor;

	public UserSession(Context context) {
		sp = PreferenceManager.getDefaultSharedPreferences(context);

	}

	public boolean setUserId(String id) {

		spEditor = sp.edit();
		spEditor.putString("user_id", id);
		spEditor.apply();
		return true;
	}

	public String getUserId() {
		return sp.getString("user_id", null);
	}

	public String getUserPassword() {
		return sp.getString("password", null);
	}

	public boolean setUserPassword(String pass) {
		spEditor = sp.edit();
		spEditor.putString("password", pass);
		spEditor.apply();
		return true;
	}

	public String getUserEmail() {
		return sp.getString("email", null);
	}

	public boolean setUserEmail(String email) {
		spEditor = sp.edit();
		spEditor.putString("email", email);
		spEditor.apply();
		return true;
	}

	public String getDisplayName() {
		return sp.getString("display_name", null);
	}

	public boolean setDisplayName(String name) {
		spEditor = sp.edit();
		spEditor.putString("display_name", name);
		spEditor.apply();
		return true;
	}
	public boolean getUserLoggedIn() {
		return sp.getBoolean("logged_in", false);
	}

	public boolean setUserLoggedIn(boolean isLoggedIn) {
		spEditor = sp.edit();
		spEditor.putBoolean("logged_in", isLoggedIn);
		spEditor.apply();
		return true;
	}

	public String getUserLanguage() {
		return sp.getString("language", "");
	}

	public boolean setUserLanguage(String language) {
		spEditor = sp.edit();
		spEditor.putString("language", language);
		spEditor.apply();
		return true;
	}

	public boolean destroyUserSession() {
		spEditor = sp.edit();
		spEditor.remove("logged_in");
		spEditor.remove("email");
		spEditor.remove("password");
		spEditor.remove("language");
		spEditor.remove("user_token");
		spEditor.apply();
		return true;
	}
	// ///////////////////////////////////////////////////////////
	
	public String getUserToken() {
		return sp.getString("user_token", null);
	}

	public boolean setUserToken(String token) {
		spEditor = sp.edit();
		spEditor.putString("user_token", token);
		spEditor.apply();
		return true;
	}
}
