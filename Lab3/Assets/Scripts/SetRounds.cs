using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class SetRounds : MonoBehaviour
{
    public Dropdown dd;
    protected Config config = Config.Instance;

    // Update is called once per frame
    void Update()
    {
        config.Rounds = dd.value;
        Debug.Log(config.Rounds);
    }
}