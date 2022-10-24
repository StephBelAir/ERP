import { Component, OnInit } from '@angular/core';
import {IProcess} from "../../interfaces/iprocess";
import {ProcessService} from "../../services/process.service";
import {MachineService} from "../../services/machine.service";
import {IMachine} from "../../interfaces/imachine";
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material/dialog";
import Swal from "sweetalert2";


@Component({
  selector: 'app-process-add-machines-dialog',
  templateUrl: './process-add-machines-dialog.component.html',
  styleUrls: ['./process-add-machines-dialog.component.scss']
})
export class ProcessAddMachinesDialogComponent implements OnInit {

  listProcess!: IProcess[];
  listMachine!: IMachine[];
  addMachineForm!: FormGroup;



  constructor(private formBuilder : FormBuilder, private processService : ProcessService, private machineService : MachineService, private dialogRef: MatDialogRef<ProcessAddMachinesDialogComponent>) { }

  ngOnInit(): void {
    this.addMachineForm = this.formBuilder.group({
      processId : ['',Validators.required],
      machineId : ['',Validators.required]
    })
    this.getAllProcess();
    this.getAllMachines();
  }

  addMachinesInProcess(){
    console.log(this.addMachineForm.value)
    if (this.addMachineForm.valid) {
      this.processService.patchProcess(this.addMachineForm.value)
        .subscribe({
          next: (res) => {
            Swal.fire({ title:"Machine added successfully",
              icon: "success"});
            this.addMachineForm.reset();
            this.dialogRef.close('saveMachine');
          },
          error: () => {
            Swal.fire({ title:"Error while fetching the Records !!",
              icon: "error",})
          }
        })
    }
  }


  getAllProcess() {
    this.processService.getProcess()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.listProcess = res
          console.log("Process Loaded", this.listProcess)
        },
        error: (err) => {
          Swal.fire({ title:"Error while fetching the Records !!",
            icon: "error",})
        }
      })
  }

  getAllMachines() {
    this.machineService.getMachine()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.listMachine = res
          console.log("Machine Loaded", this.listMachine)
        },
        error: (err) => {
          Swal.fire({ title:"Error while fetching the Records !!",
            icon: "error",})
        }
      })
  }

}
