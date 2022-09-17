package com.hieuminh.jobfinder.models

import android.os.Parcel
import android.os.Parcelable
import com.hieuminh.jobfinder.models.base.BaseModel

class Tip() : BaseModel(), Parcelable {
    constructor(parcel: Parcel) : this()

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tip> {
        override fun createFromParcel(parcel: Parcel): Tip {
            return Tip(parcel)
        }

        override fun newArray(size: Int): Array<Tip?> {
            return arrayOfNulls(size)
        }
    }
}
