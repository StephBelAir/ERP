import {IMachine} from "./imachine";
import {IProcess} from "./iprocess";

export interface ILot {
  id: number;
  quantity: number;
  length: number;
  width: number;
  productName: string;
  type: string;
  specialType: number;
  startDate: Date;
  endDate: Date;
  actualEndDate: Date;
  productionTimeByQuantity: number;
  estimateEndDate: Date;
  process:IProcess[];
  machine: IMachine[];
}
