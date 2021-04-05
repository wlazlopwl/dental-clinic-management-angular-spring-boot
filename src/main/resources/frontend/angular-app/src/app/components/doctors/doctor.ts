import {Visit} from "../visits/visit";

export interface Doctor{
  id: number;
  firstName: string;
  lastName: string;
  pesel: string;
  phone: string;
  otherPhone: string;
  email: string;
  age: number;
  doctorCode: string;
  gender : string;
  visits: Visit[];
}
