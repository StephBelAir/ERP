import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {LotService} from "../../services/lot.service";
import {MatDialogRef} from "@angular/material/dialog"


@Component({
  selector: 'app-lot-add-process-dialog',
  templateUrl: './lot-add-process-dialog.component.html',
  styleUrls: ['./lot-add-process-dialog.component.scss']
})
export class LotAddProcessDialogComponent implements OnInit {

  addProcessForm !: FormGroup

  constructor(private formBuilder : FormBuilder, private lotService : LotService, private dialogRef: MatDialogRef<LotAddProcessDialogComponent>) { }

  ngOnInit(): void {
    this.addProcessForm = this.formBuilder.group({
      id : ['',Validators.required],
      processId : ['',Validators.required]
    })
  }

  addProcessInLot(){
    console.log(this.addProcessForm.value)
    if (this.addProcessForm.valid) {
      this.lotService.addProcess(this.addProcessForm.value)
        .subscribe({
          next: (res) => {
            alert("Machine added successfully");
            this.addProcessForm.reset();
            this.dialogRef.close('save');
          },
          error: () => {
            alert("Error while adding the product")
          }
        })
    }
  }

}
