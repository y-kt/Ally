using UnityEngine;
using System.Collections;

public class shoplogoWhenSelect : MonoBehaviour {

    public GameController controller;

    void OnMouseExit()
    {
        controller.LeaveShopLogo();
    }

    void OnMouseDown()
    {
        controller.ClickOnShopLogo();
    }

}
