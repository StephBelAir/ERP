import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {MachineService} from "../../services/machine.service";
import {MatDialogRef} from "@angular/material/dialog"

@Component({
  selector: 'app-machine-dialog',
  templateUrl: './machine-dialog.component.html',
  styleUrls: ['./machine-dialog.component.scss']
})
export class MachineDialogComponent implements OnInit {

  machineForm !: FormGroup;

  constructor(private formBuilder : FormBuilder, private machineService : MachineService, private dialogRef : MatDialogRef<MachineDialogComponent>) { }

  ngOnInit(): void {
    this.machineForm = this.formBuilder.group({
      productionTime : ['', Validators.required],
      machineType  : ['', Validators.required],
      processOrder  : ['', Validators.required]
    })
  }

    addMachine() {
      if (this.machineForm.valid){
        this.machineService.postMachine(this.machineForm.value)
          .subscribe({
            next: (res) => {
              alert("Machine added successfully");
              this.machineForm.reset();
              this.dialogRef.close('save');
            },
            error: () => {
              alert("Error while adding the product")
            }
          })
      }
    }


/*
*/

}
