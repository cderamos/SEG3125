using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AddCollider : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        BoxCollider boxCollider = gameObject.AddComponent<BoxCollider>();
    }
}
