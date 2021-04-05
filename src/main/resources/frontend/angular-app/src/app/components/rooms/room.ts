import {Visit} from "../visits/visit";

export interface Room {
  id: number;
  name: string;
  visits: Visit[];

}
