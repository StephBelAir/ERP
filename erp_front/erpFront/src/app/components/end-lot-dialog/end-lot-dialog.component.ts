import { Component, OnInit } from '@angular/core';
import {ILot} from "../../interfaces/ilot";
import {LotService} from "../../services/lot.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-end-lot-dialog',
  templateUrl: './end-lot-dialog.component.html',
  styleUrls: ['./end-lot-dialog.component.scss']
})
export class EndLotDialogComponent implements OnInit {
  listLot!: ILot[];
  endLotForm!: FormGroup;

  constructor( private formBuilder: FormBuilder,
               private lotService: LotService,
               private dialogRef: MatDialogRef<EndLotDialogComponent> ) { }

  ngOnInit(): void {
    this.endLotForm = this.formBuilder.group({
      id : ['',Validators.required],
      actualEndDate : ['',Validators.required]
    })
    this.getAllLots()
  }

  endLot() {
    console.log(this.endLotForm.value)
    if (this.endLotForm.valid) {
      this.lotService.patchEndLot(this.endLotForm.value)
        .subscribe({
          next: (res) => {
            alert("Machine added successfully");
            this.endLotForm.reset();
            this.dialogRef.close('saveProcess');
          },
          error: () => {
            alert("Error while adding the product")
          }
        })
    }
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
          alert("Error while fetching the Records !!")
        }
      })
  }

}
