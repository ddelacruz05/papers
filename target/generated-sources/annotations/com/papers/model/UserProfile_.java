package com.papers.model;

import com.papers.model.Profile;
import com.papers.model.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-08T12:33:33")
@StaticMetamodel(UserProfile.class)
public class UserProfile_ { 

    public static volatile SingularAttribute<UserProfile, Profile> profile;
    public static volatile SingularAttribute<UserProfile, Integer> id;
    public static volatile SingularAttribute<UserProfile, String> state;
    public static volatile SingularAttribute<UserProfile, User> user;

}