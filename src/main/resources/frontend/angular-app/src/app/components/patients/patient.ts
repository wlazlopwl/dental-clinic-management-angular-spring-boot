import {Visit} from "../visits/visit";

export interface Patient {
  id: number;
  firstName: string;
  secondName: string;
  lastName: string;
  pesel: string;
  phone: string;
  otherPhone: string;
  email: string;
  age: number;
  isChild: boolean;
  patientCode: string;
  dateOfBirth: string;
  gender : string;
  visits: Visit[];

}

