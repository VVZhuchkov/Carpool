package com.github.vvzhuchkov.carpool.model;

import java.io.Serializable;
import java.util.Date;

public class Service implements Serializable {
    private int id;
    private String problem;
    private Date expectedTimeToFinish;
    private boolean isRepaired;

}
