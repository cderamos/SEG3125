using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ChangeScene_Quiz : MonoBehaviour
{
    void OnMouseDown()
    {
        SceneManager.LoadScene("QuizScene_Gryffindor");
    }
}
   

