using UnityEngine;
using System.Collections;

public class attacher : MonoBehaviour {

   

    public Sprite sprite;

    [SpineSlot]
    public string slot;

    [SpineSkin]
    public string skin;

    void Start()
    {
       
    }

    public void attachThing()
    {
        var skeletonRenderer = GetComponent<SkeletonRenderer>();

        var attachment = skeletonRenderer.skeleton.Data.AddUnitySprite(slot, sprite, skin, "Sprites/Default");

        skeletonRenderer.skeleton.SetAttachment(slot, sprite.name);
    }


}
