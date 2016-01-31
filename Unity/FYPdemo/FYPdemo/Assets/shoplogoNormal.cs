using UnityEngine;
using System.Collections;

public class shoplogoNormal : MonoBehaviour {
    public GameController controller;

    void OnMouseEnter()
    {
        controller.SelectShopLogo();
    }
}
