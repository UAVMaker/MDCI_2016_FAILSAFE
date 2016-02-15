package com.team1601.FRC_2016.Utilities;

public class Toggle{
    private boolean toggle;
    private boolean lastState;


    public boolean update(boolean currentState)
    {
        if (currentState && !lastState)
        {
            toggle = !toggle;
        }

        lastState = currentState;
        return toggle;

    }

}
