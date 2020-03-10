using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class ChangeScene_Home : MonoBehaviour
{
    void OnMouseDown()
    {
        SceneManager.LoadScene("Homepage");
    }
}
