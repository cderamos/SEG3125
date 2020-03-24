using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;

public class ClickedA : EventTrigger
{
    public Config config = Config.Instance;

    public override void OnPointerClick(PointerEventData data)
    {
        Debug.Log("OnPointerClick called.");
        ChangeColour();
        config.Answer = 0;
    }

    public void ChangeColour() {
        var myText = GameObject.Find("a").GetComponent<Text>(); 
        myText.color = Color.gray;
	}
}