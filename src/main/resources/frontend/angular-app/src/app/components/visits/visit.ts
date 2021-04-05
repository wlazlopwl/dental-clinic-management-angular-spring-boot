import {Patient} from "../patients/patient";
import {Doctor} from "../doctors/doctor";
import {Room} from "../rooms/room";

export interface Visit{
  id: number;
  visitDate: string;
  createDate:string;
  updateDate:string;
  visitStatusType:string;
  patient: Patient;
  doctor: Doctor;
  room : Room;



}
