using UnityEngine;
using System.Collections;

public class attachskeleton : MonoBehaviour {

    public SkeletonDataAsset data;

    [SpineSlot]
    public string slot;




    void Start()
    {

        var skeletonRenderer = GetComponent<SkeletonRenderer>();

       
        
        skeletonRenderer.skeleton.SetAttachment(slot, data.name);

    }
}
