package com.experian.rest.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.experian.rest.messenger.database.Database;
import com.experian.rest.messenger.model.Profile;

public class ProfileService {
	
private Map<String, Profile> profiles = Database.getProfiles();

public ProfileService() {
	profiles.put("Admin", new Profile(1, "jepaul", "Jeejo", "Paul"));
	profiles.put("User", new Profile(2, "jipaul", "Jinto", "Paul"));
}
	
	public List<Profile> getProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty())
			return null;
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
