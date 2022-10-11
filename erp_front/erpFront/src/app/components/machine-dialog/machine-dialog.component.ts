import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {MachineService} from "../../services/machine.service";

@Component({
  selector: 'app-machine-dialog',
  templateUrl: './machine-dialog.component.html',
  styleUrls: ['./machine-dialog.component.scss']
})
export class MachineDialogComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


/*
  addMachine() {
    if (this.machine Form.valid){
      this.apiUrl.postmachine(this.machineForm.value)
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
  }*/

}
