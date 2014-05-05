package com.example.pascaltask;

import android.os.Parcel;
import android.os.Parcelable;

public class myparcel implements Parcelable {
	Employee obj;
	
	public Employee getObject() {	
		return obj;
	}
	
	//Is used to reconstruct the object
	private myparcel(Parcel in) {
		obj = new Employee(in.readString(), in.readString(), in.readInt(),in.readFloat());
	}
	
	public myparcel(Employee obj) {
		this.obj = obj;
	}
	
	public int describeContents() {
		//returns the hashcode
		return (int)(obj.hashCode() % 10);
	}
	
	
	//Flattening happens here
	public void writeToParcel(Parcel in, int flags) {
		in.writeString(obj.getFirst());
		in.writeString(obj.getLast());
		in.writeInt(obj.getAge());
		in.writeFloat(obj.getSal());
	}
	
	public static final Parcelable.Creator<myparcel> CREATOR = new Parcelable.Creator<myparcel>() {
		public myparcel createFromParcel(Parcel in) {
			return new myparcel(in);
		}
		
		public myparcel[] newArray(int size) {
			return new myparcel[size];
		}
	};
}
