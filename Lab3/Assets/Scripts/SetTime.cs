using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class SetTime : MonoBehaviour
{
    public Dropdown dd;
    protected Config config = Config.Instance;

    // Update is called once per frame
    void Update()
    {
        config.Time = dd.value;
        Debug.Log(config.Time);
    }
}