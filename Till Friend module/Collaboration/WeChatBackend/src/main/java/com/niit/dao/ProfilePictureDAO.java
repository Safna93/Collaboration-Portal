package com.niit.dao;

import com.niit.model.ProfilePicture;

public interface ProfilePictureDAO {
void save(ProfilePicture profilePicture);
ProfilePicture getProfilePicture(String username);

}