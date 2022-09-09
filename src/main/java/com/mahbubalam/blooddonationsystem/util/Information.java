package com.mahbubalam.blooddonationsystem.util;

import java.io.Serializable;

public class Information {
    public int id;
    public NetworkUtility networkUtility;

    public Information(int id, NetworkUtility networkUtility) {
        this.id = id;
        this.networkUtility = networkUtility;
    }
}
