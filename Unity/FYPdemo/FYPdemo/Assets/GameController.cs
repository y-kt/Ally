using UnityEngine;
using System.Collections;

public class GameController : MonoBehaviour {

   // public GameObject shoplogo;
    //public GameObject shoplogoWhenLeave;

    public attacher attacherItem;

    public Canvas panel;




    void Start ()
    {

        panel.enabled = false;
       
    }

    public void HidePanel()
    {
        panel.enabled = false;
    }
    
    public void ShowPanel()
    {
        panel.enabled = true;
    }

    public void ClickOnShopLogo()
    {
        attacherItem.attachThing();
        

    }

    public void SelectShopLogo()
    {
        //shoplogo.SetActive(false);
        //shoplogoWhenLeave.SetActive(true);

    }

    public void LeaveShopLogo()
    {
       // shoplogo.SetActive(true);
        //shoplogoWhenLeave.SetActive(false);
    }
}
