import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {MachineService} from "../../services/machine.service";
import {MatDialogRef} from "@angular/material/dialog"
import {IMachine} from "../../interfaces/imachine";
import Swal from "sweetalert2";

@Component({
  selector: 'app-machine-dialog',
  templateUrl: './machine-dialog.component.html',
  styleUrls: ['./machine-dialog.component.scss']
})
export class MachineDialogComponent implements OnInit {

  machineForm!: FormGroup;
  listMachine!: IMachine[];

  constructor(private formBuilder : FormBuilder, private machineService : MachineService, private dialogRef : MatDialogRef<MachineDialogComponent>) { }

  ngOnInit(): void {
    this.machineForm = this.formBuilder.group({
      productionTime : ['', Validators.required],
      machineType  : ['', Validators.required],
      machineName : ['', Validators.required]
    })
    this.getAllMachines()
  }

    addMachine() {
      if (this.machineForm.valid){
        this.machineService.postMachine(this.machineForm.value)
          .subscribe({
            next: (res) => {
              Swal.fire("Machine added successfully");
              this.machineForm.reset();
              this.dialogRef.close('save');
            },
            error: () => {
              Swal.fire("Error while adding the product")
            }
          })
      }
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
          Swal.fire("Error while fetching the Records !!")
        }
      })
  }

}
