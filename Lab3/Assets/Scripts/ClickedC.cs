using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;

public class ClickedC : EventTrigger
{
    public Config config = Config.Instance;

    public override void OnPointerClick(PointerEventData data)
    {
        Debug.Log("OnPointerClick called.");
        ChangeColour();
        config.Answer = 2;
    }

    public void ChangeColour() {
        var myText = GameObject.Find("c").GetComponent<Text>(); 
        myText.color = Color.gray;

	}
}