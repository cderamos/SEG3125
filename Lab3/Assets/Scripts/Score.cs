using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.EventSystems;
using UnityEngine.SceneManagement;

public class Score : EventTrigger
{
    public Config config = Config.Instance;

     public override void OnPointerClick(PointerEventData data)
    {
        SceneManager.LoadScene("QuizScene_Gryffindor");
    }

    public void Start() {
        GameObject.Find("score").GetComponent<Text>().text = config.Score + " out of " + config.Rounds * 5;
	}
}
