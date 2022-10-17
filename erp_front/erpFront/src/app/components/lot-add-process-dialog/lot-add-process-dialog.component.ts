import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {LotService} from "../../services/lot.service";
import {ProcessService} from "../../services/process.service";
import {MatDialogRef} from "@angular/material/dialog"
import {IProcess} from "../../interfaces/iprocess";


@Component({
  selector: 'app-lot-add-process-dialog',
  templateUrl: './lot-add-process-dialog.component.html',
  styleUrls: ['./lot-add-process-dialog.component.scss']
})
export class LotAddProcessDialogComponent implements OnInit {

  addProcessForm !: FormGroup;
  listProcess!: IProcess[];

  constructor(private formBuilder : FormBuilder, private lotService : LotService, private processService : ProcessService,private dialogRef: MatDialogRef<LotAddProcessDialogComponent>) { }

  ngOnInit(): void {
    this.addProcessForm = this.formBuilder.group({
      id : ['',Validators.required],
      processName : ['',Validators.required]
    })
    this.getAllProcess()
  }

  addProcessInLot(){
    console.log(this.addProcessForm.value)
    if (this.addProcessForm.valid) {
      this.lotService.addProcess(this.addProcessForm.value)
        .subscribe({
          next: (res) => {
            alert("Machine added successfully");
            this.addProcessForm.reset();
            this.dialogRef.close('saveProcess');
          },
          error: () => {
            alert("Error while adding the product")
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
          alert("Error while fetching the Records !!")
        }
      })
  }

}
