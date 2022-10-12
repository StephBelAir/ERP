import {IMachine} from "./imachine";

export interface IProcess {
  processId: number;
  processName: string;
  productionTimeTotalForOneParts : Date;
  machine: IMachine[];
}
