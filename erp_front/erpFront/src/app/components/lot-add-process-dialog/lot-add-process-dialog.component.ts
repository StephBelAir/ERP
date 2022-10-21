import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from "@angular/forms";
import {LotService} from "../../services/lot.service";
import {ProcessService} from "../../services/process.service";
import {MatDialogRef} from "@angular/material/dialog"
import {IProcess} from "../../interfaces/iprocess";
import {ILot} from "../../interfaces/ilot";
import Swal from "sweetalert2";


@Component({
  selector: 'app-lot-add-process-dialog',
  templateUrl: './lot-add-process-dialog.component.html',
  styleUrls: ['./lot-add-process-dialog.component.scss']
})
export class LotAddProcessDialogComponent implements OnInit {

  listProcess!: IProcess[];
  listLot!: ILot[];
  addProcessForm!: FormGroup;

  constructor(private formBuilder : FormBuilder,
              private lotService : LotService,
              private processService : ProcessService,
              private dialogRef: MatDialogRef<LotAddProcessDialogComponent>) { }

  ngOnInit(): void {
    this.addProcessForm = this.formBuilder.group({
      id : ['',Validators.required],
      processId : ['',Validators.required]
    })
    this.getAllProcess()
    this.getAllLots()
  }

  addProcessInLot(){
    console.log(this.addProcessForm.value)
    if (this.addProcessForm.valid) {
      this.lotService.addProcess(this.addProcessForm.value)
        .subscribe({
          next: (res) => {
            Swal.fire("Process added successfully");
            this.addProcessForm.reset();
            this.dialogRef.close('saveProcess');
          },
          error: () => {
            Swal.fire("Error while adding the product")
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
          Swal.fire("Error while fetching the Records !!")
        }
      })
  }

  getAllLots() {
    this.lotService.getLot()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.listLot = res
          console.log("Process Loaded", this.listLot)
        },
        error: (err) => {
          Swal.fire("Error while fetching the Records !!")
        }
      })
  }

}
