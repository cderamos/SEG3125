using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ChangeScene_Score: MonoBehaviour
{
    void OnMouseDown()
    {
        SceneManager.LoadScene("ScoreScene");
    }
}
