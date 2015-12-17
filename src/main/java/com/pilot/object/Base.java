package com.pilot.object;

import java.util.List;

/**
 * Created by Neeraj Rathi on 12/17/2015.
 */
public class Base {
    public int rc;
    public String message;
    public List<Roles> he;


    public class Roles {
        public String name;
        public int type;
    }
}