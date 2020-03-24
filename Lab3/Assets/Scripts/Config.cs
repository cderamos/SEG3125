using System;
using System.Collections;
using System.Collections.Generic;


public class Config
{
    private static int numRounds = 4, time = 4, score, answer;
    private static Config instance;
 
    private Config() {}
    public static Config Instance
    {
        get
        {
            if (instance == null)
                instance = new Config();
            return instance;
		}
	}

    public int Rounds 
    {
        get 
        {
            return numRounds;
        }
        set 
        {
            numRounds = value;
        }
    }
    
    public int Time 
    {
        get 
        {
            return time;
        }
        set 
        {
            time = value;
        }
    }
    
    public int Score 
    {
        get 
        {
            return score;
        }
        set 
        {
            score = value;
        }
    }
    
    public int Answer 
    {
        get 
        {
            return answer;
        }
        set 
        {
            answer = value;
        }
    }
}