import { Component, OnInit } from '@angular/core';
import {ILot} from "../../interfaces/ilot";
import {LotService} from "../../services/lot.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material/dialog";
import Swal from 'sweetalert2';


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
            Swal.fire({ title:"End Dates added successfully",
              icon: "success"});
            this.endLotForm.reset();
            this.dialogRef.close('saveEndLot');
          },
          error: () => {
            Swal.fire({ title:"Error while adding the End Dates",
              icon: "error"});
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
          Swal.fire({ title:"Error while fetching the Records !!",
          icon: "error",})
        }
      })
  }

}
